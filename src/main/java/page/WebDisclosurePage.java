package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebDisclosurePage extends BaseWebPage {

    private String spinnerXPath = "//div[@id='loading-gif']";

    public WebDisclosurePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks company hyperlink in the table
     *
     * @param companyName String
     */
    public CompanyVoteCardPage clickCompanyHyperLink (String companyName) {
        List<WebElement> companyList = getElements(WebDisclosurePage.XPATH,
                "//div[@id='grid']//tbody//tr/td[1]");
        for (WebElement currentElement : companyList) {
            if (currentElement.getText().contains(companyName)) {
                currentElement.findElement(By.xpath(".//a")).click();
                return new CompanyVoteCardPage(mDriver);
            }
        }
        return null;
    }

    /**
     * Checks whether 'Country' filter is available on the page
     *
     * @return boolean
     */
    public boolean isCountryFilterAvailable () {
        return isElementPresent(WebDisclosurePage.XPATH, "//div[@id='filter-country']");
    }

    /**
     * Retrieves country names from table and returns it as an ArrayList
     *
     * @return ArrayList
     */
    public ArrayList<String> getCountriesFromTable () {
        ArrayList<String> countryNames = new ArrayList<String>();
        do {
            List<WebElement> countryList = getElements(WebDisclosurePage.XPATH,
                    "//div[@id='grid']//tbody//tr/td[4]");
            for (WebElement currentElement : countryList) {
                countryNames.add(currentElement.getText());
            }
            if (isMorePagesAvailable()) triggerNextPage();
        } while (isMorePagesAvailable());

        return countryNames;
    }

    /**
     * Navigates to WD web app
     */
    public void navigateToWD () {
        mDriver.get("https://viewpoint.glasslewis.com/WD/?siteId=DemoClient");
        waitForTableToLoad();
    }

    /**
     * Performs search in 'Country' filter, by pasting desired country name
     *
     * @param country Desired country name
     */
    public void searchCountryFilter (String country) {
        enterText(WebDisclosurePage.XPATH, "//div[@id='filter-country']//input[@type='search']", country);
    }

    /**
     * Selects desired country from the 'Country' filter
     *
     * @param country Desired country
     */
    public void selectCountryFilter (String country) {
        clickByXPath("//div[@id='filter-country']//label[contains(@id, '" + country + "')]");
    }

    /**
     * Triggers next page in table
     */
    public void triggerNextPage () {
        clickByXPath("//div[@data-role='pager']//a[3]");
        waitForLoad();
    }

    /**
     * Updates results based on 'Country' filter
     */
    public void updateCountryFilter () {
        clickByXPath("//div[@id='filter-country']//button[@id='btn-update']");
        waitForLoad();
    }

    /**
     * Checks whether more pages available
     *
     * @return boolean
     */
    private boolean isMorePagesAvailable () {
        String page = getElementsAttribute(WebDisclosurePage.XPATH,
                "//div[@data-role='pager']//a[3]", "data-page");
        return Integer.parseInt(page) > 1;
    }

    /**
     * Waits for spinner appear and disappear
     */
    private void waitForLoad () {
        waitForVisibilityOfElementByXpath(spinnerXPath);
        waitForInvisibilityOfElementByXpath(spinnerXPath);
    }

    /**
     * Waits for table to load
     */
    private void waitForTableToLoad () {
        waitForVisibilityOfElementByXpath("//div[contains(@class, 'grid-content')]//table[@role='grid']");
    }
}
