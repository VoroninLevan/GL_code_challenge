package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import localdriver.LocalDriver;
import provider.Driver;
import provider.ParameterReader;
import test.BaseWebTest;

public class Hooks extends BaseWebTest {

    @Before
    public void beforeMethod (){
        ParameterReader reader = new ParameterReader();
        Driver driver = new Driver(reader);
        mDriver = driver.getDriver();
        LocalDriver.getInstance().setDriver(mDriver);
    }

    @After
    public void afterMethod(Scenario scenario) {
        if (scenario.isFailed()){
            // TODO - implement screenshoting
        }
        mDriver.close();
    }
}
