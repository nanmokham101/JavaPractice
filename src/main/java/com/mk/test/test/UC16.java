package com.mk.test.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.springframework.web.client.RestClientException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.net.ssl.*;
@Slf4j
public class UC16 {
    public static void main(String[] args) throws IOException {
        String data = "{\"Data\":[{\"area\":[2],\"emp_code\":\"KS3934\",\"Township\":\"Htaukkyant\",\"Main_Road\":\"Htaukkyant\",\"Nearest_Bus_Stop\":\"Htaukkyant Junction\",\"department\":0},{\"area\":[2],\"emp_code\":\"KS3933\",\"Township\":\" North Okkalapa\",\"Main_Road\":\" North Okkalapa\",\"Nearest_Bus_Stop\":\"2th Zay Bus stop\",\"department\":0},{\"area\":[2],\"emp_code\":\"KS3931\",\"Township\":\"Tarmwe\",\"Main_Road\":\"Tarmwe\",\"Nearest_Bus_Stop\":\"Tarmwe A Wine\",\"department\":0},{\"area\":[2],\"emp_code\":\"KS3633\",\"Township\":\"Mayangone\",\"Main_Road\":\"Myo Thit 3rd Street\",\"Nearest_Bus_Stop\":\"Thamine Myo Thit Bus Stop\",\"department\":0},{\"area\":[2],\"emp_code\":\"KS3187\",\"Township\":\"Sanchaung (Ferry No 8)\",\"Main_Road\":\"Zayar Waddy Street \",\"Nearest_Bus_Stop\":\"Zayar Waddy Monastery \",\"department\":0},{\"area\":[2],\"emp_code\":\"KS0192\",\"Township\":\"Tharkayta Township\",\"Main_Road\":\"Zingama Road\",\"Nearest_Bus_Stop\":\"Anawmar Bus Stop\",\"department\":0},{\"area\":[2],\"emp_code\":\"KS3320\",\"Township\":\"Mingalar Taung Nyunt Tsp.\",\"Main_Road\":\"Bo Min Yaung Road\",\"Nearest_Bus_Stop\":\"Thein Phyu Market \",\"department\":0},{\"area\":[2],\"emp_code\":\"MP6456\",\"Township\":\"Pazundaung township\",\"Main_Road\":\"Lower Pazundaung\",\"Nearest_Bus_Stop\":\"MPT TPTC lady hostel\",\"department\":0},{\"area\":[2],\"emp_code\":\"MP7821\",\"Township\":\"Bahan Township\",\"Main_Road\":\"Shwe Gon Dai Road\",\"Nearest_Bus_Stop\":\"Shwe Gon Dai Bus Stop.\",\"department\":0},{\"area\":[2],\"emp_code\":\"KS3902\",\"Township\":\"South Okkalapa tsp\",\"Main_Road\":\"South Okkalapa Pagoda\",\"Nearest_Bus_Stop\":\"moe swe bus stop\",\"department\":0},{\"area\":[2],\"emp_code\":\"KS3912\",\"Township\":\"North Dagon\",\"Main_Road\":\"Pin Lon Road\",\"Nearest_Bus_Stop\":\"??????????? bus stop\",\"department\":0},{\"area\":[2],\"emp_code\":\"KS3911\",\"Township\":\" South Okkalapa \",\"Main_Road\":\"Metta Road\",\"Nearest_Bus_Stop\":\"Women&Children Busstop\",\"department\":0},{\"area\":[2],\"emp_code\":\"KS3920\",\"Township\":\"Mayangone\",\"Main_Road\":\"Yangon-Insein Road\",\"Nearest_Bus_Stop\":\"Kalar Kyaung\",\"department\":0}]}";
        String url ="https://ferryrfid.mpt.com.mm/personnel/api/employees/";
        String token ="a237325b2dc6ce3b032a672b7ce31f8d5c3";

       JSONObject result = update(data,url,token);
    log.info("result :"+result);
    }
    public static String getEmployeeFromRfid(String empCode, String url, String token)
            throws IOException, RestClientException {

        String apiUrl = url + "?emp_code=" + empCode;
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

    public static String getData(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readTree(data);
        } catch (JsonMappingException e) {
            log.error("Exception occured: " + e.getMessage());
        } catch (JsonProcessingException e) {
            log.error("Exception occured: " + e.getMessage());
        }
        String valueSetData = rootNode.get("Data").toString();
        return valueSetData;
    }

