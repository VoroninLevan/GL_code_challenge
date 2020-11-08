package localdriver;

import org.openqa.selenium.WebDriver;

public class LocalDriver {

    public static LocalDriver localDriver = new LocalDriver();
    private WebDriver driver;

    private LocalDriver(){}

    public static LocalDriver getInstance(){
        return localDriver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}
