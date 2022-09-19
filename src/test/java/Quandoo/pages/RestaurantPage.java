package Quandoo.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RestaurantPage extends Page {

    RestaurantPage restaurantPage;
    ReservationPage reservationPage;

    // locators
    private static final By chooseDateField = By.xpath("//*[@data-qa='widget-date-picker-selection']");
    private static final By nextMonth = By.xpath("//*[@data-qa='day-picker-navbar-next']");
    private static final By firstDayOfTheMonth = By.xpath("//*[@class='DayPicker-Day'][@tabindex='0']");
    private static final By sixThirty = By.xpath("//span[contains( text(),'6:30 pm')]");
    private static final By timeSelected = By.xpath("//li[@data-qa='time-selected']");
    private static By reserveBtn = By.xpath("//button[@data-vwo='reservation-init']");

    // methods
    public void dayChoose() {
        $(chooseDateField).click();
        $(nextMonth).click();
        $(firstDayOfTheMonth).click();
    }

    public void timeChoose() {
        $(sixThirty).click();
        $(timeSelected).isEnabled();
    }

    public ReservationPage clickOnReserveBtn() {
        $(reserveBtn).click();
        return page(ReservationPage.class);
    }

    public void reserveNow() {
        restaurantPage.dayChoose();
        restaurantPage.timeChoose();
        reservationPage = restaurantPage.clickOnReserveBtn();
    }
}
