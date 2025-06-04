package tests;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Actions;

import java.time.Duration;
import java.util.Set;

public class LoginTest extends BaseTest {

    Actions actions;

    @Test
    public void loginToApp(){
        LoginPage loginPage =new LoginPage(driver);
        actions=new Actions(driver);
        loginPage.loginToApp("standard_user","secret_sauce");
        actions.scrollAndFindText(driver, "Sauce Labs Bolt T-Shirt");
        actions.scrollAndFindText(driver, "Sauce Labs Onesie");
        loginPage.select_tshirt();
        actions.scrollDown(driver);
        actions.scrollAndFindText1(driver, "ADD TO CART");
        loginPage.addToCart();
        loginPage.cart_icon().isDisplayed();
        String count= loginPage.cart_count().getText();
        Assert.assertEquals(count,"1");
        actions.takeScreenshot(driver,"added one item");
        driver.navigate().back();
        driver.navigate().back();

    }
}
