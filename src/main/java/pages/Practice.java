package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Practice extends ParentPage {
    @FindBy(xpath = "(.//a[@title='Dresses'])[2]")
    private WebElement clickDresses;

    @FindBy(xpath = ".//a[@title='Women']")
    private WebElement clickWomen;

    @FindBy(xpath = "(.//ul[@id='ul_layered_id_attribute_group_3']/li[@class='nomargin hiddable col-lg-6'])[4]")
    private WebElement collorCheckBox;


    public Practice(WebDriver webDriver) {
        super(webDriver);
    }


    public void openAutomationPractice() {

        open("http://automationpractice.com/index.php");
        logger.info(" Url opened in MainUrl ");
    }

    public void clickOnWomenButton() {

        actionsWithOurElements.clickButton(clickWomen);
        logger.info("Women button is clicked");
    }

    public void clickOnDressesButton() {

        actionsWithOurElements.clickButton(clickDresses);
        logger.info("Dresses button is clicked");
    }

    public void clickOnCollorCheckBox() {

        actionsWithOurElements.clickButton(collorCheckBox);
        logger.info("Orange checkbox is clicked");
    }

    public void getCollorsQuantity() {
        WebElement element = webDriver.findElement(By.xpath("(.//ul[@id='ul_layered_id_attribute_group_3']/li[@class='nomargin hiddable col-lg-6'])[4]"));
        logger.info(element.getText());
    }
}
