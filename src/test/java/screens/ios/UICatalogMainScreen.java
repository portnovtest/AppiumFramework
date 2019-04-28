package screens.ios;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class UICatalogMainScreen extends ScreenBase {
    public UICatalogMainScreen(AppiumDriver driver) {
        super(driver);
    }

    public void moveToSliders(){
        driver.findElement(By.name("Sliders")).click();
    }

    public void handleSliders() {

        System.out.println(driver.findElements(By.className("UIASlider")).size());

        WebElement slider = (WebElement)driver.findElements(By.className("UIASlider")).get(0);
        slider.sendKeys("0.8");
        System.out.println(slider.getAttribute("value"));
        slider = (WebElement)driver.findElements(By.className("UIASlider")).get(1);
        slider.sendKeys("0.2");
        System.out.println(slider.getAttribute("value"));
        slider = (WebElement)driver.findElements(By.className("UIASlider")).get(2);
        slider.sendKeys("0.5");
        System.out.println(slider.getAttribute("value"));
        driver.findElement(By.name("UICatalog")).click();
    }

    public void handleSwitches() {

        scrollTo("down",1);
        driver.findElement(By.name("Switches")).click();

        WebElement switches = (WebElement) driver.findElements(By.className("UIASwitch")).get(0);

        System.out.println(switches.getAttribute("value"));

        //Turn on the Switch
        if(switches.getAttribute("value").equals("1")){

            switches.click();

        }

        System.out.println(switches.getAttribute("value"));

        //Turn off
        if(switches.getAttribute("value").equals("0")){

            switches.click();

        }

        System.out.println(switches.getAttribute("value"));

        driver.findElement(By.name("UICatalog")).click();
    }

    public void handleSteppers()  {

        driver.findElement(By.name("Steppers")).click();

//        List<MobileElement> text = driver.findElements(By.className("UIAStaticText"));
//
//
//        for(MobileElement staticText : text){
//
//            System.out.println(staticText.getAttribute("name"));
//
//        }

        System.out.println(driver.findElements(By.className("UIAButton")).size());

        //increment
        while(!((WebElement) driver.findElements(By.className("UIAStaticText")).get(1)).getAttribute("name").equals("10")){

            ((WebElement) driver.findElements(By.name("Increment")).get(0)).click();
            break;
        }

        //decrement

        while(!((WebElement) driver.findElements(By.className("UIAStaticText")).get(1)).getAttribute("name").equals("0")){

            ((WebElement) driver.findElements(By.name("Decrement")).get(0)).click();


        }

        driver.findElement(By.name("UICatalog")).click();
    }

    public static void scrollTo(String direction, int times)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (direction.equals("down")) {
            Dimension dim = driver.manage().window().getSize();
            int width = dim.getWidth() / 2;
            for (int i = 0; i < times; i++) {
                int startY = (int) (dim.getHeight() * 0.7);
                int endY = (int) (dim.getHeight() * 0.5);
                new TouchAction(driver).press(point(width, startY)).waitAction(waitOptions(Duration.ofSeconds(1)))
                        .moveTo(point(width, endY)).release().perform();
            }
        }
    }
}
