package base;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import static com.codeborne.selenide.WebDriverRunner.*;
import static utils.Browser.selectBrowser;
import static utils.PropertiesReader.loadProperty;

public class BaseWeb {
    private String baseUrl;
    public BaseWeb() {
        super();
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void beforeTest(@Optional("chrome") final String browser) {
            selectBrowser(browser);
            clearBrowserCache();
            baseUrl = loadProperty("BASE_URL");
            Selenide.open(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        clearBrowserCache();
        closeWebDriver();
    }
}
