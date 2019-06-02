package listener;


import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;
import util.DriverManager;

public class TestListener implements ITestListener {

    private static Logger LOG = Logger.getLogger(TestListener.class.getName());

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOG.info("Teststarted running:" + iTestResult.getMethod().getMethodName()
                + " at:" + iTestResult.getStartMillis());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOG.info("Result success" + iTestResult.getName());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        makeScreenshot();
        LOG.info("Test FAILED: " + iTestResult.getName());
        if (iTestResult.getThrowable() != null) {
            iTestResult.getThrowable().printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOG.info("Testskipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Console error", type = "text/plain")
    private byte[] addConsoleError(String errorText) {
        return errorText.getBytes();
    }}


