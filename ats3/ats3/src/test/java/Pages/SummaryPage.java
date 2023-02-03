package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SummaryPage extends Base{

    private By total = By.cssSelector(".summary_total_label");
    private By finishButton = By.cssSelector("*[data-test=\"finish\"]");

    public SummaryPage(WebDriver browserDriver) {
        super(browserDriver);
        waitForPageTitle("Swag Labs");
    }

    public SummaryPage checkTotalPrice(String target) {
        waitUntilVisibility(total);

        assertThat(findElement(total).getText(), equalTo(target));
        System.out.println("Kwota sie zgadza");
        return this;
    }

    public CheckoutPage finishPurchase() {
        waitUntilVisibility(finishButton);

        findElement(finishButton).click();

        return new CheckoutPage(browser);
    }
}
