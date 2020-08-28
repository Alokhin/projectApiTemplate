package apiEngine;

import apiEngine.model.project.response.UserResponse;
import apiEngine.restResponse.IRestResponse;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Verify {


    public static String getIntValue(Response response, String value) {
        String intValueFromJson = response.jsonPath().getString(value);
        return intValueFromJson;
    }

    public static void responseIsNotEmpty(Response response) {
        //Assert.assertFalse(response.getBody().toString().isEmpty(), "Response shouldn't be empty, but it's");
    }

    public static void responseIsNotEmpty(IRestResponse<UserResponse> userResponse) {
       // Assert.assertFalse(campaignResponse.getContent().isEmpty(), "Response shouldn't be empty, but it's");
        System.out.println(userResponse);

    }
    public static void statusCodeIs200(IRestResponse<UserResponse> userResponse) {
      //  Assert.assertEquals(200, userResponse.getStatusCode(),"Status code should be 200, but it's not");

    }

    public static void statusCodeIs200(Response response) {
      //  Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200, but it's not");
    }

    public static void userIdIsValid(Response response, int expectedId) {
      //  Assert.assertEquals(response.jsonPath().getInt("id"), expectedId, "Campaigns id should be same, but it's not");
    }

    public static void campaignIdIsValid(int actualId, int expectedId) {
       // Assert.assertEquals(actualId, expectedId, "Campaign id should be same, but it's not");
    }

    public static void sizeJsonBody(Response response, int isEqualTo) {
        String responseBodyString = response.getBody().asString();
        System.out.println(responseBodyString);
        assertThat(from(responseBodyString).getList("$").size()).isEqualTo(isEqualTo);
    }


    public static Response equalToValue(Response response, String paramJson, String equalToValue) {
        response.then().body(paramJson, equalTo(equalToValue));
        return response;
    }

    public static Response equalToValue(Response response, String paramJson, int equalToValue) {
        response.then().body(paramJson, equalTo(equalToValue));
        return response;
    }

    public static Response equalToValue(Response response, String paramJson, boolean equalToValue) {
        response.then().body(paramJson, equalTo(equalToValue));
        return response;
    }


    public static Response validateJsonSchema(Response response, String jsonSchemaName) {
    //    response.then().body(matchesJsonSchemaInClasspath(jsonSchemaName));
        return response;
    }

    public static List<String> getListFromJson(Response response, String keyJsonObject, String keyJsonArray) {
        List<String> items = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(response);
        JSONArray jsonArray = jsonObject.getJSONObject(keyJsonObject).getJSONArray(keyJsonArray);
        for (int i = 0; i < jsonArray.length(); i++) {
            items.add(jsonArray.get(i).toString());
        }
        return items;
    }

    public ArrayList getClients (JsonPath jp) {
        ArrayList clientList = jp.get();
        return clientList;
    }

}

