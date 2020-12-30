package page;


import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends AbstractPage {
    public static String priceAfter;
    public static String priceBefore;
    private final String summaryPriceAfterPromo ="//*[@class = 'promoCodeAnswerText']";
    private final String summaryPrice = "//div[@class = 'allPrice']/span/i";
    private final Logger logger = LogManager.getRootLogger();
    private final String showPromoField = "//a[@class = 'promoCodeRun pseudo']";
    private final String promoField = "//div[@class = 'promoCodeWr']/input[@name='promo']";
    private final String sneakersCount = "//div[@class = 'cartTable']/div[1]/div[2]/div[2]/span";
    private final String secondSneakersCount = "//div[@class = 'cartTable']/div[2]/div[2]/div[2]/span";
    private final String sneakersPrice = "//div[@class = 'cartTable']/div[1]/div[2]/div[3]/span";
    private final String secondSneakersPrice = "//div[@class = 'cartTable']/div[2]/div[2]/div[3]/span";
    private final String secondSneakersArticle = "//div[@class = 'cartTable']/div[2]/div[1]/div[2]/span";
    private final String sneakersArticle = "//div[@class = 'cartTable']/div[1]/div[1]/div[2]/span";
    private final String sizeSelected = "//b[@itemcart=102640]";
    private final String secondSizeSelected = "//b[@itemcart=102409]";
    private final String deleteFromCart ="//a[@name='delete-item-cart']";
    private final String checkCart="//h1[text()= 'Ваша корзина пуста!']";
    private final String enterPromo="//input[@class = 'greenButton']";

    public CartPage(WebDriver driver){super(driver);}
    public String getSummaryValidPrice() {
        waitForElementLocatedBy(driver, By.xpath(summaryPriceAfterPromo), WAIT_TIME_SECONDS);
        return waitForElementLocatedBy(driver, By.xpath(summaryPrice), WAIT_TIME_SECONDS).getText();
    }
    public String getSummaryInvalidPrice() {
        return waitForElementLocatedBy(driver, By.xpath(summaryPrice), WAIT_TIME_SECONDS).getText();
    }

    public String getSummaryPriceBefore() {
        return waitForElementLocatedBy(driver, By.xpath(summaryPrice), WAIT_TIME_SECONDS).getText();
    }
    public String getSneakersCount() {
        return waitForElementLocatedBy(driver, By.xpath(sneakersCount), WAIT_TIME_SECONDS).getText();
    }
    public String getSecondSneakersPrice() {
        return waitForElementLocatedBy(driver, By.xpath(secondSneakersPrice), WAIT_TIME_SECONDS).getText();
    }
    public String getSneakersPrice() {
        return waitForElementLocatedBy(driver, By.xpath(sneakersPrice), WAIT_TIME_SECONDS).getText();
    }
    public String getSecondSneakersCount() {
        return waitForElementLocatedBy(driver, By.xpath(secondSneakersCount), WAIT_TIME_SECONDS).getText();
    }
    public String getSecondSneakersArticle() {
        return waitForElementLocatedBy(driver, By.xpath(secondSneakersArticle), WAIT_TIME_SECONDS).getText();
    }
    public String getSneakersArticle() {
        return waitForElementLocatedBy(driver, By.xpath(sneakersArticle), WAIT_TIME_SECONDS).getText();
    }
    public String actualSecondSizeSelected() {
        return waitForElementLocatedBy(driver, By.xpath(secondSizeSelected), WAIT_TIME_SECONDS).getText();
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
    public CartPage showPromoField(){
        WebElement showPromoFieldButton = waitForElementLocatedBy(driver,
                By.xpath(showPromoField),WAIT_TIME_SECONDS);
        showPromoFieldButton.click();
        return this;
    }
    public CartPage confirmPromo(){
        WebElement addPromoButton = waitForElementLocatedBy(driver,
                By.xpath(enterPromo),WAIT_TIME_SECONDS);
        addPromoButton.click();
        return this;
    }
    public CartPage typePromo(User user){

        /*WebElement showPromoFieldButton = waitForElementLocatedBy(driver,
                By.xpath(showPromoField),WAIT_TIME_SECONDS);

        showPromoFieldButton.click();
*/
        priceBefore=getSummaryPriceBefore();

        WebElement promocode = waitForElementLocatedBy(driver,
                By.xpath(promoField),WAIT_TIME_SECONDS);
        promocode.sendKeys(user.getPromo());
/*

        WebElement addPromoButton = waitForElementLocatedBy(driver,
                By.xpath(enterPromo),WAIT_TIME_SECONDS);
        addPromoButton.click();
*/

        return this;
    }

    public String checkCart() {
        return waitForElementLocatedBy(driver,
                By.xpath(checkCart), WAIT_TIME_SECONDS).getText();
    }
}
