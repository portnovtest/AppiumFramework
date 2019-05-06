package rough;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppiumServer;
import utils.CommonUtils;

import java.io.IOException;
import java.util.List;

public class MakeMyTrip {

    public static AndroidDriver driver;

    public static void main(String[] args) throws IOException {
        AppiumServer.stop();
        AppiumServer.start();

        CommonUtils.loadAndroidConfigProp("makemytrip.properties");
        CommonUtils.setAndroidCapabilities();

        driver = CommonUtils.getAndroidDriver();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.makemytrip:id/tvSkip"))).click();

       // WebElement services = driver.findElement(By.className("android.widget.LinearLayout"));

//        List<WebElement> items = driver.findElements(By.id("com.makemytrip:id/rlIconLayout"));
//        System.out.println(items.size());
//
//
//        for (WebElement service : items) {
//            System.out.println(service.getText());
//        }
//
//        items.get(0).click();


        AppiumServer.stop();
    }
}
