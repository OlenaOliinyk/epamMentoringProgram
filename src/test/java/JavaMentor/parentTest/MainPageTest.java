package JavaMentor.parentTest;

import org.junit.Test;

public class MainPageTest extends ParentTest {

    public MainPageTest() {
    }

    @Test
    public void firstTest() {
        mainUrl.openLoginPage();
        mainUrl.enterLoginToInput("eleniksummer@gmail.com");
        mainUrl.enterPasswordToInput("w1526v");
        mainUrl.clickOnSubmitButton();

        checkAC("check logo", mainUrl.checkLogo(),true);

    }
}
