package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends AbstractPage {
    private final String sneakersArticle = "//div[@class = 'nameWr']/span";
    private final String sizeSelected = "//b[@itemcart=102640]";
    private final String deleteFromCart ="//a[@name='delete-item-cart-shop']";
    private final String checkCart="//h1[text()= 'Ваша корзина пуста!']";

    public CartPage(WebDriver driver){super(driver);}

    public String getSneakersArticle() {
        return waitForElementLocatedBy(driver, By.xpath(sneakersArticle), WAIT_TIME_SECONDS).getText();
    }

    public String actualSizeSelected() {
        return waitForElementLocatedBy(driver, By.xpath(sizeSelected), WAIT_TIME_SECONDS).getText();
    }

    public CartPage deleteFromCart() {
        WebElement deleteButton = waitForElementLocatedBy(driver,
                By.xpath(deleteFromCart),WAIT_TIME_SECONDS);
        deleteButton.click();
        return this;
    }

    public String checkCart() {
        return waitForElementLocatedBy(driver,
                By.xpath(checkCart), WAIT_TIME_SECONDS).getText();
    }
}
