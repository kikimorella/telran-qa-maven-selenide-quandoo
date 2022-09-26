package Quandoo;

import Quandoo.pages.*;
import org.junit.jupiter.api.Test;

import static Quandoo.pages.Page.*;
import static com.codeborne.selenide.Selenide.open;

public class End2EndTest {

    Homepage homepage;
    LoginPage loginPage;
    FilterPage filterPage;
    RestaurantPage restaurantPage;
    ReservationPage reservationPage;
    CheckoutSummaryPage checkoutSummaryPage;
    UserReservationsPage userReservationsPage;

    @Test
    public void firstLogInThanRestaurantReservation() {
    /*
    открыть сайт
    Клик на log in (переход на страницу log In)
    ввести пароли и логин
    клик на кнопку (переход на главную страницу)
    убедиться, что иконка сменилась
    ввести название ресторана () и город () (переход на страницу фильтров)
    выбрать ресторан (клик) (переход на страницу ресторана)
    быбрать дату (первый день следующего месяца) и время(7.30)
    клик на кнопку зарезервировать (переход на страницу резервации)
    клик кнопки зарезервировать (всплывающее окно Important note)
    клик на Confirm reservation (переход на страницу Your reservation is confirmed)
    клик на иконку Логин, выбор в drop-down поля Reservations (переход на страницу поля)
    убедиться, что в Upcoming reservations отражена страница ресторана, есть кнопка Cancel
    */
        homepage = open(BASE_URL, Homepage.class);
        homepage.accCookies();

        loginPage = homepage.clickOnLoginBtn();

        loginPage.fillInValidCred();
        loginPage.clickOnLoginBtnHP();

        homepage.userIconPresent();

        homepage.fillRestaurantField(RESTAURANT_NAME);
        homepage.fillDestinationField(RESTAURANT_CITY);
        filterPage = homepage.clickOnFindBtn();

        restaurantPage = filterPage.clickOnRestaurant();

        restaurantPage.dayChoose();
        restaurantPage.timeChoose();
        reservationPage = restaurantPage.clickOnReserveBtn();

        checkoutSummaryPage = reservationPage.clickOnReserveNowBtn();
        userReservationsPage = checkoutSummaryPage.clickOnLoginIcon();
        userReservationsPage.restaurantIsDisplayed();
    }

    @Test
    public void firstRestaurantReservationAndThanLogIn() {
        /*
        открыть сайт
        ввести название ресторана savanna (переход на страницу фильтров)
        выбрать ресторан (клик) (переход на страницу ресторана)
        быбрать дату (первый день следующего месяца) и время(7.30)
        клик на кнопку зарезервировать (переход на страницу резервации)
        Клик на log in (переход на страницу log In)
        ввести пароли и логин
        клик на кнопку  (переход на страницу резервации)
        убедиться, что иконка сменилась
        клик кнопки зарезервировать
        клик на Confirm reservation (переход на страницу Your reservation is confirmed)
        клик на иконку Логин, выбор в drop-down поля Reservations (переход на страницу поля)
        убедиться, что в Upcoming reservations отражена страница ресторана, есть кнопка Cancel
        */
        homepage = open(BASE_URL, Homepage.class);
        homepage.accCookies();

        homepage.fillRestaurantField(RESTAURANT_NAME);
        homepage.fillDestinationField(RESTAURANT_CITY);
        filterPage = homepage.clickOnFindBtn();

        restaurantPage = filterPage.clickOnRestaurant();

        restaurantPage.dayChoose();
        restaurantPage.timeChoose();
        reservationPage = restaurantPage.clickOnReserveBtn();

        loginPage = reservationPage.clickOnLoginBtn();
        loginPage.fillInValidCred();
        loginPage.clickOnLoginBtnRP();
        reservationPage.userIconPresent();

        checkoutSummaryPage = reservationPage.clickOnReserveNowBtn();
        userReservationsPage = checkoutSummaryPage.clickOnLoginIcon();
        userReservationsPage.restaurantIsDisplayed();
    }

    @Test
    public void ShortFirstLogInThanRestaurantReservation() {
        homepage = open(BASE_URL, Homepage.class);
        homepage.accCookies();
        loginPage = homepage.clickOnLoginBtn();
        loginPage.fullLogin();
        homepage.fillInTheRestaurant();
        restaurantPage = filterPage.clickOnRestaurant();
        restaurantPage.reserveNow();
        checkoutSummaryPage = reservationPage.clickOnReserveNowBtn();
        userReservationsPage = checkoutSummaryPage.clickOnLoginIcon();
        userReservationsPage.restaurantIsDisplayed();
    }

    @Test
    public void ShortFirstRestaurantReservationAndThanLogIn() {
        homepage = open(BASE_URL, Homepage.class);
        homepage.accCookies();
        homepage.fillInTheRestaurant();
        restaurantPage = filterPage.clickOnRestaurant();
        restaurantPage.reserveNow();
        loginPage = reservationPage.clickOnLoginBtn();
        loginPage.fullLogin();
        checkoutSummaryPage = reservationPage.clickOnReserveNowBtn();
        userReservationsPage = checkoutSummaryPage.clickOnLoginIcon();
        userReservationsPage.restaurantIsDisplayed();
    }
}
