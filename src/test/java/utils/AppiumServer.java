package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class AppiumServer {
    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;

    public static void start(){
        service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
                        .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
        service.start();
    }

    public static void stop(){
        if (service != null){
            service.stop();
        }
    }
}
