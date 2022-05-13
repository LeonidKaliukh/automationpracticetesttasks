package utils;

import browser.Chrome;
import browser.Firefox;
import com.codeborne.selenide.Configuration;

public final class Browser {

    private static final String BROWSER_SIZE = "1340x768";

    Browser() {
        super();
    }

    public static void selectBrowser(final String browser) {
        Configuration.browserSize = BROWSER_SIZE;
        if ("chrome".equalsIgnoreCase(browser)) {
            Configuration.browser = Chrome.class.getName();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            Configuration.browser = Firefox.class.getName();
        } else {
            throw new IllegalStateException(" Browser " + browser + " not supported in this tests. ");
        }
    }
}
