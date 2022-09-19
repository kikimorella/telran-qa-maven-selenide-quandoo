package Quandoo;

import Quandoo.pages.HomePage;
import Quandoo.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static Quandoo.pages.Page.BASE_URL;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    // classes
    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void loginWithValidCredentials() {
        // open HomePage
        // click on login btn
        // insert credentials
        // click on Log in btn
        // check that user is logged in

        homePage = open(BASE_URL, HomePage.class);
        homePage.acceptCookies();
        loginPage = homePage.clickOnLoginBtn();
        loginPage.fillInValidCred();
        loginPage.clickOnLoginBtnHP();
        homePage.userIconPresent();
    }
}
