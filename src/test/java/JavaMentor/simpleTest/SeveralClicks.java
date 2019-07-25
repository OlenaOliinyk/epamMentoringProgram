package JavaMentor.simpleTest;
//page 140
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeveralClicks {


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
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("../JavaMentor/screen" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            logger.info(e);
        }
        webDriver.quit();

    }


    @Test
    public void selectable() {
        openSelectable();
        selectRandomlyThree();


    }

    private void openSelectable() {

        webDriver.get("https://demoqa.com/selectable/");
        logger.info("1- Url opened");
    }
    private void selectRandomlyThree() {
        List<WebElement> elementsToBeSElectable = webDriver.findElements(By.xpath(".//li[@class='ui-widget-content ui-selectee']"));
        Collections.shuffle(elementsToBeSElectable);
        int randomSeriesLength = 3;
        List<WebElement> randomSeriesOfThreeElements = elementsToBeSElectable.subList(0, randomSeriesLength);

        WebElement firstElement = randomSeriesOfThreeElements.get(0);
        WebElement secondElement = randomSeriesOfThreeElements.get(1);
        WebElement thirdElement = randomSeriesOfThreeElements.get(2);

        Actions chooseSeveralItems = new Actions(webDriver);

        chooseSeveralItems.keyDown(Keys.CONTROL)
                .click(firstElement)
                .click(secondElement)
                .click(thirdElement)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

    }



}
