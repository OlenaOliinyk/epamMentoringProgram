package JavaMentor.simpleTest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class demoQA {
    private WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    private WebDriverWait webDriverWait15;

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
    public void sortable() {
        openDemoSortable();
        checkSortedElements();
        dragAndDrop();
    }

    @Test
    public void selectable() {
        openSelectable();
        selectRandomly();

    }

    @Test
    public void resizable() {
        openResizable();
        printCurrentSize();
        WebElement resizeableElementToBigger = webDriver.findElement(By.xpath(".//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
        changeRectangleSize(resizeableElementToBigger, 350, 350);
        printCurrentSize();
        WebElement resizeableElementToSmaller = webDriver.findElement(By.xpath(".//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
        changeRectangleSize(resizeableElementToSmaller, 100, 100);
        printCurrentSize();

    }

    private void openDemoSortable() {

        webDriver.get("https://demoqa.com/sortable/");
        logger.info("1- Url opened");
    }

    private void openSelectable() {

        webDriver.get("https://demoqa.com/selectable/");
        logger.info("1- Url opened");
    }

    private void openResizable() {
        webDriver.get("https://demoqa.com/resizable/");
        logger.info("1- Url opened");
    }

    private void checkSortedElements() {
        List<WebElement> allItems = webDriver.findElements(By.xpath(".//li[@class='ui-state-default ui-sortable-handle']"));

        StringBuilder actualResult = new StringBuilder();
        for (WebElement w : allItems) {
            String item = w.getText();
            logger.info(item);
            actualResult.append(item + ", ");
        }
        List<String> expectedResult = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7");

        Assert.assertEquals(actualResult, expectedResult);

    }

    private void dragAndDrop() {
        WebElement From = webDriver.findElement(By.xpath(".//li[@class='ui-state-default ui-sortable-handle'][2]"));
        WebElement To = webDriver.findElement(By.xpath(".//li[@class='ui-state-default ui-sortable-handle'][5]"));
        Actions act = new Actions(webDriver);
        act.dragAndDrop(From, To).build().perform();
        logger.info("drag completed");

    }

    private void selectRandomly() {
        List<WebElement> elementsToBeSElectable = webDriver.findElements(By.xpath(".//li[@class='ui-widget-content ui-selectee']"));

        Random rand = new Random();
        int randomProduct1 = rand.nextInt(elementsToBeSElectable.size());
        elementsToBeSElectable.get(randomProduct1).click();
        logger.info("1 random element is selected");
        webDriverWait15 = new WebDriverWait(webDriver, 15);

        int randomProduct2 = rand.nextInt(elementsToBeSElectable.size());
        elementsToBeSElectable.get(randomProduct2).click();
        logger.info("2 random element is selected");
        webDriverWait15 = new WebDriverWait(webDriver, 15);


        int randomProduct3 = rand.nextInt(elementsToBeSElectable.size());
        elementsToBeSElectable.get(randomProduct3).click();
        logger.info("3 random element is selected");
        webDriverWait15 = new WebDriverWait(webDriver, 15);

    }

    public void printCurrentSize() {
        WebElement element = webDriver.findElement(By.id("resizable"));
        Dimension dimension = element.getSize();
        logger.info("height :" + dimension.height + " Width :" + dimension.width);

    }

    public void changeRectangleSize(WebElement toElement, int xOffset, int yOffset) {

        Actions action = new Actions(webDriver);
        action.clickAndHold(toElement).moveByOffset(xOffset, yOffset).release().build().perform();
        logger.info("size is changed : " +xOffset + "  " + yOffset);

    }

//    public void change(){
//
//        WebElement  target = new WebDriverWait(webDriver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")));
//        new Actions(webDriver).dragAndDropBy(target, 50, 50).build().perform();
//        System.out.println("Resizing of element Completed");
//    }
}


