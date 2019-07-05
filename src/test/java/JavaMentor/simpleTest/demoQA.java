package JavaMentor.simpleTest;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class demoQA {
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
//        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(scrFile,new File("../JavaMentor/screen"+System.currentTimeMillis()+".png"));
//        }catch (IOException e) {
//            logger.info(e);
//        }
//            webDriver.quit();
//
//    }

    @Test
    public void collectLinkTextToConsole() {
        openDemoSortable();
        checkSortedElements();
        dragAndDrop();
    }

    private void openDemoSortable() {

        webDriver.get("https://demoqa.com/sortable/");
        logger.info("1- Url opened");
    }
    private  void checkSortedElements() {
        List<WebElement> allItems = webDriver.findElements(By.xpath(".//li[@class='ui-state-default ui-sortable-handle']"));
        for (WebElement w : allItems) {
            String item = w.getText();
            logger.info(item);

        }
    }
    private void dragAndDrop(){
        WebElement From = webDriver.findElement(By.xpath(".//li[@class='ui-state-default ui-sortable-handle'][2]"));
        WebElement To = webDriver.findElement(By.xpath(".//li[@class='ui-state-default ui-sortable-handle'][5]"));
        Actions act = new Actions(webDriver);
        act.dragAndDrop(From,To).build().perform();
        logger.info("drag completed");

    }
}
