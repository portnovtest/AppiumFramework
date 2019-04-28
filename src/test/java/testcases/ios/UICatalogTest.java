package testcases.ios;

import base.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.ios.UICatalogMainScreen;

public class UICatalogTest extends TestBase {

    @BeforeTest
    public void init(){
        ucms = new UICatalogMainScreen(driver);
    }

    @Test(priority = 1)
    public void switchTest(){
        ucms.handleSwitches();
        log.debug("Successfully executed Switch test");
    }

    @Test(priority = 2)
    public void sliderTest(){
        ucms.moveToSliders();
        ucms.handleSliders();
        log.debug("Successfully executed Slider test");
    }

    @Test(priority = 3)
    public void steppersTest(){
        ucms.handleSteppers();
        log.debug("Successfully executed Stepper test");
    }
}
