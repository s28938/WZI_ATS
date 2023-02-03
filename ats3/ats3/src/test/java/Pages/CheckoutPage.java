package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends Base {
    private By firstNameField = By.cssSelector("*[data-test=\"firstName\"]");
    private By lastNameField = By.cssSelector("*[data-test=\"lastName\"]");
    private By postalCodeField = By.cssSelector("*[data-test=\"postalCode\"]");
    private By continueButton = By.cssSelector("*[data-test=\"continue\"]");

    public CheckoutPage(WebDriver browserDriver) {
        super(browserDriver);
        waitForPageTitle("Swag Labs");
    }

    public CheckoutPage provideUserData(String firstName, String lastName, String postalCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);

        return this;
    }

    public SummaryPage submitCheckout() {
        waitUntilVisibility(continueButton);

        findElement(continueButton).click();

        return new SummaryPage(browser);
    }

    private void setFirstName(String firstName) {
        waitUntilVisibility(firstNameField);

        findElement(firstNameField).clear();
        findElement(firstNameField).sendKeys(firstName);
    }

    private void setLastName(String lastName) {
        waitUntilVisibility(lastNameField);

        findElement(lastNameField).clear();
        findElement(lastNameField).sendKeys(lastName);
    }

    private void setPostalCode(String postalCode) {
        waitUntilVisibility(postalCodeField);

        findElement(postalCodeField).clear();
        findElement(postalCodeField).sendKeys(postalCode);
    }

}
