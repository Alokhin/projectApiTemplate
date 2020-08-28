package internalCampaignTest.stepDefinitions;

import apiEngine.Verify;
import apiEngine.model.project.request.User;
import apiEngine.model.project.response.UserResponse;
import apiEngine.model.project.response.Users;
import apiEngine.restResponse.IRestResponse;
import cucumber.TestContext;
import internalCampaignTest.baseStep.BaseStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashMap;


public class UserSteps extends BaseStep {

    public UserSteps(TestContext testContext) {
        super(testContext, "base_Url");
    }


    private IRestResponse<UserResponse> userResponse;
    private IRestResponse<Users> users;


    @Given("^Give all User$")
    public void getAllUserTest() {
        userResponse = getEndPoints().getUserInfo();
        System.out.println(userResponse.getContent());
        System.out.println(userResponse.getStatusCode());
        Assert.assertTrue(userResponse.isSuccessful());
        Assert.assertEquals( "",200, userResponse.getStatusCode());
        Assert.assertFalse("Response shouldn't be empty, but it's", userResponse.getContent().isEmpty());
    }

    @Then("^Check that all campaigns are displayed")
    public void checkThatAllUserAreDisplayed() {
        Assert.assertTrue(userResponse.isSuccessful());
        Assert.assertEquals( "",200, userResponse.getStatusCode());
        Assert.assertFalse("Response shouldn't be empty, but it's", userResponse.getContent().isEmpty());
    }

    @Given("^Give id's user$")
    public void getUserIdTest() {
        userResponse = getEndPoints().getUserId(424);
        System.out.println(userResponse.getContent());
        Verify.campaignIdIsValid(userResponse.getBody().getId(), 424);
    }

    @Then("^Check that id's user is displayed$")
    public void checkThatIdUserIsDisplayed() {
        Verify.campaignIdIsValid(userResponse.getBody().getId(), 424);
    }


    @Given("^Give all customer$")
    public void getUserWithQueryParamsTest() {
        HashMap requestParams = new HashMap();
        requestParams.put("device", "mobila");
        requestParams.put("user", "");

        userResponse = getEndPoints().getUserInfo(requestParams);
        System.out.println(userResponse.getContent());
        Assert.assertEquals( "",200, userResponse.getStatusCode());
        Assert.assertFalse("Response shouldn't be empty, but it's", userResponse.getContent().isEmpty());
    }

    //TODO make assert more information
    @Then("^Check that all customer's is displayed$")
    public void checkThat() {
        Assert.assertEquals( "",200, userResponse.getStatusCode());
        Assert.assertFalse("Response shouldn't be empty, but it's", userResponse.getContent().isEmpty());

    }


    //------------------------------Post campaign
    int idCampaign;

    @When("^Add new user$")
    public void postUserTest() {
        userResponse = getEndPoints().addUser(User.jsonCreateCampaign());
        System.out.println( userResponse.getBody().getId());
        idCampaign = userResponse.getBody().getId();
    }


    @Then("^User is created$")
    public void checkThatUserIsAdd() {
        Assert.assertTrue(userResponse.isSuccessful());
        Assert.assertEquals( "",200, userResponse.getStatusCode());
    }


    @When("^I update user$")
    public void updateUserTest() {
        userResponse = getEndPoints().updateUser(User.updateCampaignJson(), idCampaign);
        System.out.println(userResponse.getContent());
        System.out.println(userResponse.getStatusCode());
        Assert.assertTrue(userResponse.isSuccessful());
        Assert.assertEquals( "",200, userResponse.getStatusCode());
        Assert.assertFalse("Response shouldn't be empty, but it's", userResponse.getContent().isEmpty());
    }
//
//    @Then("")
//    public void checkThatUserIsUpdated() {
//
//    }
//
    @When("^I deleted user$")
    public void deleteUserTest() {
        userResponse = getEndPoints().deleteUser(idCampaign);
        System.out.println(userResponse.getContent());
        System.out.println(userResponse.getStatusCode());
        Assert.assertTrue(userResponse.isSuccessful());
        Assert.assertEquals( "",200, userResponse.getStatusCode());
        Assert.assertFalse("Response shouldn't be empty, but it's", userResponse.getContent().isEmpty());
        System.out.println("is deleted");
    }
//
//    @Then("")
//    public void checkThatDeleted(){
//
//    }


}
