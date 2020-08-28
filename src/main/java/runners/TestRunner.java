package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        strict = true,
        features = "src/main/resources/apiTests",
        glue = {"userTest/stepDefinitions"},
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                             "html:target/cucumber-reports"},
//       // tags = "@regression",
        monochrome = true,
        strict = true

)
public class TestRunner {
}
