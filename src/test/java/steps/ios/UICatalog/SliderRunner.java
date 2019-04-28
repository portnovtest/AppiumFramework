package steps.ios.UICatalog;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/feature/iOS/UICatalog/Sliders",plugin = {"pretty","html:target/cucumber"})

public class SliderRunner extends AbstractTestNGCucumberTests {
}
