package test;

import model.Good;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.GoodPage;
import service.GoodCreator;
import service.UserCreactor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
import static page.CartPage.priceBefore;

public class WebDriverShopTest extends CommonConditions {
    private final Logger logger = LogManager.getRootLogger();

        @Test(priority = 1)
        public void addingSneakersTest() {
            Good testGood = GoodCreator.withCredentialsFromProperty();
            CartPage cartPage = new GoodPage(driver)
                    .openPage(GOOD_URL)
                    .selectedSneakersSize()
                    .addToCart()
                    .openCart();
            logger.info("first" + cartPage.getSneakersCount() +
                    "second" + testGood.getCount());
            assertThat(cartPage.actualSizeSelected(),containsString(testGood.getSize()));
            assertThat(cartPage.getSneakersArticle(),is(equalTo(testGood.getArticle())));
            assertThat(cartPage.getSneakersCount(),is(equalTo(testGood.getCount())));
            assertThat(cartPage.getSneakersPrice(),is(equalTo(testGood.getPrice())));

        }

        @Test(priority = 2)
        public void addingSomeSneakersTest() {
            Good testGood = GoodCreator.withCredentialsFromProperty();
            Good secondTestGood = GoodCreator.secondWithCredentialsFromProperty();
            CartPage cartPage = new GoodPage(driver)
                    .openPage(GOOD_URL)
                    .selectedSneakersSize()
                    .addToCart()
                    .openPage(SECOND_GOOD_URL)
                    .selectedSecondSneakersSize()
                    .addToCart()
                    .openCart();
            logger.info("first" + cartPage.getSecondSneakersArticle() +
                    "second" + secondTestGood.getArticle());
            assertThat(cartPage.actualSecondSizeSelected(),containsString(secondTestGood.getSize()));
            assertThat(cartPage.getSecondSneakersCount(),is(equalTo(secondTestGood.getCount())));
            assertThat(cartPage.getSecondSneakersArticle(),is(equalTo(secondTestGood.getArticle())));
            assertThat(cartPage.getSecondSneakersPrice(),is(equalTo(secondTestGood.getPrice())));
            assertThat(cartPage.actualSizeSelected(),containsString(testGood.getSize()));
            assertThat(cartPage.getSneakersArticle(),is(equalTo(testGood.getArticle())));
            assertThat(cartPage.getSneakersCount(),is(equalTo(testGood.getCount())));
            assertThat(cartPage.getSneakersPrice(),is(equalTo(testGood.getPrice())));
        }

        @Test(priority = 3)
        public void cartAfterDeleting(){
            Good testGood = GoodCreator.withCredentialsFromProperty();
            CartPage cartPage = new GoodPage(driver)
                    .openPage(GOOD_URL)
                    .selectedSneakersSize()
                    .addToCart()
                    .openCart();
            assertThat(cartPage.actualSizeSelected(),containsString(testGood.getSize()));
            assertThat(cartPage.getSneakersArticle(),is(equalTo(testGood.getArticle())));
            assertThat(cartPage.getSneakersCount(),is(equalTo(testGood.getCount())));
            assertThat(cartPage.getSneakersPrice(),is(equalTo(testGood.getPrice())));
                    cartPage.deleteFromCart();
            Assert.assertEquals("Ваша корзина пуста!",cartPage.checkCart());
        }
    @Test(priority = 4)
    public void checkingInvalidPromoTest() {
        Good testGood = GoodCreator.withCredentialsFromProperty();
        User promo = UserCreactor.createInvalidUser();
        CartPage cartPage = new GoodPage(driver)
                .openPage(GOOD_URL_FOR_PROMO)
                .selectedSneakersSize()
                .addToCart()
                .openCart();
        assertThat(cartPage.actualSizeSelected(),containsString(testGood.getSize()));
        assertThat(cartPage.getSneakersArticle(),is(equalTo(testGood.getArticle())));
        assertThat(cartPage.getSneakersCount(),is(equalTo(testGood.getCount())));
        assertThat(cartPage.getSneakersPrice(),is(equalTo(testGood.getPrice())));
                cartPage.showPromoField()
                .typePromo(promo)
                .confirmPromo();
        assertThat(priceBefore,is(equalTo(cartPage.getSummaryInvalidPrice())));
    }
     @Test(priority = 5)
    public void checkingValidPromoTest() {
        Good testGood = GoodCreator.withCredentialsFromProperty();
        User validPromo = UserCreactor.createValidUser();
        CartPage cartPage = new GoodPage(driver)
                .openPage(GOOD_URL_FOR_PROMO)
                .selectedSneakersSize()
                .addToCart()
                .openCart();
        assertThat(cartPage.actualSizeSelected(),containsString(testGood.getSize()));
        assertThat(cartPage.getSneakersArticle(),is(equalTo(testGood.getArticle())));
        assertThat(cartPage.getSneakersCount(),is(equalTo(testGood.getCount())));
        assertThat(cartPage.getSneakersPrice(),is(equalTo(testGood.getPrice())));
         cartPage.showPromoField()
                 .typePromo(validPromo)
                 .confirmPromo();
        assertThat(priceBefore,not(cartPage.getSummaryValidPrice()));

    }

