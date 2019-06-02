package business.allure_logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.yandex.qatools.allure.annotations.Step;

public class AllureReportLogger {

    private static final Logger logger = LogManager.getLogger(AllureReportLogger.class);

    @Step("{0}")
    public static void debuLog(final String log){
        logger.debug("Logged to allure: " + log);
    }
}
