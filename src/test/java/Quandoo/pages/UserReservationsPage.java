package Quandoo.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class UserReservationsPage extends Page{

    // locators
    private static final By wartesaal = By.xpath("//a[@href='/place/wartesaal-11828']/h3");

    // methods
    public void restaurantIsDisplayed() {
        $(wartesaal).isDisplayed();
    }

    public RestaurantPage restaurantClick() {
        $(wartesaal).click();
        return page(RestaurantPage.class);
    }
}
