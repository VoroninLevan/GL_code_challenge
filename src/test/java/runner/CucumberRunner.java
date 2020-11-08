package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/webdisclosure/CountryFilter.feature"},
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty"}
)

public class CucumberRunner {
}
