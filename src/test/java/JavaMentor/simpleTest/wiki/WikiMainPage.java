package JavaMentor.simpleTest.wiki;
//page 83
//page 101

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WikiMainPage {

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

    public void openTools() {

        webDriver.get("https://www.toolsqa.com/automation-practice-form/");
        logger.info("1 - Url opened");
    }

    public void openWiki() {
        webDriver.get("https://en.wikipedia.org/wiki/Main_Page");
        logger.info("1 - Url opened");
    }

    public void selectRadio() {
        WebElement oRadioButton = webDriver.findElement(By.id("sex-0"));
        oRadioButton.click();
        oRadioButton.isSelected();
        logger.info("radiobutton is selected");

    }

    public void checkByAttributeValue() {
        WebElement element = webDriver.findElement(By.id("exp-2"));
        String attValue = element.getAttribute("id");
        logger.info(attValue + " attribute value");
        element.click();

    }

    public void checkByCssSelector() {
        WebElement element = webDriver.findElement(By.cssSelector("input[id='tool-2']"));
        String cssValue = element.getCssValue("cssSelector");
        logger.info(cssValue + " css value");
        element.click();
    }

    public void takeScreenshot() {
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("../JavaMentor/screen" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            logger.info(e);
        }
    }

    public void mouseDown() {
        WebElement element = webDriver.findElement(By.id("mp-dyk"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element);
        actions.perform();
    }


}
