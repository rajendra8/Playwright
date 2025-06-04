package tests;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GooglePage;
import pages.LoginPage;
import utils.Actions;

import java.time.Duration;

public class GoogleTest extends BaseTest {

    Actions actions;

    @Test
    public void googleToApp() {
        GooglePage googlePage = new GooglePage(driver);
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.activateApp("com.android.chrome");
        googlePage.search_bar();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        googlePage.url_bar("swaglabs");
        googlePage.url_bar("swaglabs://drawing");
        googlePage.search_result();
        if (googlePage.notification().isDisplayed()) {
            Assert.assertTrue(googlePage.notification().isDisplayed());
        }
        String notification_text = googlePage.notifacation_content().getText();
        System.out.println(notification_text);


        if (googlePage.getNotifacation_continue_button().isDisplayed()) {
            Assert.assertTrue(googlePage.getNotifacation_continue_button().isDisplayed());
            googlePage.getNotifacation_continue_button().click();

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Current package: " + driver.getCurrentPackage());
        System.out.println("Current activity: " + driver.currentActivity());
        driver.activateApp(driver.getCurrentPackage());


        Assert.assertTrue(googlePage.clean_btn().isDisplayed());
        Assert.assertTrue(googlePage.save_btn().isDisplayed());
        actions.drawSquare(driver);
        googlePage.save_btn().click();
        String allertTest = googlePage.drawing_alert().getText();
        Assert.assertEquals(allertTest, "Save drawing");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions.takeScreenshot(driver,"after drawing");
        driver.switchTo().alert().accept();

        googlePage.clean_btn().click();
        driver.navigate().back();

    }

}
