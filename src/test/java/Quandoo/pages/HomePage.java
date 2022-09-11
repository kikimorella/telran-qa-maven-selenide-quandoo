package Quandoo.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage extends Page {

    // locators
    private static By signUpBtn = By.xpath("//*[@data-qa='header-register-btn']");

    // methods
    public SignUpPage clickOnSignUpBtn() {
        $(signUpBtn).click();
        return page(SignUpPage.class);
    }
}
