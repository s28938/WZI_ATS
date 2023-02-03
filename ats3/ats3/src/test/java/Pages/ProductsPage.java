package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertNotEquals;

public class ProductsPage extends Base{

    private By cart = By.cssSelector("#shopping_cart_container > a");
    private By title = By.cssSelector(".inventory_details_name");
    private String chosenProductTitle;

    public ProductsPage(WebDriver browserDriver) {
        super(browserDriver);
        waitForPageTitle("Swag Labs");
    }

    public ProductsPage addElementsToACart(By[] elements) {
        for (int i = 0; i < elements.length; i++) {
            addAnElementToACart(elements[i]);
        }

        return this;
    }

    private void addAnElementToACart(By element) {
        waitUntilVisibility(element);
        findElement(element).click();
    }

    public ProductsPage checkWrongTitle() {
        assertNotEquals(findElement(title).getText(), chosenProductTitle);
        System.out.println("Ten uzytkownik nie moze wybrac produktu");
        return this;
    }
    public CartPage navigateToACartPage() {
        waitUntilVisibility(cart);

        findElement(cart).click();

        return new CartPage(browser);
    }
    public ProductsPage navigateToAProduct(By product) {
        waitUntilVisibility(product);

        String title =  findElement(product).getText();
        findElement(product).click();

        return new ProductsPage(browser);
    }
}
