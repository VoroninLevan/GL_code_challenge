package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebDisclosurePage extends BaseWebPage {

    public WebDisclosurePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCountryFilterAvailable () {
        return isElementPresent(WebDisclosurePage.XPATH, "//div[@id=filter-country]");
    }

    public ArrayList<String> getCountriesFromTable () {
        ArrayList<String> countryNames = new ArrayList<String>();

        while (isMorePagesAvailable()) {
            List<WebElement> countryList = getElements(WebDisclosurePage.XPATH,
                    "//div[@id='grid']//tbody//tr/td[4]");
            for (WebElement currentElement : countryList) {
                countryNames.add(currentElement.getText());
            }
            clickByXPath("//div[@data-role='pager']//a[3]");
        }

        return countryNames;
    }

    public void navigateToWD () {
        mDriver.get("https://viewpoint.glasslewis.com/WD/?siteId=DemoClient");
    }

    public void searchCountryFilter (String country) {
        enterText(WebDisclosurePage.XPATH, "//div[@id='filter-country']//input[@type='search']", country);
    }

    public void selectCountryFilter (String country) {
        clickByXPath(String.format(country, "//div[@id='filter-country']//input[@value='%s']"));
    }

    public void updateCountryFilter () {
        clickByXPath("//div[@id='filter-country']//button[@id='btn-update']");
    }

    private boolean isMorePagesAvailable () {
        String page = getElementsAttribute(WebDisclosurePage.XPATH,
                "//div[@data-role='pager']//a[3]", "data-page");
        return Integer.parseInt(page) > 1;
    }
}
