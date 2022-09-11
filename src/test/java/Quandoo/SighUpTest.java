package Quandoo;

import Quandoo.pages.HomePage;
import Quandoo.pages.SignUpPage;
import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class SighUpTest {

    HomePage homePage;
    SignUpPage signUpPage;

    @Test
    public void signUpWithoutTermsAndPrivacy() {
        //open page
        homePage = open("https://www.quandoo.de/en", HomePage.class);
        homePage.clickAcceptCookiesBtn();
        signUpPage = homePage.clickOnSignUpBtn();
        //insert data to all fields
        signUpPage.fillInSignUpFields();
        //click on Create Account
        signUpPage.clickOnCreateAccountBtn();
//        signUpPage.btn().should(Condition.visible);
        //check that checkbox tooltip appeared
        //check that Create account button exists on the page
        Assert.assertTrue(signUpPage.checkCreateAccountBtnExists());
    }


}