    public static JSONObject update(String data, String rfidUrl, String token) {
        JSONObject response = new JSONObject();
        JSONArray successArray = new JSONArray();
        JSONArray failArray = new JSONArray();
        JSONObject jsonObject = new JSONObject(data);
        JSONArray check_data = jsonObject.getJSONArray("Data");
        if (check_data.length() != 0) {
            String[] employeeDataArray = getData(data).split("},", 0);
            for (String a : employeeDataArray) {
                a = a.replace("[{", "").replace("}]", "").replace("{", "").trim();
                if (!a.isEmpty()) {
                    a = "{" + a + "}";
                    JSONObject jsonResponse = new JSONObject(a);
                    String empCode = jsonResponse.getString("emp_code");
                    String result = "";
                    try {
                        result = getEmployeeFromRfid(empCode, rfidUrl, token);
                    } catch (RestClientException | IOException e) {
                        result = "Failed to connect to the API: " + e.getMessage();
                        log.error("Exception occured: " + e.getMessage());
                    }
                    try {
                        if (!result.contains("\"count\": 1")) {
                            log.info("Connection Error occured: " + result);
                            JSONObject responseObj = new JSONObject();
                            responseObj.put("emp_code", empCode);
                            responseObj.put("status_message", result);
                            failArray.put(responseObj);
                        }
                        JSONObject resultJson = new JSONObject(result);
                        int responseCount = resultJson.getInt("count");
                        String responseStr = "";
                        if (responseCount == 1) {
                            int id = resultJson.getJSONArray("data").getJSONObject(0).getInt("id");
                            String office = getStringOrDefault(resultJson, "Office", "");
                            String work_Location = getStringOrDefault(resultJson, "Work_Location", "");
                            String team = getStringOrDefault(resultJson, "Team", "");
                            String dept = getStringOrDefault(resultJson, "Dept", "");
                            String division = getStringOrDefault(resultJson, "Division", "");
                            String office_Tel = getStringOrDefault(resultJson, "Office Tel:", "");
                            String SNR_Ferry_Service = getStringOrDefault(resultJson, "SNR_Ferry_Service", "");

                            jsonResponse.put("Office", office);
                            jsonResponse.put("Work_Location", work_Location);
                            jsonResponse.put("Team", team);
                            jsonResponse.put("Dept", dept);
                            jsonResponse.put("Division", division);
                            jsonResponse.put("Office Tel:", office_Tel);
                            jsonResponse.put("SNR_Ferry_Service", SNR_Ferry_Service);
                            responseStr = "Successful";
                            log.info("RFID update Response for ferry update: "+ responseStr);
                        } else {
                            JSONObject responseObj = new JSONObject();
                            responseObj.put("emp_code", empCode);
                            responseObj.put("status_message", "KissFlow employee id doesn't exist in RFID.");

                            // Check if the failArray already contains an entry for the same emp_code
                            boolean exists = false;
                            for (int i = 0; i < failArray.length(); i++) {
                                JSONObject obj = failArray.getJSONObject(i);
                                if (obj.getString("emp_code").equals(empCode)) {
                                    exists = true;
                                    break;
                                }
                            }
                            // If it doesn't exist, add the response object to failArray
                            if (!exists) {
                                failArray.put(responseObj);
                            }
                        }
                        JSONObject responseObj = new JSONObject();
                        responseObj.put("emp_code", empCode);
                        if (!responseStr.isEmpty()) {
                            responseObj.put("status_message", responseStr);
                        }
                        if (responseStr.contains("Successful")) {
                            successArray.put(responseObj);
                        } else {
                            // Check if the failArray already contains an entry for the same emp_code
                            boolean exists = false;
                            for (int i = 0; i < failArray.length(); i++) {
                                JSONObject obj = failArray.getJSONObject(i);
                                if (obj.getString("emp_code").equals(empCode)) {
                                    exists = true;
                                    break;
                                }
                            }
                            // If it doesn't exist, add the response object to failArray
                            if (!exists) {
                                failArray.put(responseObj);
                            }
                        }
                    } catch (JSONException e) {
                        // Handle JSON parsing exception
                        log.error("Exception occured: " + e.getMessage());
                    } catch (Exception e) {
                        // Handle other exceptions
                        log.error("Exception occured: " + e.getMessage());
                    }
                }
            }
        } else {
            JSONObject responseObj = new JSONObject();
            responseObj.put("msg", "There is no ferry registration or change information at today from KissFlow.");
            failArray.put(responseObj);
        }

        response.put("success", successArray);
        response.put("fail", failArray);
        return response;
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
    public static String getValueSetData(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = null;
        try {
            rootNode = objectMapper.readTree(data);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        String valueSetData = rootNode.get("valueSet").toString();
        return valueSetData;
    }
    private static String getStringOrDefault(JSONObject jsonObject, String key, String defaultValue) {
        String value = jsonObject.getJSONArray("data").getJSONObject(0).optString(key);

        return (value != null && !value.isEmpty()) ? value : defaultValue;
    }
}
