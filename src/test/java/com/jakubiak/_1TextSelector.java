package com.jakubiak;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _1TextSelector {

    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    @Test
    public void textSelectorsTest() {
        try
                (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
            Page page = browser.newPage();
            page.navigate(home);

            page.click("text=More Info");
            Assertions.assertEquals(page.title(), "Advantages");
        }
    }


}
