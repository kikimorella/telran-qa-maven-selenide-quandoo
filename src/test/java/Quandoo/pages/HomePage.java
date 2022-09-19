package Quandoo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage extends Page {

    HomePage homePage;
    FilterPage filterPage;

    // locators
    private static By signUpBtn = By.xpath("//*[@data-qa='header-register-btn']");
    private static By userIcon = By.xpath("//*[@data-qa='header-navigation-button']");
    private static By loginBtn = By.xpath("//*[@data-qa='header-login-btn']");

    private static By restaurantField = By.xpath("//input[@name='dining'])[2]");
    private static By destinationField = By.xpath("//input[@name='destination'])[2]");
    private static By findBtn = By.xpath("//*[@data-qa='button-search-find-hero']");

    // methods
    public SignUpPage clickOnSignUpBtn() {
        $(signUpBtn).click();
        return page(SignUpPage.class);
    }

    public LoginPage clickOnLoginBtn() {
        $(loginBtn).click();
        return page(LoginPage.class);
    }

    public void userIconPresent() {
        $(userIcon).isDisplayed();
    }

    public void fillRestaurantField(String what) {
        $(restaurantField).sendKeys(what);
    }

    public void fillDestinationField(String where) {
        $(destinationField).sendKeys(where);
    }

    public FilterPage clickOnFindBtn() {
        $(findBtn).click();
        return page(FilterPage.class);
    }

    public void fillInTheRestaurant() {
        homePage.fillDestinationField(RESTAURANT_CITY);
        homePage.fillRestaurantField(RESTAURANT_NAME);
        filterPage = homePage.clickOnFindBtn();
    }
}
