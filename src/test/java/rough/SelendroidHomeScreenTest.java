package rough;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.android.nativeapp.SelendroidHomeScreen;
import screens.android.nativeapp.WebViewInteractionScreen;
import utils.CommonUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SelendroidHomeScreenTest {

    public static AppiumDriver driver;

    public static WebDriverWait wait;

    public static void main(String[] args) throws IOException {
        CommonUtils.loadAndroidConfigProp("Android_selendroidTestApp.properties");
        CommonUtils.setAndroidCapabilities();
        driver =  CommonUtils.getAndroidDriver();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementById("android:id/alertTitle")));
        driver.findElementById("android:id/button1").click();
        SelendroidHomeScreen homeScreen = new SelendroidHomeScreen(driver);
        homeScreen.typeData("Hi Appium");
        homeScreen.validateTextView();
        WebViewInteractionScreen webview = homeScreen.startWebView();
        webview.validateWebViewText();
    }
}
