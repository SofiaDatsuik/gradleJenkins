package business.allure_logger;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class AllureReportLogger {

    private static final Logger logger = LogManager.getLogger(AllureReportLogger.class);

    @Step("{0}")
    public static void debuLog(final String log) {
        logger.debug("Logged to allure: " + log);
    }
}
