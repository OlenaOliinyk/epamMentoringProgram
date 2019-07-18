package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver, 30);
    }

    public void clickButton(WebElement element) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("try catch- click on element in ActionsWithOur Elements");
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }
    }

    public void enterText(WebElement element, String text) {
            try {
            element.clear();

            element.sendKeys(text);

            logger.info(text + "was inputed");

        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
        }


    }

    public boolean isElementPresentMetod(WebElement element) {
        logger.info("2.2 try catch in ActionWithElements");
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }


    public String getTextWithLink(WebElement element) {

        try {
            String inerText = element.getText();
            logger.info("2.1 getText() : "+inerText);

           // return element.getText();
            return inerText;
        } catch (Exception e) {
            logger.error("Can not work with element" + element);
            Assert.fail("Can not work with element" + element);
            return "";
        }

    }

}

