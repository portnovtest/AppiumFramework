package steps.ios.UICatalog;

import base.TestBase;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.annotations.BeforeTest;
import screens.ios.UICatalogMainScreen;

import java.util.List;
import java.util.Map;

public class SliderSteps extends TestBase {

    @BeforeTest
    public void init(){
        ucms = new UICatalogMainScreen(driver);
    }

    @Given("^I navigated to Slider interface$")
    public void I_navigated_to_Slider_interface(){
        ucms.moveToSliders();
    }

    @Then("I moved slider")
    public void I_moved_slider(DataTable table){

        ucms.handleSliders();
//        List<Map<String,String>> data = table.asMaps(String.class, String.class);
//        System.out.println("@Then --I_moved_slider " + data.get(0).get("sliderType"));
//        System.out.println("@Then --I_moved_slider " + data.get(1).get("sliderType"));
//        System.out.println("@Then --I_moved_slider " + data.get(2).get("sliderType"));
    }
}
