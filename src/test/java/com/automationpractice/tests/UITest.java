package com.automationpractice.tests;

import base.BaseWeb;
import base.CustomTestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.LandingPage;
import pages.MyAccountPage;

@Listeners({CustomTestListener.class})
public class UITest extends BaseWeb {

    LandingPage landingPage = new LandingPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();

    private static final String TEST_USER = "Leonid Kaliukh";
    private final String userEmail = "leonid.kaliukh@gmail.com";
    private final String userPassword = "11223344";

    private static final String SignIn = "Sign in";

    @Test
    @Description("Create new user test")
    public void createUserTest() {
        landingPage
                .openAuthenticationPage()
                .addEmailForUser()
                .clickCreateAccountButton()
                .enterUserData();
    }

    @Test
    @Story("001 Positive authorization with valid userEmail and userPassword")
    @Description("Authorization test with valid data")
    public void authorizationTestWithValidData() {
        landingPage
                .openAuthenticationPage()
                .enterUserEmail(userEmail)
                .enterUserPassword(userPassword)
                .clickSignInButton()
                .assertSuccessLogin(TEST_USER)
                .clickSignOut()
                .assertSuccessLogout();
    }

    @Test
    @Story("002 Negative authorization with valid userEmail and invalid userPassword")
    @Description("Authorization test with invalid data")
    public void authorizationTestWithInvalidPassword() {
        landingPage
                .openAuthenticationPage()
                .enterUserEmail(userEmail)
                .enterUserPassword("1234")
                .clickSignInButton();
        authorizationPage.getInvalidPasswordError();
    }

    @Test
    @Story("003 Negative authorization with invalid userEmail and valid userPassword")
    @Description("Authorization test with invalid data")
    public void authorizationTestWithInvalidUserName() {
        landingPage
                .openAuthenticationPage()
                .enterUserEmail("112345@test.test")
                .enterUserPassword(userPassword)
                .clickSignInButton();
        authorizationPage.getAuthenticationFailedError();
    }

    @Test
    @Story("004 Negative authorization with invalid userEmail and invalid userPassword")
    @Description("Authorization test with invalid all data")
    public void authorizationTestWithInvalidUserNameAndPassword() {
        landingPage
                .openAuthenticationPage()
                .enterUserEmail("112345@test.test")
                .enterUserPassword("1234")
                .clickSignInButton();
        authorizationPage.getInvalidPasswordError();
    }

    @Test
    @Story("005 Negative authorization with valid userEmail and empty userPassword")
    @Description("Authorization test with invalid data")
    public void authorizationTestWithEmptyPassword() {
        landingPage
                .openAuthenticationPage()
                .enterUserEmail(userEmail)
                .clickSignInButton();
        authorizationPage.getPasswordRequiredError();
    }

    @Test
    @Story("006 Negative authorization with empty userEmail and valid userPassword")
    @Description("Authorization test with invalid data")
    public void authorizationTestWithEmptyUserName() {
        landingPage
                .openAuthenticationPage()
                .enterUserPassword(userPassword)
                .clickSignInButton();
        authorizationPage.getEmailRequiredError();
    }

    @Test
    @Story("Logout by mylogout/")
    @Description("logout By Mylogout Action")
    public void logoutByMylogoutActionTest() {
        landingPage
                .openAuthenticationPage()
                .enterUserEmail(userEmail)
                .enterUserPassword(userPassword)
                .clickSignInButton()
                .assertSuccessLogin(TEST_USER)
                .createNewBrowserTab()
                .switchBetweenBrowserTab(1)
                .openUrl("http://automationpractice.com/index.php?mylogout")
                .assertSuccessLogout()
                .switchBetweenBrowserTab(0)
                .refreshPage()
                .assertSuccessLogout();
    }
}
