package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoodPage extends AbstractPage{
    private final String selectedSneakersSize= "//*[@idinner='102640']";
    private final String addToCart ="//*[@id=\"active\"]/div[2]/a/span";

    public GoodPage(WebDriver driver){super(driver);}


    public GoodPage openPage() {
        driver.get(GOOD_URL);
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

}
