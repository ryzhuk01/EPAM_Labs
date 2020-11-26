import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelloWebDriver {
    @Test
    public void searchByTitle() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.joma.by");

         WebElement searchBtn = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[9]/div/header/div[2]/div[1]/div[3]/div[4]")));

         searchBtn.click();


         WebElement searchInput = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[7]/div[1]/div/div[1]/input")));


        searchInput.sendKeys("майка");

        Thread.sleep(15000);

        //вот вообще никак не получилось через wait

        Assert.assertFalse(driver.findElements(By.className("cartItem")).isEmpty());

        driver.quit();
    }

}
