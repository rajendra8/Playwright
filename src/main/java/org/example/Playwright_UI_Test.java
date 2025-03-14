package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

public class Playwright_UI_Test {

    static Playwright playwright;
    static Browser browser;

     BrowserContext context;
     Page page;

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
    public  void beforeEach(){
      context=browser.newContext();
     page=context.newPage();
    }

    @AfterEach
    public void afterEach(){
       context.close();
    }

  @Test
    public  void testTheUiContent(){
        page.navigate("https://www.genymotion.com/");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Latest News")).first().click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Products")).first().hover();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Genymotion SaaS")).first().click();
    }





}
