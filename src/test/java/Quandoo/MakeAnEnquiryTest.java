package Quandoo;

import Quandoo.pages.MakeAnEnquiryPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static Quandoo.pages.Page.ENQUIRY_URL;
import static com.codeborne.selenide.Selenide.open;

/**
 * Class MakeAnEnquiryTest contains tests to Send Enquiry functionality
 */
public class MakeAnEnquiryTest {

    // classes
    MakeAnEnquiryPage makeAnEnquiryPage;

    @Test
    /**
     * Negative test which ensures that there is no ability to send enquiry without ticking Terms checkbox.
     */
    public void enquiryWithoutTermsAndPrivacy() {
        //open
        makeAnEnquiryPage = open(ENQUIRY_URL, MakeAnEnquiryPage.class);
        makeAnEnquiryPage.acceptCookies();
        //choose date and time
        makeAnEnquiryPage.sendEnquiryBtnElt().attr("disabled"); // поймать атрибут disabled - attr(String)
        makeAnEnquiryPage.dayChoose();
        makeAnEnquiryPage.timeChoose();
        //fill in data
        makeAnEnquiryPage.fillInDataFields();
        //check required
        //check the btn
        makeAnEnquiryPage.clickOnSendEnquiryBtn();
//        makeAnEnquiryPage.sendEnquiryBtnElt().attr("disabled"); // поймать отсутствие атрибута disabled - attr(String)
    }
}
