package Quandoo.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CheckoutSummaryPage extends Page {

    // locators
    private static final By text = By.xpath("//*[@data-qa='reservation-confirmation']/div/span");
    private static final By loginIcon = By.xpath("//*[@data-qa='header-navigation-button");
    private static final By reservations = By.xpath("//*[@data-qa='header-navigation-button");

    // methods
    public UserReservationsPage clickOnLoginIcon() {
        $(loginIcon).click();
        $(reservations).click();
        return page(UserReservationsPage.class);
    }
}
