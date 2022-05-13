package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPage {
//    private static final int DELAY = 5000;
    private static final String MY_ACCOUNT = "My account";
    private final SelenideElement account = $("[class='account'] span");
    private final SelenideElement pageHeading = $("div[id='center_column'] h1");
    private final SelenideElement logout = $("[class='logout']");
    public MyAccountPage assertSuccessLogin(final String credUser) {

        account
//                .waitUntil(Condition.visible, DELAY)
                .shouldHave(Condition.text(credUser));

        pageHeading
//                .waitUntil(Condition.visible, DELAY)
                .shouldBe(Condition.text(MY_ACCOUNT));

        return new MyAccountPage();
    }
    public MyAccountPage() {
        super();
    }
    public MyAccountPage clickSignOut() {
        logout.click();
        return this;
    }
}
