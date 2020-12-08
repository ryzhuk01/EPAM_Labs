import model.Article;
import model.Size;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.CartPage;
import page.GoodPage;


public class WebDriverShopTest {
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void addingSneakersTest() {
        CartPage cartPage = new GoodPage(driver)
                .openPage()
                .selectedSneakersSize()
                .addToCart()
                .openCart();
        org.junit.Assert.assertTrue(cartPage.actualSizeSelected().contains(Size.RU42.getSize()));
        org.junit.Assert.assertTrue(cartPage.getSneakersArticle().contains(Article.US1.getArticle()));
    }

    @Test
    public void cartAfterDeleting(){
        CartPage cartPage = new GoodPage(driver)
                .openPage()
                .selectedSneakersSize()
                .addToCart()
                .openCart()
                .deleteFromCart()
                .openCart();
        Assert.assertEquals("Ваша корзина пуста!",cartPage.checkCart());
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
