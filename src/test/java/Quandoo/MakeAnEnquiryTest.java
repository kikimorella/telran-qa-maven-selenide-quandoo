package Quandoo;

import Quandoo.pages.MakeAnEnquiryPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * Class MakeAnEnquiryTest contains tests to Send Enquiry functionality
 */
public class MakeAnEnquiryTest {

    MakeAnEnquiryPage makeAnEnquiryPage;

    @Test
    /**
     * Negative test which ensures that there is no ability to send enquiry without ticking Terms checkbox.
     */
    public void enquiryWithoutTermsAndPrivacy() {
        //open
        makeAnEnquiryPage = open("https://www.quandoo.de/en/checkout/enquiry?restaurantUrl=cavallino-rosso-306", MakeAnEnquiryPage.class);
        makeAnEnquiryPage.acceptCookies();
        //choose date and time
        makeAnEnquiryPage.dayChoose();
        makeAnEnquiryPage.timeChoose();
        //fill in data
        makeAnEnquiryPage.fillInDataFields();
        //check required
        //check the btn
        makeAnEnquiryPage.clickOnSendEnquiryBtn();
        makeAnEnquiryPage.sendEnquiryBtnElt().should(Condition.visible);
    }
}
