package page;

import org.openqa.selenium.WebDriver;

public class CompanyVoteCardPage extends WebDisclosurePage {

    public CompanyVoteCardPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Returns header text (company name)
     *
     * @return String
     */
    public String getHeader () {
        return getElementText(CompanyVoteCardPage.XPATH, "//h2[@id='detail-issuer-name']");
    }
}
