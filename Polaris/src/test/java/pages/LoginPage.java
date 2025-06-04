package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    private   AndroidDriver driver;

   public LoginPage(AndroidDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

   @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Username\")")
   // @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private WebElement Username;
    //@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Password\")")
    @AndroidFindBy(accessibility = "test-Password")
    private WebElement Password;
   // @AndroidFindBy(uiAutomator = "new UiSelector().text(\"LOGIN\")")
    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement Login;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sauce Labs Bolt T-Shirt\")")
    private WebElement Sauce_labs_T_shirt;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"ADD TO CART\")")
    private WebElement ADD_TO_CART;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"test-Cart\")")
    private WebElement cart;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView[@text=\"1\"]")
    private WebElement count;

    public void loginToApp(String username, String password){
        Username.sendKeys(username);
        Password.sendKeys(password);
        Login.click();
    }

    public void select_tshirt(){
        Sauce_labs_T_shirt.click();
    }

    public void addToCart(){
        ADD_TO_CART.click();
    }
    public WebElement cart_icon(){
        return cart;
    }

    public WebElement cart_count(){
        return count;
    }
}
