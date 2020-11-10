import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/webdisclosure/"},
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty",
                "html:reports/html",
                "json:reports/json/report.json",
                "junit:reports/xml/report.xml"}
)

public class RunCucumberTest {
}
