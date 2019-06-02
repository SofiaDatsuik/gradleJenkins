package business;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import pom.GmailHomePage;
import pom.GmailImportantPage;
import util.DriverManager;

public class MarkAndDeleteImportantMessageBO {

    private GmailHomePage gmailHomePage = new GmailHomePage();
    private GmailImportantPage gmailImportantPage = new GmailImportantPage();
    private static Logger LOG = Logger.getLogger(MarkAndDeleteImportantMessageBO.class.getName());

    @Step(" Mark important message")
    public void markImportantMessages() throws InterruptedException {
        gmailHomePage.markMessagesAsImportant();
        DriverManager.refreshPage();
        LOG.info("3 conversation marked as important");
    }

    @Step(" Click  important message button ")
    public void clickImportantButton() {
        gmailImportantPage.clickImporatantButton();
    }

    @Step("  Delete important message")
    public void deleteImportantMessages() {
        gmailImportantPage.clickDeleteButton();
        LOG.info("Conversations are deleted");
    }

    @Step(" Verify messagesMarkedAsImportant")
    public boolean messagesMarkedAsImportant() {
        return gmailHomePage.conversationWasMarked();
    }

    @Step(" Verify messagesDeleted(")
    public boolean messagesDeleted() {
        return gmailImportantPage.verifyDeleteMessages();
    }


    @Step("Choose with method chooseImportantMessages")
    public void chooseImportantMessages() throws InterruptedException {
        gmailHomePage.markMessagesAsImportant();
        LOG.info("3 conversation marked as important");
    }

    @Step(" Delete important message")
    public void deleteSomeImportantMessages() {
        gmailImportantPage.chooseSomeImportantMessages();
        LOG.info("Messages was choosen");
        gmailImportantPage.clickDeleteButton();
        LOG.info("Conversations are deleted");
    }


}
