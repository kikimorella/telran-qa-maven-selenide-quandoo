package Quandoo.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends Page {

    LoginPage loginPage;

    // locators
    private static By emailField = By.xpath("//*[@data-qa='email-input']");
    private static By passwordField = By.xpath("//*[@data-qa='password-input']");
    private static By loginBtn = By.xpath("//*[@data-qa='login-btn']");

    // methods
    public void fillInValidCred() {
        $(emailField).setValue(VALID_EMAIL);
        $(passwordField).setValue(VALID_PASS);
    }

    public HomePage clickOnLoginBtnHP() {
        $(loginBtn).click();
        return page(HomePage.class);
    }

    public ReservationPage clickOnLoginBtnRP() {
        $(loginBtn).click();
        return page(ReservationPage.class);
    }

    public void clickOnLoginBtn() {
        $(loginBtn).click();
    }

    public void fullLogin() {
        loginPage.fillInValidCred();
        loginPage.clickOnLoginBtn();
    }
}
