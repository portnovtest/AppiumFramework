package testcases.android;

import base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.android.nativeapp.WebViewInteractionScreen;
import utils.CommonUtils;

import java.io.IOException;

public class WebViewScreenValidationTest extends TestBase {

    @Test
    public void validateWebViewScreen(){
        webview = new WebViewInteractionScreen(driver);
        webview.validateWebViewText();
    }
}
