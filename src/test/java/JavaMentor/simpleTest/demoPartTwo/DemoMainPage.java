package JavaMentor.simpleTest.demoPartTwo;
//page 142, 143

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DemoMainPage {
    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {

        WebDriverManager chromeDriver = WebDriverManager.chromedriver();
        chromeDriver.setup();
        System.setProperty("webdriver.chrome.driver", chromeDriver.getBinaryPath());


        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @After
    public void tearDown() {
        webDriver.quit();

    }

    public void openDemo() {

        webDriver.get("https://demoqa.com/tooltip-and-double-click/");
        logger.info("1 - Url opened");
    }

    public void openTooltip() {

        webDriver.get("https://demoqa.com/tooltip/");
        logger.info("1 - Url opened");
    }

    public void rightClick() {

        WebElement element = webDriver.findElement(By.id("doubleClickBtn"));
        Actions action = new Actions(webDriver);
        action.doubleClick(element).perform();
        logger.info("right click");
    }

    public void dubleClick() {

        WebElement element = webDriver.findElement(By.id("rightClickBtn"));
        Actions action = new Actions(webDriver);
        action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
        logger.info("double click");
    }

    public void hoverClick() {

        WebElement element = webDriver.findElement(By.id("tooltipDemo"));
        Actions action = new Actions(webDriver);
        action.moveToElement(element).build().perform();
        logger.info("Hover navigate");
    }

    public void verifyTextInHover() {

        WebElement element = webDriver.findElement(By.xpath(".//input[contains(@title,'statistical purposes')]"));
        try {
            element.isEnabled();
            logger.info("statistical purposes - is enabled");
        } catch (Exception e) {
            logger.info("element is not Enabled");
        }


    }
}
