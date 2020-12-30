package page;

import model.Good;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class GoodPage extends AbstractPage{
    @FindBy(xpath ="//*[@action=\\\"https://www.facebook.com/tr/\\\"]")
    private WebElement invalidSending;

    private final String countField= "//input[@class='qt form-control']";
    private final String validSending= "//img[@src='/images/ok.png']";
    private final String sendRequest= "//*[@type='submit'][@class ='blueButton']";
    private final String telephoneField= "//*[@name='tel'][@cls]";
    private final String firstNameField= "//*[@name='name'][@cls]";
    private final String emailField= "//*[@type='email'][@cls]";
    private final String findOutPrice= "//a[@name='popup-click']";
    private final String selectedSneakersSize= "//*[@idinner='102640']";
    private final String selectedSecondSneakersSize= "//*[@idinner='102409']";


    private final String addToCart ="//*[@id=\"active\"]/div[2]/a/span";

    private final Logger logger = LogManager.getRootLogger();


    public GoodPage(WebDriver driver){super(driver);}

    public GoodPage openPage(String path) {
        driver.get(path);
        return this;
    }


    public GoodPage selectedSecondSneakersSize() {
        WebElement sneakersSize = waitForElementLocatedBy(driver,
                By.xpath(selectedSecondSneakersSize),WAIT_TIME_SECONDS);

        sneakersSize.click();
        return this;
    }

    public GoodPage selectedSneakersSize() {
        WebElement sneakersSize = waitForElementLocatedBy(driver,
                By.xpath(selectedSneakersSize),WAIT_TIME_SECONDS);

        sneakersSize.click();
        return this;
    }

    public GoodPage addToCart() {
        WebElement cartButton = waitForElementLocatedBy(driver,
                By.xpath(addToCart), WAIT_TIME_SECONDS);
        cartButton.click();
        return this;
    }
    public GoodPage findOutPrice(){
        WebElement findOutButton = waitForElementLocatedBy(driver,
                By.xpath(findOutPrice), WAIT_TIME_SECONDS);
        findOutButton.click();
        return this;
    }
    public GoodPage typeCount(Good good){
        WebElement countField = waitForElementLocatedBy(driver,
                By.xpath(this.countField),WAIT_TIME_SECONDS);
        countField.clear();
        countField.sendKeys(good.getOptCount());
        return this;
    }
    public GoodPage typeEmail(User user){
        WebElement emailField = waitForElementLocatedBy(driver,
                By.xpath(this.emailField),WAIT_TIME_SECONDS);

        emailField.sendKeys(user.getEmail());
        return this;
    }
    public GoodPage typeFirstName(User user){
        WebElement firstNameField = waitForElementLocatedBy(driver,
                By.xpath(this.firstNameField),WAIT_TIME_SECONDS);

        firstNameField.sendKeys(user.getFirstName());
        return this;
    }
    public GoodPage typeTelephone(User user){
        WebElement telephoneField = waitForElementLocatedBy(driver,
                By.xpath(this.telephoneField),WAIT_TIME_SECONDS);

        telephoneField.sendKeys(user.getTelephone());
        return this;
    }
    public GoodPage sendRequest(){

        WebElement sendRequestButton = waitForElementLocatedBy(driver,
                By.xpath(sendRequest), WAIT_TIME_SECONDS);
        sendRequestButton.click();

        return this;
    }


    public boolean checkValidSending(){

        return (waitForElementLocatedBy(driver,
                By.xpath(validSending), WAIT_TIME_SECONDS).isDisplayed());
    }

    public WebElement checkInvalidSending(){
        return invalidSending;
    }
}
