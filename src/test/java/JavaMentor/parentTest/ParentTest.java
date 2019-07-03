package JavaMentor.parentTest;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.MainUrl;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

public class ParentTest {
    public MainUrl mainUrl;
    public WebDriver webDriver;

    Logger logger = Logger.getLogger(getClass());

    private boolean isTestPass = false;

    public ParentTest() {
    }

    @Before
    public void setUp() {

        File driverPath = new File("../JavaMentor/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());

        File driverPathEdge = new File("../JavaMentor/drivers/MicrosoftWebDriver.exe");
        System.setProperty("webdriver.edge.driver", driverPathEdge.getAbsolutePath());

       //webDriver = new ChromeDriver();
        webDriver = new EdgeDriver();

        mainUrl = new MainUrl(webDriver);

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    //    @After
//    public void tearDown() {
//        if (!(webDriver == null)) {
//            webDriver.quit();
//        }
//    }
    public void checkAC(String messageICantSee, boolean actualResult, boolean expectedResult) {
        logger.info("2.3 - " + messageICantSee + " in Parent Test");
        if (!(actualResult == expectedResult))
            Assert.assertThat(messageICantSee, actualResult, is(expectedResult));
        setTestPass();
    }

    private void setTestPass() {
        isTestPass = true;
    }
}