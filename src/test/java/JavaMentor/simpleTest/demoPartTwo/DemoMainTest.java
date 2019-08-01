package JavaMentor.simpleTest.demoPartTwo;

import org.junit.Test;

public class DemoMainTest extends DemoMainPage {
    @Test
    public void doubleclickTest() {
        openDirectLink("https://demoqa.com/tooltip-and-double-click/");
        dubleClick();
        rightClick();
        hoverClick();

    }

    @Test
    public void workWithTooltip(){
        openDirectLink("https://demoqa.com/tooltip/");
        verifyTextInHover();


    }

    @Test
    public void workWithSlider() {
        openDirectLink("https://demoqa.com/slider/");
        moveSliderToHalf();
        getCurrentPosition();
        moveRandomly();
        getCurrentPosition();

    }
    @Test
    public void randomDay(){

        openDirectLink("https://demoqa.com/datepicker/");
        clickDDField();
        selectFromDropDown();
        checkDateIsSelected();
    }

    @Test
    public void radioButton(){
        openDirectLink("https://demoqa.com/checkboxradio/");
        clickRadioButton();
        clickCheckBox();
    }
}
