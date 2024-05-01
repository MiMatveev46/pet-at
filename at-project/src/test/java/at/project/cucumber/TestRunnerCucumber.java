package at.project.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:/cucumber/feature",
        glue = {"at"}
)
public class TestRunnerCucumber {
}
