package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinChooseNewPasswordPage;
import page.LinkedinPasswordChangedSuccessPage;
import page.LinkedinPasswordResetSubmitPage;
import page.LinkedinRequestPasswordResetPage;

public class LinkedinPasswordResetTest extends LinkedinBaseTest{

    String userEmail = "olapitskiy@ukr.net";
    String newPassword = "5625262";

    /**
     * Test that verifies reset of the password with confirmation by e-mail
     */
    @Test
    public void successfulPasswordReset() {
        LinkedinRequestPasswordResetPage requestPasswordResetPage = landingPage.forgotPasswordLinkClick();
        Assert.assertTrue(requestPasswordResetPage.isLoaded(), "requestPasswordResetPage is not loaded");

        LinkedinPasswordResetSubmitPage passwordResetSubmitPage = requestPasswordResetPage.submitEmail(userEmail);
        String resetPasswordLink = passwordResetSubmitPage.getResetPasswordLinkFromEmail(userEmail);
        //entering capcha manually :)
        Assert.assertTrue(passwordResetSubmitPage.isLoaded(), "passwordResetSubmitPage is not loaded");

        LinkedinChooseNewPasswordPage chooseNewPasswordPage = passwordResetSubmitPage.navigateToResetPasswordLink(resetPasswordLink);
        Assert.assertTrue(chooseNewPasswordPage.isLoaded(), "chooseNewPasswordPage is not loaded");

        LinkedinPasswordChangedSuccessPage passwordChangedSuccessPage = chooseNewPasswordPage.submitNewPassword(newPassword);
        Assert.assertTrue(passwordChangedSuccessPage.isLoaded(), "passwordChangedSuccessPage is not loaded");

    }
}