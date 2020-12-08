package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected static final String GOOD_URL = "https://joma.by/item-shops/n10s-2017-fg-butsy-dlya-tverdykh-poley-numero-10";
    protected final long WAIT_TIME_SECONDS = 20;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage openCart() {
        WebElement cartButtonGoTo = waitForElementLocatedBy(driver,
                By.xpath("/html/body/div[9]/div/header/div[2]/div[1]/div[3]/div[6]/a"),WAIT_TIME_SECONDS);
        cartButtonGoTo.click();
        return new CartPage(driver);
    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by, long time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
