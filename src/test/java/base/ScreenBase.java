package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenBase {

    public static AppiumDriver driver;
    public WebDriverWait wait;

    public ScreenBase(AppiumDriver driver) {
        this.driver = driver;
        loadElements();
    }

    public void loadElements(){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void hideKeyboard(){
        driver.hideKeyboard();
    }

    public void waitForElement(long duration, String locator){
        wait = new WebDriverWait(driver,duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
    }

}
