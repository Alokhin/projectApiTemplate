package internalCampaignTest.baseStep;


import apiEngine.model.project.endPoints.EndPoints;
import config.ConfigReader;
import cucumber.ScenarioContext;
import cucumber.TestContext;

public class BaseStep {

    private EndPoints endPoints;
    private ScenarioContext scenarioContext;

//    public BaseStep() {
//       // endPoints = new EndPoints(ConfigReader.getInstance().getBaseUrl("base_Url"));
//    }

    public BaseStep(TestContext testContext, String url) {
        endPoints = new EndPoints(ConfigReader.getInstance().getBaseUrl(url));
        endPoints = getEndPoints();
        scenarioContext = testContext.getScenarioContext();
    }

    public EndPoints getEndPoints() {
        return endPoints;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

}
