package JavaMentor.simpleTest.wiki;

import org.junit.Test;

public class WikiMainTest extends WikiMainPage {
    public WikiMainTest() {

    }


    @Test
    public void selectRadioButton() {
        openTools();
        selectRadio();
        checkByAttributeValue();
        checkByCssSelector();


    }
}
