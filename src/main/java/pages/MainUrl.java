package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainUrl extends ParentPage {
    @FindBy(xpath = "(.//input[@type='email'])")
    private WebElement enterLogin;
    @FindBy(xpath = "(.//input[@type='password'])")
    private WebElement enterPass;
    @FindBy(xpath = "(.//input[@value='Log In'])")
    private WebElement logButton;
    @FindBy(xpath = ".//div[@id='logoutMenu']")
    private WebElement logo;

    public MainUrl(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {

        open("https://www.facebook.com/"
        );
        logger.info("1.2 -Url opened in MainUrl ");
    }

    public void enterLoginToInput(String login) {
        actionsWithOurElements.enterText(enterLogin, login);

    }

    public void enterPasswordToInput(String password) {
        actionsWithOurElements.enterText(enterPass, password);

    }

    public void clickOnSubmitButton() {
        //alt+enter- sozdat metod field
        actionsWithOurElements.clickButton(logButton);
    }

    public boolean checkLogo() {
        logger.info(" 2 - righLogo - isElementPresent Metod in HomePage");
        return
                actionsWithOurElements.isElementPresentMetod(logo);
    }
}
