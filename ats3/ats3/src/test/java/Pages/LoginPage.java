package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {

    private By usernameField = By.cssSelector("*[data-test=\"username\"]");
    private By passwordField = By.cssSelector("*[data-test=\"password\"]");
    private By loginButton = By.cssSelector("*[data-test=\"login-button\"]");

    public LoginPage(WebDriver browserDriver) {
        super(browserDriver);
        waitForPageTitle("Swag Labs");
    }

    public ProductsPage login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickOnLoginButton();

        return new ProductsPage(browser);
    }

    private void setUsername(String username) {
        waitUntilVisibility(usernameField);

        findElement(usernameField).clear();
        findElement(usernameField).sendKeys(username);

    }

    private void setPassword(String password) {
        waitUntilVisibility(passwordField);

        findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);
    }

    private void clickOnLoginButton() {
        waitUntilVisibility(loginButton);

        findElement(loginButton).click();
    }
}
