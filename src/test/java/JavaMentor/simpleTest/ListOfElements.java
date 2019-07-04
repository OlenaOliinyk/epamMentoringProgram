package JavaMentor.simpleTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ListOfElements {

    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {

        File driverPath = new File("../JavaMentor/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());

        File driverPathEdge = new File("../JavaMentor/drivers/MicrosoftWebDriver.exe");
        System.setProperty("webdriver.edge.driver", driverPathEdge.getAbsolutePath());

        webDriver = new ChromeDriver();
        //webDriver = new EdgeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (!(webDriver == null)) {
            webDriver.quit();
        }
    }

    @Test
    public void collectLinkTextToConsole() {
        openWikipedia();
        collectAllLinks();
    }

    public void openWikipedia() {

        webDriver.get("https://en.wikipedia.org/wiki/Main_Page");

        logger.info(" Url opened");
    }

    public void collectAllLinks() {

        List<WebElement> allLinksElements = webDriver.findElements(By.xpath(".//a[@href]"));
        for (WebElement w : allLinksElements) {
            String link = w.getText();
            logger.info(link);
        }
    }
}