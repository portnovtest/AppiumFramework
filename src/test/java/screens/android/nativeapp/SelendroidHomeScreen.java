package screens.android.nativeapp;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SelendroidHomeScreen extends ScreenBase {

    public SelendroidHomeScreen(AppiumDriver driver) {
        super(driver);
    }



    @AndroidFindBy(id = "io.selendroid.testapp:id/my_text_field")
    public WebElement textfield;

    @AndroidFindBy(id = "io.selendroid.testapp:id/visibleButtonTest")
    public WebElement displayBtn;

    @AndroidFindBy(id = "io.selendroid.testapp:id/visibleTextView")
    public WebElement visibleText;

    @AndroidFindBy(id = "io.selendroid.testapp:id/buttonStartWebview")
    public WebElement startWebView;


    public SelendroidHomeScreen typeData(String data){
        textfield.sendKeys(data);
        return this;
    }

    public SelendroidHomeScreen validateTextView(){
        displayBtn.click();
        System.out.println(visibleText.getText());
        Assert.assertEquals(visibleText.getText(),"Text is sometimes displayed");
        return this;
    }

    public WebViewInteractionScreen startWebView(){
        startWebView.click();
        return new WebViewInteractionScreen(driver);
    }
}
