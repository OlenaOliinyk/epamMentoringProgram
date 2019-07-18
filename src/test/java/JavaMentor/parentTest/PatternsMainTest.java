package JavaMentor.parentTest;
// module 10 , Page Object, 45 page

import org.junit.Test;

public class PatternsMainTest extends ParentTest {

    public PatternsMainTest() {
    }

    @Test
    public void pageObjectTest() {

        practice.openAutomationPractice();
        practice.clickOnWomenButton();
        practice.clickOnDressesButton();
        practice.getCollorsQuantity();
        practice.clickOnCollorCheckBox();


    }


}
