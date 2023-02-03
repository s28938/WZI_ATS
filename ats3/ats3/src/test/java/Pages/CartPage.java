package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartPage extends Base{

    private By checkoutButton = By.cssSelector("*[data-test=\"checkout\"]");

    public CartPage(WebDriver browserDriver) {
        super(browserDriver);
        waitForPageTitle("Swag Labs");
    }

    public CartPage checkIfAddedProductsArePresent(By[] products, String[] titles) {
        for (int i = 0; i < products.length; i++) {
            assertThat(getProductTitle(products[i]), equalTo(titles[i]));
        }

        return this;
    }
    private String getProductTitle(By element) {
        waitUntilVisibility(element);
        return findElement(element).getText();
    }
    public CheckoutPage checkout() {
        waitUntilVisibility(checkoutButton);
        findElement(checkoutButton).click();

        return new CheckoutPage(browser);
    }


}
