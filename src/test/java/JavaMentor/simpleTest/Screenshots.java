package JavaMentor.simpleTest;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
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

//    @After
//    public void tearDown() {
//        if (!(webDriver == null)) {
//            webDriver.quit();
//        }
//    }

    @Test
    public void collectLinkTextToConsole() {
        openGoogle();
        enterText("automationpractice");
        checkTopBar();
        checkResults();
        checkElementIsNotDisplayed(false);

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
       // moreThanTen.isDisplayed();
        return moreThanTen.isDisplayed();
    }

    public boolean checkElementIsNotDisplayed(boolean expectedResult) {
        logger.info(" 5 - is not in the search results");
        WebElement isNotInSearch = webDriver.findElement(By.xpath(".//input[@value=\"Мені пощастить\"]"));

        return isNotInSearch.isDisplayed();
    }

}


