package JavaMentor.simpleTest.wiki;

import org.junit.Test;

public class WikiMainTest extends WikiMainPage {

    public WikiMainTest() {

    }

    //page 83
    @Test
    public void selectRadioButton() {
        openTools();
        selectRadio();
        checkByAttributeValue();
        checkByCssSelector();
        takeScreenshot();

    }

    //page 101
    @Test
    public void screenshotsWiki() {
        openWiki();
        takeScreenshot();
        mouseDown();
        takeScreenshot();
    }
}
