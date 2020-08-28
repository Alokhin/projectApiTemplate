package internalCampaignTest.stepDefinitions;

import apiEngine.model.project.response.Users;
import apiEngine.restResponse.IRestResponse;
import apiEngine.restResponse.RestResponse;
import cucumber.TestContext;
import internalCampaignTest.baseStep.BaseStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static io.restassured.path.json.JsonPath.from;
import static org.assertj.core.api.Assertions.assertThat;


public class CustomerSteps extends BaseStep {

    public CustomerSteps(TestContext testContext) {
        super(testContext,"base_Url");
    }

    private IRestResponse<Users> users;


    @Given("^Give customers from campaigns$")
    public void getCustomerTest() {
        users = getEndPoints().getUsers(963);
        assertThat(from(users.getContent()).getList("$").size()).isEqualTo(1);
        System.out.println(users.getContent());
        Assert.assertEquals( "",200, users.getStatusCode());
    }


    @When("^Add customers to campaign$")
    public void putCustomerTest() {
        users = getEndPoints().putUsers(963, RestResponse.customersIds("21599653", "21606775"));
        System.out.println(users.getContent());
        Assert.assertEquals( "",200, users.getStatusCode());
    }

    @Then("^Check that the customers are added$")
    public void checkThatCustomersAreAdded() {
        users = getEndPoints().getUsers(963);
        System.out.println(users.getContent());
        assertThat(from(users.getContent()).getList("$").size()).isEqualTo(3);
    }


    @When("^Remove customers from campaign$")
    public void deleteCustomerTest() {
        users = getEndPoints().deleteUsers(963, RestResponse.customersIds("21599653", "21606775"));
        System.out.println(users.getContent());
        Assert.assertEquals( "",200, users.getStatusCode());
    }

    @Then("^Check that the customers are removed$")
    public void checkThatCustomerAreRemoved() {
        users = getEndPoints().getUsers(963);
        assertThat(from(users.getContent()).getList("$").size()).isEqualTo(1);
        System.out.println(users.getContent());
        Assert.assertEquals("", 200, users.getStatusCode());


    }
}
