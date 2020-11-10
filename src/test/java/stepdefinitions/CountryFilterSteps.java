package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import localdriver.LocalDriver;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import page.WebDisclosurePage;



import java.util.ArrayList;

public class CountryFilterSteps {

    private WebDisclosurePage webDisclosurePage;
    private ArrayList<String> countryNames;
    private String mCountry;
    private WebDriver mDriver = LocalDriver.getInstance().getDriver();

    @Given("user is on the landing page for WD site")
    public void user_is_on_the_landing_page_for_wd_site() {
        webDisclosurePage = new WebDisclosurePage(mDriver);
        webDisclosurePage.navigateToWD();
    }

    @Given("The Country filter is available")
    public void the_country_filter_is_available() {
        Assert.assertTrue("Country filter is not available", webDisclosurePage.isCountryFilterAvailable());
    }

    @When("User selects {string} from the Country filter list on left panel")
    public void user_selects_from_the_country_filter_list_on_left_panel(String country) {
        webDisclosurePage.searchCountryFilter(country);
        webDisclosurePage.selectCountryFilter(country);
    }

    @When("Clicks on Update button for the country filter list")
    public void clicks_on_update_button_for_the_country_filter_list() {
        webDisclosurePage.updateCountryFilter();
    }

    @Then("The grid displays all meetings that are associated with the country {string}")
    public void the_grid_displays_all_meetings_that_are_associated_with_the_country(String country) {
        countryNames = webDisclosurePage.getCountriesFromTable();
        mCountry = country;
    }

    @Then("No meetings associated with any other country appear on the list")
    public void no_meetings_associated_with_any_other_country_appear_on_the_list() {
        for (String currentName : countryNames){
            Assert.assertTrue("Other meetings not associated with " + mCountry + " are displayed",
                    currentName.contains(mCountry));
        }
    }
}
