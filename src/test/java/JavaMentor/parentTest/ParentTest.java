package JavaMentor.parentTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainUrl;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    public MainUrl mainUrl;
    public WebDriver webDriver;


    public ParentTest() {
    }

    @Before
    public void setUp() {

        File driverPath = new File("../JavaMentor/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());

        webDriver = new ChromeDriver();

        mainUrl = new MainUrl(webDriver);

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        if (!(webDriver == null)) {
            webDriver.quit();
        }
    }

}