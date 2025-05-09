package uc16;


import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;

public class GetEmployee {
    private static final Logger log = LoggerFactory.getLogger(GetEmployee.class);

    public static String getEmployeeFromRfid(String empCode, String url, String token)
            throws IOException, RestClientException {
        String apiUrl = url + "?emp_code=" + empCode;

        log.info("api url : "+ apiUrl);
        log.info("token :"+ token);
        trustAllHosts();
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");

        connection.setRequestProperty("Authorization", "Token " + token);
        connection.setRequestProperty("Content-Type", "application/json");

        int responseCode = connection.getResponseCode();
        BufferedReader reader;

        // Use input stream for successful requests and error stream for failed ones
        if (responseCode >= 200 && responseCode < 300) {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        String htmlResponse = response.toString();
        Document doc = Jsoup.parse(htmlResponse);
        Element preElement = doc.select("div.response-info pre").first();

        if (preElement != null) {
            String jsonContent = preElement.text();
            return extractJsonFromResponse(jsonContent);
        } else {
            return "Response (Status: " + responseCode + "): " + htmlResponse;
        }
    }

    public static Integer getDepartmentFromRfid(String departmentName, String url, String token) throws IOException {

        Integer departmentId = 0;
        String apiUrl = url + "?dept_name=" + departmentName;
        trustAllHosts();
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");

        connection.setRequestProperty("Authorization", "Token " + token);

        connection.setRequestProperty("Content-Type", "application/json");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            String htmlResponse = response.toString();
            Document doc = Jsoup.parse(htmlResponse);
            Element preElement = doc.select("div.response-info pre").first();
            if (preElement != null) {
                String jsonContent = preElement.text();
                String deptString = extractJsonFromResponse(jsonContent);
                try {
                    JSONObject jsonObject = new JSONObject(deptString);

                    if (jsonObject.has("data")) {
                        JSONArray dataArray = jsonObject.getJSONArray("data");

                        if (dataArray.length() > 0) {
                            JSONObject dataObject = dataArray.getJSONObject(0);

                            if (dataObject.has("id")) {
                                departmentId = dataObject.getInt("id");
                            } else {
                                log.error("dataObject.has null.....");
                                return 0;
                            }
                        } else {
                            log.error("Array is empty......");
                            return 0; // Array is empty
                        }
                    } else {
                        log.error("data field is not present.....");
                        return 0; // "data" field is not present
                    }
                } catch (JSONException e) {
                    log.error(e.getMessage());
                }
            } else {
                log.error("preElement.....");
                return 0;
            }

        } else {
            log.error("HttpURLConnection.HTTP_OK Not.....");
            return 0;
        }
        return departmentId;
    }

    public static String extractJsonFromResponse(String response) {
        int startIndex = response.indexOf('{'); // Find the first occurrence of '{' in the response
        if (startIndex != -1) {
            return response.substring(startIndex); // Extract the JSON content starting from '{'
        } else {
            return "JSON data not found in the response.";
        }
    }

    public static void trustAllHosts() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {

                }

            } };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            HostnameVerifier allHostsValid = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (Exception e) {
            log.error("Exception Occured : " + e.getMessage());
        }
    }
}

