package base;

import io.appium.java_client.AppiumDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import screens.android.nativeapp.SelendroidHomeScreen;
import screens.android.nativeapp.WebViewInteractionScreen;
import screens.ios.UICatalogMainScreen;
import utils.CommonUtils;

import java.io.IOException;


public class TestBase {

    public static AppiumDriver driver;
    public static UICatalogMainScreen ucms;
    public static String loadPropertyFile = "Android_selendroidTestApp.properties";
    public static Logger log = Logger.getLogger("devpinoyLogger");

    public SelendroidHomeScreen homeScreen;
    public WebViewInteractionScreen webview;

    @BeforeSuite
    public void setUp() throws IOException {
       //load properties file, desired capabilities, IOS Driver / Appium driver
        if (driver==null){
            if (loadPropertyFile.startsWith("IOS")){
                CommonUtils.loadIOSConfigProp(loadPropertyFile);
                CommonUtils.setIOSCapabilities();
                log.debug("Loading IOS Property file");
                driver = CommonUtils.getIOSDriver();
            } else if (loadPropertyFile.startsWith("Android")){
                CommonUtils.loadAndroidConfigProp(loadPropertyFile);
                CommonUtils.setAndroidCapabilities();
                log.debug("Loading Android Property file");
                driver = CommonUtils.getAndroidDriver();
                WebDriverWait wait = new WebDriverWait(driver,20);
                wait.until(ExpectedConditions.visibilityOf(driver.findElementById("android:id/alertTitle")));
                driver.findElementById("android:id/button1").click();
            }
        }
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
        log.debug("Quitting the server");
    }

}
