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

    public static void main(String[] args) throws IOException, InterruptedException {
        AppiumServer.stop();
        AppiumServer.start();

        CommonUtils.loadAndroidConfigProp("makemytrip.properties");
        CommonUtils.setAndroidCapabilities();

        driver = CommonUtils.getAndroidDriver();

        // go to the menu list - 1

        WebDriverWait wait = new WebDriverWait(driver,10);
        System.out.println(driver.findElement(By.id("com.makemytrip:id/tvIconText")).getText());

       // get all services - 2
         WebElement services = driver.findElement(By.id("com.makemytrip:id/llIconLayoutMain1"));
          List<WebElement> items = services.findElements(By.id("com.makemytrip:id/tvIconText"));

        for (WebElement service : items) {
            System.out.println(service.getText());
        }

        // click on flights -3
        items.get(0).click();
        driver.findElement(By.id("com.makemyrip:id/from_code")).click();
        driver.hideKeyboard();

        // Selecting from city - 4
        WebElement list = driver.findElement(By.id("com.makemytrip:id/toFromList"));
        List<WebElement> city = list.findElements(By.id("enterCityText"));

        for (int i = 0; i < city.size(); i++) {
            if (city.get(i).getText().startsWith("Dubai")){
                city.get(i).click();
                break;
            }
        }

        // Selecting to city - 5
        driver.findElement(By.id("com.makemyrip:id/to_code")).click();
        driver.hideKeyboard();

        list = driver.findElement(By.className("android.widget.ScrollView"));
        city = list.findElements(By.id("enterCityText"));

        for (int i = 0; i < city.size(); i++) {
            if (city.get(i).getText().startsWith("Mumbai")){
                city.get(i).click();
                break;
            }
        }

        // Selecting departure month - 6
        driver.findElement(By.id("departureDate")).click();

        int i = 1;
        while (!driver.findElement(By.id("com.makemytrip:id/title")).getText().contains("Dec")){

            driver.findElement(By.id("com.makemytrip:id/calViewNextMonth")).click();
            if (driver.findElement(By.id("com.makemytrip:id/title")).getText().contains("Dec")){
                System.out.println("Month reached");
                break;
            }
            i++;
        }

        // Selecting from date in a calender - 7

        List<WebElement> date = driver.findElements(By.id("com.makemytrip:id/date"));
        for (int x = 0; x < date.size(); x++) {
            if (date.get(x).getText().equals("13")){
                date.get(x).click();
                break;
            }
        }

        // Selecting to date in a calender - 8

        date = driver.findElements(By.id("com.makemytrip:id/date"));
        for (int x = 0; x < date.size(); x++) {
            if (date.get(x).getText().equals("17")){
                date.get(x).click();
                break;
            }
        }


        // Adult_counter - 9
        int adult_counter = Integer.parseInt(driver.findElement(By.id("android.widget.TextView")).getText());

        System.out.println(adult_counter);

        // logic for number of adults - 10
        for (int a = 2; a < adult_counter + 3; a++) {
            driver.findElement(By.id("addAdultButton")).click();
        }

        // logic for number of children - 11
        for (int a = 2; a < adult_counter + 3; a++) {
            driver.findElement(By.id("addChildButton")).click();
        }

        // logic for number of infants - 12
        for (int a = 2; a < adult_counter + 3; a++) {
            driver.findElement(By.id("addInfantButton")).click();
        }

        driver.findElement(By.name("Economy")).click();

        driver.findElement(By.id("doneButtonTraveller")).click();

        driver.findElement(By.id("searchFlight")).click();


        driver.quit();
       AppiumServer.stop();

    }
}
