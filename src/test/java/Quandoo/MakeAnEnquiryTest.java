package Quandoo;

import Quandoo.pages.MakeAnEnquiryPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class MakeAnEnquiryTest {

    MakeAnEnquiryPage makeAnEnquiryPage;

    @Test
    public void enquiryWithoutTermsAndPrivacy() {
        //open
        makeAnEnquiryPage = open("https://www.quandoo.de/en/checkout/enquiry?restaurantUrl=cavallino-rosso-306", MakeAnEnquiryPage.class);
        makeAnEnquiryPage.clickAcceptCookiesBtn();
        //choose date and time
        makeAnEnquiryPage.dayChoose();
        makeAnEnquiryPage.timeChoose();
        //fill in data
        makeAnEnquiryPage.fillInDataFields();
        //check required
        //check the btn
        makeAnEnquiryPage.checkSendEnquiryBtnExists();
    }
}
