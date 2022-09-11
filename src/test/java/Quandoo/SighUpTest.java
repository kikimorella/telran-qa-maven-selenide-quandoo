package Quandoo;

import Quandoo.pages.HomePage;
import Quandoo.pages.SignUpPage;
import com.codeborne.selenide.Condition;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * Class SignUpTest contains tests for the Sign Up functionality
 */
public class SighUpTest {

    HomePage homePage;
    SignUpPage signUpPage;

    @Test
    /**
     * Negative test which ensures that there is no ability to sign up without ticking Terms checkbox.
     */
    public void signUpWithoutTermsAndPrivacy() {
        //open page
        homePage = open("https://www.quandoo.de/en", HomePage.class);
        homePage.acceptCookies();
        signUpPage = homePage.clickOnSignUpBtn();
        //insert data to all fields
        signUpPage.fillInSignUpFields();
        //Click on Create Account
        signUpPage.clickOnCreateAccountBtn();
        // check that Create Account button exists
        signUpPage.createAccountBtnEl().should(Condition.visible);
    }
}
