package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import util.TestListener;


@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    protected static final String GOOD_URL_FOR_PROMO = "https://joma.by/item-shops/n10s-2017-fg-butsy-dlya-tverdykh-poley-numero-10";
    protected static final String GOOD_URL = "https://joma.by/item/n10s-2017-fg-butsy-dlya-tverdykh-poley-numero-10";
    protected static final String SECOND_GOOD_URL = "https://joma.by/item/agus-2004-fg-butsy-dlya-tverdykh-poley-aguila";
    protected static final String THIRD_GOOD_URL = "https://joma.by/item/tops-2006-in-futzalki-top-flex";

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
