package uc16;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestClientException;

import java.io.IOException;

@Slf4j
public class FerryChange {
    public static void main(String[] args) {
        String data = "{\n" +
                "\"Data\": [\n" +
                "    {\n" +
                "        \"area\": [\n" +
                "            2\n" +
                "        ],\n" +
                "        \"emp_code\": \"MP2170\",\n" +
                "        \"department\": 1\n" +
                "    },\n" +
                "    {\n" +
                "        \"area\": [\n" +
                "            2\n" +
                "        ],\n" +
                "        \"emp_code\": \"MP1621\",\n" +
                "        \"Township\": \"test Tsp\",\n" +
                "        \"Main_Road\": \" test Road\",\n" +
                "        \"Nearest_Bus_Stop\": \"test Bus stop\",\n" +
                "        \"department\": 3\n" +
                "    }\n" +
                "]\n" +
                "}";
        JSONObject result = update(data, "https://ferryrfid.mpt.com.mm/personnel/api/employees/", "b2ff58a7e0ebe4aa1087deb8134d1bb3e0d02bd6");
        log.info(result.toString());
    }

    public static JSONObject update(String data, String rfidUrl, String token) {
        JSONObject response = new JSONObject();
        JSONArray successArray = new JSONArray();
        JSONArray failArray = new JSONArray();

        JSONObject dataObject = new JSONObject(data);
        JSONArray checkData = dataObject.optJSONArray("Data");

        if (checkData == null || checkData.length() == 0) {
            JSONObject responseObj = new JSONObject();
            responseObj.put("msg", "No ferry registration or change information today.");
            failArray.put(responseObj);
            response.put("success", successArray);
            response.put("fail", failArray);
            return response;
        }

        for (int i = 0; i < checkData.length(); i++) {
            JSONObject employeeObj = checkData.getJSONObject(i);
            String empCode = employeeObj.optString("emp_code", " ");

            if (empCode.trim().isEmpty()) {
                continue; // Skip if emp_code is missing
            }
            String result = "";
            try {
                result = GetEmployee.getEmployeeFromRfid(empCode, rfidUrl, token);
                log.info("Get Employee by Id from RFID: " + result);
            } catch (RestClientException | IOException e) {
                result = "Failed to connect to the API: " + e.getMessage();
                log.error("Exception occurred: " + e.getMessage());
            }

            try {
                if (!result.contains("\"count\": 1")) {
                    log.info("Error occurred: " + result);
                    JSONObject failResponseObj = new JSONObject();
                    failResponseObj.put("emp_code", empCode);
                    failResponseObj.put("status_message", "KissFlow employee id doesn't exist in RFID.");
                    failArray.put(failResponseObj);
                    continue;
                }

                JSONObject resultData = new JSONObject(result);
                int responseCount = resultData.optInt("count", 0);
                if (responseCount == 1) {
                    int id = resultData.getJSONArray("data").getJSONObject(0).optInt("id", -1);

                    JSONObject requestData = new JSONObject();

                    // Add "area" field from the input data
                    requestData.put("area", employeeObj.optJSONArray("area"));

                    // Fill required fields with actual or default values
                    requestData.put("Office", getStringOrNull(resultData, "Office"));
                    requestData.put("Work_Location", getStringOrNull(resultData, "Work_Location"));

                    requestData.put("Township", getStringWithPriority(resultData, employeeObj, "Township"));
                    requestData.put("Main_Road", getStringWithPriority(resultData, employeeObj, "Main_Road"));
                    requestData.put("Nearest_Bus_Stop",
                            getStringWithPriority(resultData, employeeObj, "Nearest_Bus_Stop"));

                    requestData.put("Team", getStringOrNull(resultData, "Team"));
                    requestData.put("Dept", getStringOrNull(resultData, "Dept"));
                    requestData.put("Division", getStringOrNull(resultData, "Division"));
                    requestData.put("Office Tel:", getStringOrNull(resultData, "Office Tel:"));
                    requestData.put("SNR_Ferry_Service", getStringOrNull(resultData, "SNR_Ferry_Service"));
                    requestData.put("department", employeeObj.get("department"));


                    log.info("Ferry update data request to call RFID: " + requestData.toString(4));

                    String responseStr = updateEmployee(id, requestData.toString(), rfidUrl, token);
                    log.info("RFID update Response for ferry update: " + responseStr);

                    if (responseStr.contains("Successful")) {
                        JSONObject successObj = new JSONObject();
                        successObj.put("emp_code", empCode);
                        successObj.put("status_message", responseStr);
                        successArray.put(successObj);
                    } else {
                        JSONObject failObj = new JSONObject();
                        failObj.put("emp_code", empCode);
                        failObj.put("status_message", responseStr);
                        failArray.put(failObj);
                    }
                } else {
                    JSONObject failObj = new JSONObject();
                    failObj.put("emp_code", empCode);
                    failObj.put("status_message", "KissFlow employee ID doesn't exist in RFID.");
                    failArray.put(failObj);
                }
            } catch (Exception e) {
                log.error("Exception occurred: " + e.getMessage());
            }
        }

        response.put("success", successArray);
        response.put("fail", failArray);
        return response;
    }

    /**
     * Gets a string value from a JSONObject or returns null if missing.
     */


    private static Object getStringOrNull(JSONObject jsonObject, String key) {
        if (jsonObject.has("data") && jsonObject.getJSONArray("data").length() > 0) {
            JSONObject firstData = jsonObject.getJSONArray("data").getJSONObject(0);
            if (firstData.has(key) && !firstData.isNull(key)) {
                return firstData.getString(key);
            }
        }
        return JSONObject.NULL; // Returns null correctly instead of " "
    }
    private static Object getStringWithPriority(JSONObject resultJson, JSONObject employeeObj, String key) {
        // Check if input data (employeeObj) has a non-empty value
        if (employeeObj.has(key)) {
            String inputValue = employeeObj.optString(key, "").trim();
            if (!inputValue.isEmpty()) {
                return inputValue; // Use input data if present
            }
        }

        // Otherwise, check the GetEmployee API response (resultJson)
        if (resultJson.has("data") && resultJson.getJSONArray("data").length() > 0) {
            JSONObject firstData = resultJson.getJSONArray("data").getJSONObject(0);
            if (firstData.has(key) && !firstData.isNull(key)) {
                return firstData.getString(key); // Use API response if input is missing
            }
        }

        return JSONObject.NULL; //  If both are missing, return null
    }

    private static String updateEmployee(int id, String jsonResponse, String rfidUrl, String token) {
        // Placeholder for actual update logic
        return "success"; // Simulated success response
    }
}

