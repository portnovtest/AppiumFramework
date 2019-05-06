package testcases.android;

import base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.android.nativeapp.SelendroidHomeScreen;
import screens.android.nativeapp.WebViewInteractionScreen;
import utils.CommonUtils;

import java.io.IOException;

public class SelendroidHomeScreenValidationTest extends TestBase {


    @Test
    public void validateHomeScreenTest(){
        SelendroidHomeScreen homeScreen = new SelendroidHomeScreen(driver);
        homeScreen.typeData("Hi Appium");
        homeScreen.validateTextView();
        homeScreen.startWebView();
    }
}
