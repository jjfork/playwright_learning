package com.jakubiak;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class TestWithContext {
    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }
    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }
    @AfterEach
    void closeContext() {
        context.close();
    }

    @AfterAll
    static void closeBrowser() {
        browser.close();
        playwright.close();
    }
    @Test
    public void firstPlayWrightTestWithContext() {

            page.navigate(home);
            Assertions.assertEquals(page.title(), "Home Page");
        }


    @Test
    public void secondPlayWrightTestWithContext() {

        page.navigate(home);
        String content = page.content();

        Assertions.assertTrue(content.contains("Cat In The Bag"));
    }
}

