package test;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinPasswordResetSubmitPage;
import page.LinkedinRequestPasswordResetPage;
import utils.GMailService;

import static java.lang.Thread.sleep;

public class LinkedinPasswordResetTest extends LinkedinBaseTest{

    String userEmail = "olapitskiy@gmail.com";

    @Test
    public void successfulPasswordReset() throws InterruptedException {
        LinkedinRequestPasswordResetPage requestPasswordResetPage = landingPage.forgotPasswordLinkClick();
        Assert.assertTrue(requestPasswordResetPage.isLoaded(), "requestPasswordResetPage is not loaded");

        LinkedinPasswordResetSubmitPage passwordResetSubmitPage = requestPasswordResetPage.submitEmail(userEmail);

        String messageSubjectPartial = "here's the link to reset your password";
        String messageToPartial = "olapitskiy@gmail.com";
        String messageFromPartial = "security-noreply@linkedin.com";



    }
}