    @Test(priority = 6)
    public void checkValidEmailTest() {
        Good testGood = GoodCreator.withCredentialsFromProperty();
        User validUser = UserCreactor.createValidUser();
        GoodPage cartPage = new GoodPage(driver)
                .openPage(THIRD_GOOD_URL)
                .findOutPrice()
                .typeEmail(validUser)
                .typeFirstName(validUser)
                .typeTelephone(validUser)
                .sendRequest();
        assertTrue(cartPage.checkValidSending());
    }

    @Test(priority = 7)
    public void CheckInvalidEmailTest() {
        Good testGood = GoodCreator.withCredentialsFromProperty();
        User inValidUser = UserCreactor.createInvalidUser();
        GoodPage cartPage = new GoodPage(driver)
                .openPage(THIRD_GOOD_URL)
                .findOutPrice()
                .typeEmail(inValidUser)
                .typeFirstName(inValidUser)
                .typeTelephone(inValidUser)
                .sendRequest();
        assertNull(cartPage.checkInvalidSending());
    }

    @Test(priority = 8)
    public void checkWholesaleOrderingInShop() {
        Good testGood = GoodCreator.withCredentialsFromProperty();
        CartPage cartPage = new GoodPage(driver)
                .openPage(GOOD_URL_FOR_PROMO)
                .selectedSneakersSize()
                .typeCount(testGood)
                .addToCart()
                .openCart();
        assertThat(cartPage.actualSizeSelected(), containsString(testGood.getSize()));
        assertThat(cartPage.getSneakersArticle(), is(equalTo(testGood.getArticle())));
        assertThat(cartPage.getSneakersCount(), is(equalTo(testGood.getOptCount())));
        assertThat(cartPage.getSummaryInvalidPrice(), is(equalTo(testGood.getFinalPrice())));
    }


    @Test(priority = 9)
    public void checkWholesaleOrderingInOpt() {
        Good testGood = GoodCreator.withCredentialsFromProperty();
        CartPage cartPage = new GoodPage(driver)
                .openPage(GOOD_URL)
                .selectedSneakersSize()
                .typeCount(testGood)
                .addToCart()
                .openCart();
        assertThat(cartPage.actualSizeSelected(), containsString(testGood.getSize()));
        assertThat(cartPage.getSneakersArticle(), is(equalTo(testGood.getArticle())));
        assertThat(cartPage.getSneakersCount(), is(equalTo(testGood.getOptCount())));
        assertThat(cartPage.getSummaryInvalidPrice(), not(equalTo(testGood.getFinalPrice())));
    }

     @Test(priority = 10)
    public void checkOrderingInOpt() {
        Good testGood = GoodCreator.withCredentialsFromProperty();
        CartPage cartPage = new GoodPage(driver)
                .openPage(GOOD_URL)
                .selectedSneakersSize()
                .addToCart()
                .openCart();
        assertThat(cartPage.actualSizeSelected(),containsString(testGood.getSize()));
        assertThat(cartPage.getSneakersArticle(),is(equalTo(testGood.getArticle())));
        assertThat(cartPage.getSneakersCount(),is(equalTo(testGood.getCount())));
        assertThat(cartPage.getSneakersPrice(),is(equalTo(testGood.getPrice())));
    }
}
