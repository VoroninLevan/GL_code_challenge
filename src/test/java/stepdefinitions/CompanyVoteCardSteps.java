package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import localdriver.LocalDriver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.CompanyVoteCardPage;
import page.WebDisclosurePage;

public class CompanyVoteCardSteps {

    private WebDisclosurePage webDisclosurePage;
    private CompanyVoteCardPage voteCardPage;
    private WebDriver mDriver = LocalDriver.getInstance().getDriver();

    @Given("User is on the landing page for WD site")
    public void user_is_on_the_landing_page_for_wd_site() {
        webDisclosurePage = new WebDisclosurePage(mDriver);
        webDisclosurePage.navigateToWD();
    }

    @When("User clicks the Company Name {string} hyperlink")
    public void user_clicks_the_company_name_hyperlink(String companyName) {
        webDisclosurePage.triggerNextPage();
        voteCardPage = webDisclosurePage.clickCompanyHyperLink(companyName);
    }

    @Then("The user lands onto the {string} vote card page.")
    public void the_user_lands_onto_the_vote_card_page(String companyName) {

    }

    @Then("{string} should appear in the top banner")
    public void should_appear_in_the_top_banner(String companyName) {
        Assert.assertTrue("", voteCardPage.getHeader().contains(companyName));
    }
}
