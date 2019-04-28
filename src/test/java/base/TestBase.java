package base;

import io.appium.java_client.AppiumDriver;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import screens.ios.UICatalogMainScreen;
import utils.CommonUtils;

import java.io.IOException;


public class TestBase {

    public static AppiumDriver driver;
    public static UICatalogMainScreen ucms;
    public static String loadPropertyFile = "IOS_UICatalog.properties";
    public static Logger log = Logger.getLogger("devpinoyLogger");

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
            }
        }
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
        log.debug("Quitting the server");
    }

}
