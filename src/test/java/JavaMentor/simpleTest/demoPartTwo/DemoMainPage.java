package JavaMentor.simpleTest.demoPartTwo;
//pages 142, 143, 144, 145, 146

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

import java.util.List;
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

    public void openDatepicker() {

        webDriver.get("https://demoqa.com/datepicker/");
        logger.info("1 - Url opened");
    }

    public void openCheckBoxRadio() {

        webDriver.get("https://demoqa.com/checkboxradio/");
        logger.info("1 - Url opened");
    }

    public void openSlider() {

        webDriver.get("https://demoqa.com/slider/");
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


    public void moveSliderToHalf() {
        WebElement slider = webDriver.findElement(By.id("slider"));
        int width = slider.getSize().getWidth();
        WebElement element = webDriver.findElement(By.xpath(".//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        logger.info(width + " length of slider");
        Actions move = new Actions(webDriver);
        int x = 80;
        //move.dragAndDropBy(element, ((width * x) / 100), 0).click();
        move.dragAndDropBy(element, (width / 2), 0).click();
        // move.dragAndDropBy(element, 25, 0).click();
        move.build().perform();

    }

    public void getCurrentPosition() {
        WebElement element = webDriver.findElement(By.xpath(".//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));

        logger.info(element.getCssValue("left") + " value");
        logger.info(element.getAttribute("style") + " attribute");
        logger.info("----------");
    }

    public void moveRandomly() {
        WebElement element = webDriver.findElement(By.xpath(".//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        Actions move = new Actions(webDriver);

        int index = (int) (Math.random() * 500);
        logger.info(index + " random value");
        move.dragAndDropBy(element, index, 0).click();

        move.build().perform();
        logger.info("moved randomly");
    }

    public void clickDDField() {
        WebElement element = webDriver.findElement(By.id("datepicker"));
        element.click();
        logger.info("dd is visible");
    }

    public void selectFromDropDown() {
        WebElement element = webDriver.findElement(By.xpath(".//tbody"));
        List<WebElement> dropDownMonth = element.findElements(By.tagName("td"));
        int index = (int) (Math.random() * 30);
        logger.info(index + " random value");
        dropDownMonth.get(index).click();


    }

    public void checkDateIsSelected() {


        WebElement element = webDriver.findElement(By.id("datepicker"));
        try {
            element.isSelected();
            logger.info("date - is selected");
        } catch (Exception e) {
            logger.info("element is not Enabled");
        }
    }

    public void clickRadioButton() {
        WebElement element = webDriver.findElement(By.xpath("(.//label[@class='ui-checkboxradio-label ui-corner-all ui-button ui-widget ui-checkboxradio-radio-label']/span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank'])[1]"));
        element.click();
        logger.info("radio button 1 is clicked");
        WebElement element1 = webDriver.findElement(By.xpath("(.//label[@class='ui-checkboxradio-label ui-corner-all ui-button ui-widget ui-checkboxradio-radio-label']/span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank'])[2]"));
        element1.click();
        logger.info("radio button 2 is clicked");
    }

    public void clickCheckBox() {
        WebElement element = webDriver.findElement(By.xpath("(.//label[@class='ui-checkboxradio-label ui-corner-all ui-button ui-widget']/span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank'])[1]"));
        element.click();
        logger.info("check box 1 is clicked");
        WebElement element1 = webDriver.findElement(By.xpath("(.//label[@class='ui-checkboxradio-label ui-corner-all ui-button ui-widget']/span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank'])[2]"));
        element1.click();
        logger.info("check box 2 is clicked");
    }
}


