package localdriver;

import org.openqa.selenium.WebDriver;

/**
 * Singleton class to store local instance of web driver received from TinyUIChef
 */
public class LocalDriver {

    public static LocalDriver localDriver = new LocalDriver();
    private WebDriver driver;

    private LocalDriver(){}

    /**
     * Returns class object instance
     *
     * @return LocalDriver
     */
    public static LocalDriver getInstance(){
        return localDriver;
    }

    /**
     * Setter for web driver
     *
     * @param driver WebDriver
     */
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Getter for web driver
     *
     * @return WebDriver
     */
    public WebDriver getDriver(){
        return this.driver;
    }
}
