package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Base {

    static Playwright playwright;
    static Browser browser;
    static Page page;

    static BrowserContext browserContext;
    static Browser.NewPageOptions newPageOptions;

}
