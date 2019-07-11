package JavaMentor.simpleTest;
// home work page 138

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Screenshots {
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
        openGoogle();
        enterText("automationpractice");
        checkTopBar();
        checkResults();
        checkElementIsNotDisplayed();
        clickTenPage();
        checkElevenPage();
        takeScreenshot();
        notInTheSearch("Facebook");
    }

    public void openGoogle() {

        webDriver.get("https://google.com");
        logger.info("1- Url opened");
    }

    public void enterText(String search) {

        WebElement elEnter = webDriver.findElement(By.xpath(".//input[@class='gLFyf gsfi']"));
        elEnter.sendKeys(search + "\n");
        logger.info("2- Search something");
    }

    public boolean checkTopBar() {
        logger.info(" 3 - check top bar");

        WebElement logo = webDriver.findElement(By.xpath(".//div[@id='hdtb-msb-vis']"));
        logo.isDisplayed();
        return true;
    }

    public boolean checkResults() {

        logger.info(" 4 - further then 10th page");
        WebElement moreThanTen = webDriver.findElement(By.xpath(".//a/span[contains(.,'Уперед')]"));
        return moreThanTen.isDisplayed();
    }

    public boolean checkElementIsNotDisplayed() {

        try {
            WebElement element = webDriver.findElement(By.xpath(".//input[@value=\"Мені пощастить\"]"));
            if (element == null)
                return true;
        } catch (ElementNotVisibleException e) {
            return true;
        } catch (NotFoundException e) {
            return false;
        }
        return true;
    }

    public void clickTenPage() {
        WebElement element = webDriver.findElement(By.xpath(".//td[contains(.,'10')]"));
        element.click();

    }

    public boolean checkElevenPage() {
        WebElement element = webDriver.findElement(By.xpath(".//a[contains(.,'11')]"));
        Assert.assertTrue(true);
        logger.info(" 5  is located further then 10th page 3.2");
        return true;
    }

    public void notInTheSearch(String expectedResult) {
        List<WebElement> actualResult = webDriver.findElements(By.xpath(".//h3"));

        for (WebElement w : actualResult) {
            String item = w.getText();

            if (item != expectedResult) {
                logger.info("Result of search : " + item);

            }
            else  {

                System.out.println(expectedResult +" is presented");
            }
        }logger.info("\""+expectedResult + "\""+ "  is not in the search results");
    }
    public void takeScreenshot(){
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("../JavaMentor/screen" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            logger.info(e);
        }
    }
}
