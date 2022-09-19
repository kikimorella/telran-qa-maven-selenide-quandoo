package Quandoo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RestaurantEnquiryPage extends Page{

    // locators
    private static final By emailField = By.xpath("//*[@data-qa='input-email']");
    private static final By firstNameField = By.xpath("//*[@data-qa='input-first-name']");
    private static final By lastNameField = By.xpath("//*[@data-qa='input-last-name']");
    private static final By phoneNumberField = By.xpath("//*[@data-qa='input-phone']");
    private static final By chooseDateField = By.xpath("//*[@data-qa='widget-date-picker-selection']");
    private static final By chooseTime1Field = By.xpath("//*[@data-qa='widget-time-picker-start']");
    private static final By chooseTime2Field = By.xpath("//*[@data-qa='widget-time-picker-end']");
    private static final By termsAndConditionsCheckbox = By.xpath("//*[@data-qa='checkbox-termsAndConditions']");
    private static final By sendEnquiryBtn = By.xpath("//*[@data-qa='enquiry-submit']");

    private static final By nextMonth = By.xpath("//*[@data-qa='day-picker-navbar-next']");
    private static final By firstDayOfTheMonth = By.xpath("//*[@class='DayPicker-Day'][@tabindex='0']");
    private static final By sevenPM = By.xpath("//*[@data-qa='widget-time-picker-start']//option[contains( text(),'7:00 pm')]");
    // selectOption(String)
    private static final By sevenThirtyPM = By.xpath("//*[@data-qa='widget-time-picker-end']//option[contains( text(),'7:30 pm')]");

    // methods
    public void fillInDataFields() {
        faker = new Faker();
        $(emailField).setValue(faker.internet().emailAddress());
        $(firstNameField).setValue(faker.name().firstName());
        $(lastNameField).setValue(faker.name().lastName());
        $(phoneNumberField).setValue(faker.phoneNumber().phoneNumber());
    }

    public void dayChoose() {
        $(chooseDateField).click();
        $(nextMonth).click();
        $(firstDayOfTheMonth).click();
    }

    public void timeChoose() {
        $(chooseTime1Field).click();
        $(sevenPM).click();
        $(chooseTime2Field).click();
        $(sevenThirtyPM).click();
    }

//    public void clickOnSendEnquiryBtn() {
//        $(sendEnquiryBtn).click();
//    }

    public void sendEnquiryBtnIsActive() {
        $(sendEnquiryBtn).shouldBe(Condition.visible).isEnabled();
    }

    public SelenideElement sendEnquiryBtnElt() {
        return $(sendEnquiryBtn);
    }
}
