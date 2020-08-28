package apiEngine.model.project.endPoints;

import apiEngine.model.project.request.User;
import apiEngine.model.project.response.UserResponse;
import apiEngine.model.project.response.Users;
import apiEngine.restResponse.IRestResponse;
import apiEngine.restResponse.RestResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;

public class EndPoints {
    private final RequestSpecification request;

    public EndPoints(String baseUrl, int port) {
        RestAssured.baseURI = baseUrl;
        RestAssured.port = port;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }

    public EndPoints(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }


    public IRestResponse<UserResponse> addUser(User campaign) {
        Response response = request.log().uri().body(campaign).post(Rout.users());
        return new RestResponse(UserResponse.class, response);
    }


    public IRestResponse<UserResponse> updateUser(User campaign, int id) {
        Response response = request.log().uri().body(campaign).put(Rout.usersId(id));
        return new RestResponse(UserResponse.class, response);
    }


    public IRestResponse<UserResponse> deleteUser(int id) {
        Response response = request.log().uri().delete(Rout.usersId(id));
        return new RestResponse(UserResponse.class, response);
    }

    public IRestResponse<UserResponse> getUserId(int id) {
        Response response = request.log().uri().get(Rout.usersId(id));
        return new RestResponse(UserResponse.class, response);
    }

    public IRestResponse<UserResponse> getUserInfo() {
        Response response = request.log().uri().get(Rout.users());
        return new RestResponse(UserResponse.class, response);
    }

    public IRestResponse<UserResponse> getUserInfo(HashMap requestParams) {
        Response response = request.log().all().queryParams(requestParams).get(Rout.users());
        return new RestResponse(UserResponse.class, response);
    }

    public IRestResponse<Users> getUsers(int customerId) {
        Response response = request.log().uri().get(Rout.userId(customerId));
        return new RestResponse(Users.class, response);
    }

    public IRestResponse<Users> putUsers(int customerId, List<String> strings) {
        Response response = request.log().uri().body(strings).put(Rout.userId(customerId));
        return new RestResponse(Users.class, response);
    }

    public IRestResponse<Users> deleteUsers(int customerId, List<String> strings) {
        Response response = request.log().uri().body(strings).put(Rout.deleteUserId(customerId));
        return new RestResponse(Users.class, response);
    }
}
