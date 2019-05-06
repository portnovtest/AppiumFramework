package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonUtils {

    private static int IMPLICIT_WAIT;
    private static int APPIUM_SERVER_PORT;
    private static String APPLICATION_APP;
    private static String UDID;
    private static String AUTOMATION_INSTRUMENTATION;
    private static String BROWSER_NAME;
    private static String PLATFORM_NAME;
    private static String DEVICE_NAME;
    private static String PLATFORM_VERSION;
    private static Properties prop = new Properties();
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    protected static URL serverUrl;
    protected static AppiumDriver driver;
    protected static int EXPLICIT_WAIT;
    protected static int DEFAULT_WAIT;
    protected static String APPLICATION_PATH;
    protected static String BASE_PKG;
    protected static String APPLICATION_ACTIVITY;
    protected static int NEW_COMMAND_TIMEOUT;
    protected static int DEVICE_READY_TIMEOUT;



    public static void loadIOSConfigProp(String propertyFileName) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                "/src/test/resources/properties/" + propertyFileName);
        prop.load(fis);

        IMPLICIT_WAIT = Integer.parseInt(prop.getProperty("implicit.wait"));
        APPIUM_SERVER_PORT = Integer.parseInt(prop.getProperty("appium.server.port"));
        APPLICATION_APP = prop.getProperty("application.app");
        UDID = prop.getProperty("udid");
        AUTOMATION_INSTRUMENTATION = prop.getProperty("automation.instrumentation");
        BROWSER_NAME = prop.getProperty("browser.name");
        PLATFORM_NAME = prop.getProperty("platform.name");
        DEVICE_NAME = prop.getProperty("device.name");
        PLATFORM_VERSION = prop.getProperty("platform.version");

    }

    public static void setIOSCapabilities(){
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, CommonUtils.BROWSER_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, CommonUtils.PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, CommonUtils.PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CommonUtils.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, CommonUtils.AUTOMATION_INSTRUMENTATION);
        capabilities.setCapability(MobileCapabilityType.APP, CommonUtils.APPLICATION_APP);
        capabilities.setCapability(MobileCapabilityType.UDID, CommonUtils.UDID);

    }

    public static void loadAndroidConfigProp(String propertyFileName) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                "/src/test/resources/properties/" + propertyFileName);
        prop.load(fis);
        EXPLICIT_WAIT = Integer.parseInt(prop.getProperty("explicit.wait"));
        DEFAULT_WAIT = Integer.parseInt(prop.getProperty("default.wait"));
        //APPLICATION_PATH = prop.getProperty("application.path");
        BASE_PKG = prop.getProperty("base.pkg");
        APPIUM_SERVER_PORT = Integer.parseInt(prop.getProperty("appium.server.port"));
        APPLICATION_ACTIVITY = prop.getProperty("application.activity");
        AUTOMATION_INSTRUMENTATION = prop.getProperty("automation.instrumentation");
        BROWSER_NAME = prop.getProperty("browser.name");
        PLATFORM_NAME = prop.getProperty("platform.name");
        DEVICE_NAME = prop.getProperty("device.name");
        PLATFORM_VERSION = prop.getProperty("platform.version");
        NEW_COMMAND_TIMEOUT = Integer.parseInt(prop.getProperty("new.command.timeout"));
        DEVICE_READY_TIMEOUT = Integer.parseInt(prop.getProperty("device.ready.timeout"));
    }

    public static void setAndroidCapabilities(){
        //File app = new File("/Users/phildolganov/IdeaProjects/AppiumFramework/src/test/resources/app/selendroid-test-app-0.17.0.apk");
        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, CommonUtils.BROWSER_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, CommonUtils.PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, CommonUtils.PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CommonUtils.DEVICE_NAME);
        //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, CommonUtils.AUTOMATION_INSTRUMENTATION);
        //capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, CommonUtils.NEW_COMMAND_TIMEOUT);
        capabilities.setCapability(AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT, CommonUtils.DEVICE_READY_TIMEOUT);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, CommonUtils.APPLICATION_ACTIVITY);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, CommonUtils.BASE_PKG);
    }

    public static AppiumDriver getIOSDriver() throws MalformedURLException {
        serverUrl = new URL("http://localhost:" + APPIUM_SERVER_PORT + "/wd/hub");
        driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public static AndroidDriver getAndroidDriver() throws MalformedURLException {
        serverUrl = new URL("http://localhost:" + APPIUM_SERVER_PORT + "/wd/hub");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return (AndroidDriver) driver;
    }
}
