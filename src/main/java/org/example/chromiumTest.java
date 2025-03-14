package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class chromiumTest {


    public static void chromium_Ui() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.genymotion.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Latest News")).first().click();
            System.out.println("Page Title: " + page.title());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
            browser.close();
        }
    }

    public static Page getPage(){
        Playwright playwright=Playwright.create();
        Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        return page;

    }
    public static Page browserCOntext() {
        Page page;
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();
            page = context.newPage();
        }
        return page;
    }

    public static void assertText(String text){

        assertThat(getPage().locator("text=" + text)).isVisible();


    }

}

