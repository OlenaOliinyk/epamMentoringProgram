package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    WebDriver webDriver;
    Logger logger;
    ActionsWithOurElements actionsWithOurElements;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger( getClass() );
        actionsWithOurElements = new ActionsWithOurElements(webDriver);

        PageFactory.initElements(webDriver,this);
    }


    public void open(String url) {
        try {
            webDriver.get( url );
        }catch (Exception e){
            logger.error( "Page not opened " + url  );
            Assert.fail("Page not opened " + url);
        }
    }


}