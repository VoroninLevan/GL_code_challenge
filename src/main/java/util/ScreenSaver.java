package util;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenSaver {

    public ScreenSaver () {}

    /**
     * Takes screenshot on test fail
     *
     * @param driver WebDriver
     */
    public static void takeScreenshot (WebDriver driver, Scenario scenario) {
        String separator = File.separator;
        String scenarioID = scenario.getId();
        String screenshotName = System.currentTimeMillis() + "_" +
                scenarioID.substring(scenarioID.lastIndexOf('/') + 1, scenarioID.lastIndexOf('.'));
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") +
                    separator + "screenshots" +
                    separator + screenshotName));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
