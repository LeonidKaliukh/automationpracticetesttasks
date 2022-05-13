package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class AuthorizationPage {
    private SelenideElement createEmail = $("input[id='email_create']");
    private SelenideElement email = $("input[id='email']");
    private SelenideElement password = $("input[id='passwd']");
    private SelenideElement createAccount = $("button[id='SubmitCreate']");
    private SelenideElement submitLogin = $("button[id='SubmitLogin']");

    public static int randomInt(int min, int max) {
        return (int)Math.floor(Math.random()*(max - min + 1) +min);
    }

    protected static String createRandomUserEmail() {
        return "leonid_" + randomInt(100,1000) + "@test.test";
    }

    public AuthorizationPage addEmailForUser() {
        step("add random generated user email", () ->
        createEmail.setValue(createRandomUserEmail()));
        return this;
    }

    public AuthorizationPage enterUserPassword(String userPassword) {
        step("set password " + userPassword + "in the password input", () ->
                password.setValue(userPassword));
        return this;
    }

    public AuthorizationPage enterUserEmail(final String userEmail) {
        step("set email " + userEmail + "in the email input", () ->
                email.setValue(userEmail));
        return this;
    }

    public CreateAccountPage clickCreateAccountButton() {
        step("click to create button", () ->
        createAccount.click());
        return new CreateAccountPage();
    }

    public MyAccountPage clickSignInButton() {
        step("click to sign in button", () ->
                submitLogin.click());
        return new MyAccountPage();
    }

    /****** ERRORS ******/

    public AuthorizationPage getEmailRequiredError() {
        $x("//li[contains(text(), 'An email address required.')]").shouldBe(Condition.appear);
        return this;
    }

    public AuthorizationPage getEmailInvalidError() {
        $x("//li[contains(text(), 'Invalid email address.')]").shouldBe(Condition.appear);
        return this;
    }

    public AuthorizationPage getAuthenticationFailedError() {
        $x("//li[contains(text(), 'Authentication failed.')]").shouldBe(Condition.appear);
        return this;
    }
    public AuthorizationPage getPasswordRequiredError() {
        $x("//li[contains(text(), 'Password is required.')]").shouldBe(Condition.appear);
        return this;
    }

    public AuthorizationPage getInvalidPasswordError() {
        $x("//li[contains(text(), 'Invalid password')]").shouldBe(Condition.appear);
        return this;
    }
}
