package com.jakubiak;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import org.junit.jupiter.api.Test;

public class PlaywrightFirstClass {

    @Test
    public void firstTest() {
        try(Playwright playwright = Playwright.create()){
            BrowserType browsertype = playwright.chromium();
            Browser browser = browsertype.launch();
            Page page = browser.newPage();
            page.navigate("https://playwright.dev");
            System.out.println(page.title());
        }
    }

    @Test
    public void firstPlaywrightScriptRefactored() {
        try(Playwright playwright = Playwright.create()){
            Page page = playwright.chromium().launch().newPage();
            page.navigate("https://playwright.dev");
            System.out.println(page.title());
        }
    }


}
