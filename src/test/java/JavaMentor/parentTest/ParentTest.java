package JavaMentor.parentTest;

import org.apache.log4j.Logger;
import org.junit.Before;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    public WebDriver webDriver;
    Logger logger= Logger.getLogger(getClass());

    public ParentTest() {

    }

    @Before
    public void setUp() {
        // File file =new File("");

        File driverPath = new File( "../JavaMentor/drivers/chromedriver.exe" );
        System.setProperty( "webdriver.chrome.driver", driverPath.getAbsolutePath());
        //
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait( 20, TimeUnit.SECONDS );




    }
}