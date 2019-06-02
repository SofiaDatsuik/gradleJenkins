package business;


import business.allure_logger.AllureReportLogger;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import pom.LoginPage;


public class AutorizationBO {
    private LoginPage loginPage = new LoginPage();
    private static Logger LOG = Logger.getLogger(AutorizationBO.class.getName());

    @Step("Login user with email{0} , for method userEnterEmailAndClickNextButtton")
    public void userEnterEmailAndClickNextButtton(String email) {
        AllureReportLogger.debuLog("User enter email" + email + " in the login text box");
        loginPage.typeLoginAndSubmit(email);
        loginPage.clickNextButtonInGmailPage();
    }

    @Step("Login user with password {0}, for method userEnterPasswordAndClickNextButton")
    public void userEnterPasswordAndClickNextButton(String password) {
        AllureReportLogger.debuLog("Password enter password" + password + "in the Password text box");
        loginPage.typePassword(password);
        loginPage.clickButtonOnPasswordPage();
    }

    @Step("Verify verifyLogInSuccessful")
    public boolean verifyLogInSuccessful() {
        return loginPage.userLogInSuccessful();
    }

    @Step("Verify verifyUserEnterCorrectEmail ")
    public boolean verifyUserEnterCorrectEmail() {
        return loginPage.verifyUserEnterCorrectEmail();
    }


}
