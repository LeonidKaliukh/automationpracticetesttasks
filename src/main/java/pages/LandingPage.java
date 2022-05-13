package pages;

import static com.codeborne.selenide.Selenide.$;
public class LandingPage {
    public LandingPage() {
        super();
    }
    public AuthorizationPage openAuthenticationPage() {
        $(".login").click();
        return new AuthorizationPage();
    }
}
