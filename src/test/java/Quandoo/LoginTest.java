package Quandoo;

import Quandoo.pages.Homepage;
import Quandoo.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static Quandoo.pages.Page.BASE_URL;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    // classes
    Homepage homepage;
    LoginPage loginPage;

    /**
     * This test checks successful login functionality
     */
    @Test
    public void loginWithValidCredentials() {
        // open HomePage
        // click on login btn
        // insert credentials
        // click on Log in btn
        // check that user is logged in

        homepage = open(BASE_URL, Homepage.class);
        homepage.accCookies();
        loginPage = homepage.clickOnLoginBtn();
        loginPage.fillInValidCred();
        loginPage.clickOnLoginBtnHP();
        homepage.userIconPresent();
    }
}
