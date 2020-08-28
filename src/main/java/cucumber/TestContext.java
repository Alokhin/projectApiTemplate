package cucumber;

import apiEngine.model.project.endPoints.EndPoints;


public class TestContext {

    private EndPoints endPoints;
    private ScenarioContext scenarioContext;
    String urlBase = "";

    public TestContext() {
        //endPoints = new EndPoints(ConfigReader.getInstance().getBaseUrl(urlBase));
        scenarioContext = new ScenarioContext();
    }

    public EndPoints getEndPoints() {
        return endPoints;
    }


        public String setUrl(String url){

            urlBase = url;
                return urlBase ;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
