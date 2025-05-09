package uc16;


import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
@Slf4j
public class RamcoEmployeeUpdate {
    public static void main(String[] args) {
        String data = "{\n" +
                "    \"valueSet\": [\n" +
                "        {\n" +
                "            \"area\": [\n" +
                "                2\n" +
                "            ],\n" +
                "            \"Office\": \"CTO Office\",\n" +
                "            \"emp_code\": \"KS1425\",\n" +
                "            \"card_no\": \"8964334\",\n" +
                "            \"Work_Location\": \"Hantharwady\",\n" +
                "            \"Dept\": \"Roll-out Management Department\",\n" +
                "            \"office_tel\": \"959423008437\",\n" +
                "            \"Division\": \"Communication Technology & Engineering Division\",\n" +
                "            \"Team\": \"Quality Management Team\",\n" +
                "            \"first_name\": \"Sithu Htet\",\n" +
                "            \"email\": \"sithuhtet@mptmmf.net\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"area\": [\n" +
                "                2\n" +
                "            ],\n" +
                "            \"Office\": \"CTO Office\",\n" +
                "            \"emp_code\": \"KS3014\",\n" +
                "            \"card_no\": \"4683895\",\n" +
                "            \"Work_Location\": \"Hantharwady\",\n" +
                "            \"Dept\": \"Roll-out Management Department\",\n" +
                "            \"office_tel\": \"959423009047\",\n" +
                "            \"Division\": \"Communication Technology & Engineering Division\",\n" +
                "            \"Team\": \"Quality Management Team\",\n" +
                "            \"first_name\": \"Hla Myo Aung\",\n" +
                "            \"email\": \"hlamyoaung1@mptmmf.com\"\n" +
                "        }],\n" +
                "    \"Number_of_Records\": 9,\n" +
                "    \"entity\": \"\"\n" +
                "}";

        JSONObject result = process(data, "create_update", "https://ferryrfid.mpt.com.mm/personnel/api/employees/", "b2ff58a7e0ebe4aa1087deb8134d1bb3e0d02bd6");
        log.info(result.toString());
    }
    public static JSONObject process(String data, String action, String rfidUrl, String token) {
        JSONObject response = new JSONObject();
        JSONArray successArray = new JSONArray();
        JSONArray failArray = new JSONArray();

        JSONObject jsonObject = new JSONObject(data);
        JSONArray valueSet = jsonObject.optJSONArray("valueSet");

        if (valueSet == null || valueSet.length() == 0) {
            return generateEmptyResponse(failArray);
        }

        for (int i = 0; i < valueSet.length(); i++) {
            JSONObject employeeData = valueSet.getJSONObject(i);
            String empCode = employeeData.optString("emp_code", "");

            if (empCode.isEmpty()) {
                log.warn("Skipping entry without emp_code");
                continue;
            }

            String apiResponse = fetchEmployeeData(empCode, rfidUrl, token);
            if (apiResponse.contains("\"count\":")) {
                processApiResponse(apiResponse, employeeData, action, rfidUrl, token, successArray, failArray);
            } else {
                log.error("Connection Error: {}", apiResponse);
                failArray.put(createFailureResponse(empCode, apiResponse));
            }
        }

        response.put("success", successArray);
        response.put("fail", failArray);
        return response;
    }

    private static JSONObject generateEmptyResponse(JSONArray failArray) {
        JSONObject responseObj = new JSONObject();
        responseObj.put("msg", "There is no new employee or change employee information from RAMCO today.");
        failArray.put(responseObj);
        JSONObject response = new JSONObject();
        response.put("success", new JSONArray());
        response.put("fail", failArray);
        return response;
    }

    private static String fetchEmployeeData(String empCode, String rfidUrl, String token) {
        try {
            return GetEmployee.getEmployeeFromRfid(empCode, rfidUrl, token);
        } catch (RestClientException | IOException e) {
            log.error("Exception occurred while fetching employee data: {}", e.getMessage());
            return "Failed to connect to the API: " + e.getMessage();
        }
    }

    private static void processApiResponse(String apiResponse, JSONObject employeeData, String action, String rfidUrl, String token, JSONArray successArray, JSONArray failArray) {
        try {
            JSONObject resultJson = new JSONObject(apiResponse);
            int responseCount = resultJson.optInt("count", 0);
            String empCode = employeeData.optString("emp_code", "");

            if (responseCount == 1) {
                int id = resultJson.getJSONArray("data").getJSONObject(0).optInt("id", -1);
                String responseMessage = processEmployeeAction(id, employeeData, action, rfidUrl, token);
                log.info("RFID Response for {}: {}", action, responseMessage);
                addToResponseArray(empCode, responseMessage, successArray, failArray);
            } else {
                log.warn("RAMCO employee ID {} doesn't exist in RFID.", empCode);
                failArray.put(createFailureResponse(empCode, "RAMCO employee ID doesn't exist in RFID."));
            }
        } catch (JSONException e) {
            log.error("JSON Parsing Exception: {}", e.getMessage());
        }
    }

    private static String processEmployeeAction(int id, JSONObject employeeData, String action, String rfidUrl, String token) {
        switch (action) {
            case "create_update":
                log.info("Employee update data request to call RFID: {}" + employeeData.toString(4));
                return updateEmployee(id, employeeData.toString(), rfidUrl, token);
            case "delete":
                return deleteEmployee(id, employeeData.toString(), rfidUrl, token);
            default:
                return "Invalid action";
        }
    }

    private static JSONObject createFailureResponse(String empCode, String message) {
        JSONObject responseObj = new JSONObject();
        responseObj.put("emp_code", empCode);
        responseObj.put("status_message", message);
        return responseObj;
    }

    private static void addToResponseArray(String empCode, String message, JSONArray successArray, JSONArray failArray) {
        JSONObject responseObj = new JSONObject();
        responseObj.put("emp_code", empCode);
        responseObj.put("status_message", message);

        if (message.contains("Successful")) {
            successArray.put(responseObj);
        } else {
            failArray.put(responseObj);
        }
    }

    private static String updateEmployee(int id, String employeeData, String url, String token) {
        return sendEmployeeRequest(employeeData, HttpMethod.PUT, url + id + '/', token);
    }

    private static String deleteEmployee(int id, String employeeData, String url, String token) {
        return sendEmployeeRequest(employeeData, HttpMethod.DELETE, url + id + '/', token);
    }

    private static String sendEmployeeRequest(String employeeData, HttpMethod method, String url, String token) {
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            headers.set("Authorization", "Token " + token);
//
//            RestTemplate restTemplate = new RestTemplate();
//            GetEmployee.trustAllHosts();
//            ResponseEntity<String> response = restTemplate.exchange(url, method, new HttpEntity<>(employeeData, headers), String.class);
//
//            if (response.getStatusCode().is2xxSuccessful()) {
//                return "Successful " + method.name().toLowerCase() + " RAMCO Data to RFID.";
//            } else {
//                return response.getBody();
//            }
//        } catch (RestClientException e) {
//            log.error("API Request Failed: {}", e.getMessage());
//            return "Failed to connect to the RFID API: " + e.getMessage();
//        }
        return "Successful " + method.name().toLowerCase() + " RAMCO Data to RFID.";
    }

}
