import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import util.DriverManager;
import util.readers.JsonReader;

import java.io.FileNotFoundException;
import java.util.Properties;


public class FunctionalTest {
    private JsonReader jsonReader = new JsonReader();
    private static Logger LOG = Logger.getLogger(FunctionalTest.class.getName());

    @BeforeMethod
    public void setURL() {
        DriverManager.getWebDriver().get("https://www.gmail.com");
        LOG.info("Web application launched");
        Assert.assertEquals(DriverManager.getWebDriver().getTitle() , "Gmail" );
    }

    @AfterMethod
    public void driverTearDown() {
        DriverManager.closeDriver();
        LOG.info("Browser closed");
    }

    @DataProvider(parallel = true)
    public Object[] user() throws FileNotFoundException {
        return jsonReader.getData();
    }

    public void setProrerties(){
        Properties pros = System.getProperties();
        pros.list(System.out);

        // Get a particular System property given its key
        // Return the property value or null
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.library.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty ("user.dir"));
        System.out.println(System.getProperty("java.specification.version"));
    }

}
