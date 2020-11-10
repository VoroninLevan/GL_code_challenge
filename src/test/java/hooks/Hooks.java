package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import localdriver.LocalDriver;
import provider.Driver;
import provider.ParameterReader;
import test.BaseWebTest;
import util.ScreenSaver;

public class Hooks extends BaseWebTest {

    private boolean mHeadless;

    @Before
    public void beforeMethod (){
        ParameterReader reader = new ParameterReader();
        Driver driver = new Driver(reader);
        mDriver = driver.getDriver();
        mHeadless = driver.getHeadless();
        LocalDriver.getInstance().setDriver(mDriver);
    }

    @After
    public void afterMethod(Scenario scenario) {
        if (scenario.isFailed() && !mHeadless) ScreenSaver.takeScreenshot(mDriver, scenario);
        mDriver.close();
    }
}
