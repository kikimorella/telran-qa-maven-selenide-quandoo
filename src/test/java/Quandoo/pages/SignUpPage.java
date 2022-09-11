package Quandoo.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {

    Faker faker;

    private static final By firstNameField = By.xpath("//*[@data-qa='first-name-input']");
    private static final By lastNameField = By.xpath("//*[@data-qa='last-name-input']");
    private static final By emailField = By.xpath("//*[@data-qa='email-input']");
    private static final By passField = By.xpath("//*[@data-qa='password-input']");
    private static final By confirmPassField = By.xpath("//*[@data-qa='password-confirm-input']");
    private static final By createAccountBtn = By.xpath("//*[@data-qa='submit-btn']");

    public void fillInSignUpFields() {
        faker = new Faker();
        String pwd = faker.internet().password();

        $(firstNameField).setValue(faker.name().firstName());
        $(lastNameField).setValue(faker.name().lastName());
        $(emailField).setValue(faker.internet().emailAddress());
        $(passField).setValue(pwd);
        $(confirmPassField).setValue(pwd);

//        $(firstNameField).setValue("First Name");
//        $(lastNameField).setValue("Last Name");
//        $(emailField).setValue("test@test.com");
//        $(passField).setValue("mypassword");
//        $(confirmPassField).setValue("mypassword");
    }

    public void clickOnCreateAccountBtn() {
        $(createAccountBtn).click();
    }

    public SelenideElement btn() {
        return (SelenideElement) createAccountBtn;
    }

    public boolean checkCreateAccountBtnExists() {
//        $(createAccountBtn).should(Condition.visible);
        return $(createAccountBtn).exists();
    }
}
