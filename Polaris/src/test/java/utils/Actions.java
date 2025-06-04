package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en_old.Ac;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Actions {
      WebDriverWait wait;
      private  AndroidDriver driver;
      public Actions(AndroidDriver driver){
          this.driver=driver;
      }
    public WebElement waitFor(AndroidDriver driver, String locater, Duration timeOut){
        wait=new WebDriverWait(driver,timeOut);
        return wait.until(ExpectedConditions.presenceOfElementLocated(new AppiumBy.ByAndroidUIAutomator(locater)));

    }

    public  void swipe(AndroidDriver driver, Point start, Point end, Duration duration){
        PointerInput PI=new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe= new Sequence(PI,0);

        swipe.addAction(PI.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(PI.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(PI.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(PI.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(swipe));

    }
    public  void scrollUp(AndroidDriver driver) {
        Point start = new Point(driver.manage().window().getSize().getWidth() / 2,
                (int) (driver.manage().window().getSize().getHeight() * 0.8));
        Point end = new Point(driver.manage().window().getSize().getWidth() / 2,
                (int) (driver.manage().window().getSize().getHeight() * 0.2));
        swipe(driver, start, end, Duration.ofMillis(500));
        System.out.println("Scroll down......");
    }

    public  void scrollDown(AndroidDriver driver) {
        Point start = new Point(driver.manage().window().getSize().getWidth() / 2,
                (int) (driver.manage().window().getSize().getHeight() * 0.2));
        Point end = new Point(driver.manage().window().getSize().getWidth() / 2,
                (int) (driver.manage().window().getSize().getHeight() * 0.8));
        swipe(driver, start, end, Duration.ofMillis(500));

        System.out.println("Scroll up......");
    }


    public void drawSquare(AndroidDriver driver){

        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence square= new Sequence(finger,0);
        int startX = 300;
        int startY = 800;
        int sideLength = 300;
        int duration = 200; // ms per side

        // Move to start point
        square.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        square.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Draw right
        square.addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), startX + sideLength, startY));
        // Down
        square.addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), startX + sideLength, startY + sideLength));
        // Left
        square.addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), startX, startY + sideLength));
        // Up
        square.addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), startX, startY));

        square.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(square));
    }


    public void scrollAndFindText(AndroidDriver driver, String textToFind) {
        try {
            String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollTextIntoView(\"" + textToFind + "\")";
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(uiScrollable));
            System.out.println("Text '" + textToFind + "' found and scrolled into view.");
        } catch (NoSuchElementException e) {
            System.err.println("Text '" + textToFind + "' not found: " + e.getMessage());
            // Handle the exception (e.g., retry, fail the test)
        } catch (Exception e) {
            System.err.println("Error during scroll: " + e.getMessage());
        }
    }


    public void scrollAndFindText1(AndroidDriver driver, String textToFind) {
        try {
            String uiScrollable = "new UiScrollable(new UiSelector().instance(0)).scrollTextIntoView(\"" + textToFind + "\")";
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(uiScrollable));
            System.out.println("Text '" + textToFind + "' found and scrolled into view.");
        } catch (NoSuchElementException e) {
            System.err.println("Text '" + textToFind + "' not found: " + e.getMessage());
            // Handle the exception (e.g., retry, fail the test)
        } catch (Exception e) {
            System.err.println("Error during scroll: " + e.getMessage());
        }

    }
    public String takeScreenshot(AndroidDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "//screenshots//" + screenshotName + "_" + dateName + ".png";
        try {
            FileUtils.copyFile(source, new File(destination));
            System.out.println("Screenshot saved to: " + destination);
            return destination;
        } catch (IOException e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }
}
