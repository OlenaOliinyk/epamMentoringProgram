package JavaMentor.simpleTest.demoPartTwo;

import org.junit.Test;

public class DemoMainTest extends DemoMainPage {
    @Test
    public void doubleclickTest() {
        openDemo();
        dubleClick();
        rightClick();
        hoverClick();

    }

    @Test
    public void workWithTooltip(){
        openTooltip();
        verifyTextInHover();


    }

    @Test
    public void workWithSlider() {
        openSlider();
        moveSliderToHalf();
        getCurrentPosition();
        moveRandomly();
        getCurrentPosition();

    }
    @Test
    public void randomDay(){

        openDatepicker();
        clickDDField();
        selectFromDropDown();
        checkDateIsSelected();
    }

}
