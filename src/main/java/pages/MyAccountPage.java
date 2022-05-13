package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class MyAccountPage {
    private static final String MY_ACCOUNT = "My account";
    private final SelenideElement account = $("[class='account'] span");
    private final SelenideElement pageHeading = $("div[id='center_column'] h1");
    private final SelenideElement logout = $("[class='logout']");

    private final SelenideElement signIn = $x("//*[@title='Log in to your customer account']");

    public MyAccountPage assertSuccessLogin(final String credUser) {
        account.shouldHave(Condition.text(credUser));
        pageHeading.shouldBe(Condition.text(MY_ACCOUNT));
        return new MyAccountPage();
    }

    public MyAccountPage assertSuccessLogout() {
        signIn.shouldHave(Condition.appear);
        return new MyAccountPage();
    }

    public MyAccountPage() {
        super();
    }
    public MyAccountPage clickSignOut() {
        logout.click();
        return this;
    }

    public MyAccountPage createNewBrowserTab() {
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("window.open()");
        return this;
    }

    public MyAccountPage switchBetweenBrowserTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<String>(WebDriverRunner.getWebDriver().getWindowHandles());
        WebDriverRunner.getWebDriver().switchTo().window(tabs.get(tabNumber));
        return this;
    }

    public MyAccountPage openUrl(String url) {
        open(url);
        return this;
    }

    public MyAccountPage refreshPage() {
        refresh();
        return this;
    }
}
