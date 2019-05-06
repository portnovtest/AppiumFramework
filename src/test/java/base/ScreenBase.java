package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ScreenBase {

    public static AppiumDriver driver;

    public ScreenBase(AppiumDriver driver) {
        this.driver = driver;
        loadElements();
    }

    public void loadElements(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void hideKeyboard(){
        driver.hideKeyboard();
    }


}
