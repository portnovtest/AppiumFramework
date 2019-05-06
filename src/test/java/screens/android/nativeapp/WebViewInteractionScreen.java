package screens.android.nativeapp;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebViewInteractionScreen extends ScreenBase {


    public WebViewInteractionScreen(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBys({
            @AndroidBy(id = "io.selendroid.testapp:id/tableHeader"),
            @AndroidBy(className = "android.widget.TextView")
    })
    public WebElement webviewText;

    public WebViewInteractionScreen validateWebViewText(){
        System.out.println(webviewText.getText());
        Assert.assertEquals("Web View Interaction",webviewText.getText());
        System.out.println(driver.getPageSource());
        return this;
    }
}
