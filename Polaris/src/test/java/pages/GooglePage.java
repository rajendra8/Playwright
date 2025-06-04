package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class GooglePage {

    private AndroidDriver driver;

    public GooglePage(AndroidDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.chrome:id/search_box\")")
    private WebElement search_box;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.chrome:id/url_bar\")")
    private WebElement url_bar;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"swaglabs\").instance(1)")
    private WebElement swaglabs;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.chrome:id/message_container\")")
    private WebElement notification;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.chrome:id/message_main_content\")")
    private WebElement notifacation_content;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.chrome:id/message_primary_button\")")
    private WebElement notifacation_continue_button;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"test-CLEAR\")")
    private WebElement CLEAR_BTN;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"test-SAVE\")")
    private WebElement SAVE_BTN;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/alertTitle\")")
    private WebElement drawing_alert;


    public void search_bar(){
        search_box.click();
    }
    public void url_bar(String input){
        url_bar.click();
        url_bar.clear();
        url_bar.sendKeys(input);
    }
    public void search_result(){
        swaglabs.click();
    }
    public WebElement notification(){
        return notification;
    }
    public WebElement notifacation_content(){
        return notifacation_content;
    }

    public WebElement getNotifacation_continue_button(){
         return notifacation_continue_button;
    }

    public WebElement clean_btn(){
        return CLEAR_BTN;
    }

    public WebElement save_btn(){
        return SAVE_BTN;
    }
    public WebElement drawing_alert(){
        return drawing_alert;
    }


    }


