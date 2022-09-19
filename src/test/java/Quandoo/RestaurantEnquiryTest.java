package Quandoo;

import Quandoo.pages.RestaurantEnquiryPage;
import org.junit.jupiter.api.Test;

import static Quandoo.pages.Page.ENQUIRY_URL;
import static com.codeborne.selenide.Selenide.open;

/**
 * Class MakeAnEnquiryTest contains tests to Send Enquiry functionality
 */
public class RestaurantEnquiryTest {

    // classes
    RestaurantEnquiryPage restaurantEnquiryPage;

    @Test
    /**
     * Negative test which ensures that there is no ability to send enquiry without ticking Terms checkbox.
     */
    public void enquiryWithoutTermsAndPrivacy() {
        //open
        restaurantEnquiryPage = open(ENQUIRY_URL, RestaurantEnquiryPage.class);
        restaurantEnquiryPage.acceptCookies();
        //choose date and time
        restaurantEnquiryPage.sendEnquiryBtnElt().attr("disabled"); // поймать атрибут disabled
        restaurantEnquiryPage.dayChoose();
        restaurantEnquiryPage.timeChoose();
        //fill in data
        restaurantEnquiryPage.fillInDataFields();
        //check required
        //check the btn
        restaurantEnquiryPage.sendEnquiryBtnIsActive();
//        RestaurantEnquiryTest.clickOnSendEnquiryBtn();
    }
}
