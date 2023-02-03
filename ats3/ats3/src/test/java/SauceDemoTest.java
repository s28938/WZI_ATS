import static org.junit.Assert.assertEquals;

import Pages.LoginPage;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SauceDemoTest {

    public WebDriver browser;

    @Before
    public void setUp() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.navigate().to("https://www.saucedemo.com/");
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(browser);
        loginPage.login("standard_user", "secret_sauce");

        Cookie cookie = browser.manage().getCookieNamed("session-username");
        assertEquals("standard_user", cookie.getValue());
        System.out.println("Uzytkownik zalogowany pomyslnie");
    }

    @Test
    public void orderPlacementTest() {
        LoginPage loginPage = new LoginPage(browser);
        loginPage
                .login("standard_user", "secret_sauce")
                .addElementsToACart(new By[]{By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]"),
                        By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]"),
                        By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")})
                .navigateToACartPage()
                .checkIfAddedProductsArePresent(new By[]{By.cssSelector("#item_4_title_link > .inventory_item_name"),
                        By.cssSelector("#item_5_title_link > .inventory_item_name"),
                        By.cssSelector("#item_1_title_link > .inventory_item_name")
                }, new String[]{"Sauce Labs Backpack", "Sauce Labs Fleece Jacket", "Sauce Labs Bolt T-Shirt"})
                .checkout()
                .provideUserData("XXX", "YYY", "00100")
                .submitCheckout()
                .checkTotalPrice("Total: $103.65")
                .finishPurchase();
    }

    @Test
    public void problemUserTest() {
        LoginPage loginPage = new LoginPage(browser);
        loginPage
                .login("problem_user","secret_sauce")
                .navigateToAProduct(By.cssSelector("#item_4_title_link > .inventory_item_name"))
                .checkWrongTitle();
    }
}