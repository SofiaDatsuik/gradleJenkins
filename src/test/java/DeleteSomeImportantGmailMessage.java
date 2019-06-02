import business.AutorizationBO;
import business.MarkAndDeleteImportantMessageBO;
import listener.TestListener;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.readers.Message;
import util.readers.UserData;

@Listeners(TestListener.class)
public class DeleteSomeImportantGmailMessage extends FunctionalTest {

    @Test(dataProvider = "user")
    public void chooseSomeImportantMessagesAndDeleteThem(UserData userData) throws InterruptedException {

        AutorizationBO autorizationBO = new AutorizationBO();
        MarkAndDeleteImportantMessageBO markAndDeleteImportantMessageBO = new MarkAndDeleteImportantMessageBO();

        autorizationBO.userEnterEmailAndClickNextButtton(userData.getUserEmail());
        Assert.assertTrue(autorizationBO.verifyUserEnterCorrectEmail(), "Gmail Password Page is visible");
        autorizationBO.userEnterPasswordAndClickNextButton(userData.getPassword());
        Assert.assertTrue(autorizationBO.verifyLogInSuccessful(), "User autorize successful");

        markAndDeleteImportantMessageBO.chooseImportantMessages();
        Assert.assertTrue(markAndDeleteImportantMessageBO.messagesMarkedAsImportant(), "Messages is marked");
        markAndDeleteImportantMessageBO.clickImportantButton();
        markAndDeleteImportantMessageBO.deleteSomeImportantMessages();
        Assert.assertTrue(markAndDeleteImportantMessageBO.messagesDeleted(), "Conversation moved to Trash.");
    }
}
