package JavaMentor.parentTest;

import org.junit.Test;

public class MainPageTest extends ParentTest {

    public MainPageTest() {
    }

    @Test
    public void firstTest() {
        mainUrl.openLoginPage();
        mainUrl.enterLoginToInput("eleniks@gmail.com");
        mainUrl.enterPasswordToInput("---");
        mainUrl.clickOnSubmitButton();

        checkAC("check logo", mainUrl.checkLogo(),true);

    }
}
