package screens.android.nativeapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SelendroidHomeScreen {


    public SelendroidHomeScreen() {
    }

    @AndroidFindBy(id = "io.selendroid.testapp:id/my_text_field")
    public WebElement textfield;

    public void typeData(String data){

    }
}
