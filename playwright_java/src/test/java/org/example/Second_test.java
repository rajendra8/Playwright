package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.channels.Selector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Second_test extends Base{

    @BeforeAll
    public static void beforeAll(){
        playwright=Playwright.create();
        browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

    }

    @AfterAll
    public static void afterAll(){
        playwright.close();
    }
    @BeforeEach
    public void createContextAndPage(){
        browserContext=browser.newContext();
        page=browserContext.newPage();
       // newPageOptions.setScreenSize(100,200);
        page.navigate("https://sales.gk4null.de/");

        page.locator("//input[@name='username']").fill("rajendra.sahu@vodafone.com");
        page.locator("//input[@name='password']").fill("Entrada3!");
        page.locator("//input[@name='login']").click();
    }


    @AfterEach
    void closeContext_Each(){
        browserContext.close();
    }

    @Test
    void shouldClickButton() {

      String title= page.title();
        System.out.printf(title);
    }

    @Test
    void shouldCheckTheBox() {
        page.locator("//a[@title='Customer']").click();

    }

}
