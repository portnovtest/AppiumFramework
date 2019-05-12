package screens.android.nativeapp.makemytrip;

import base.Constants;
import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingFlights extends ScreenBase {

    @AndroidFindBy(id = Constants.HOME_SIDE_MENU)
    public WebElement home_side_menu;

    // to find an element w/in an element
    @AndroidFindBys({
            @AndroidBy(id = Constants.LAYOUT),
            @AndroidBy(id = Constants.MENU_ITEM)
    })
    public List<WebElement> menuItems;

    @AndroidFindBy(id = Constants.FROM_CITY)
    public WebElement fromCal;


    @AndroidFindBys({
            @AndroidBy(id = Constants.TO_FRO_CITY_LIST),
            @AndroidBy(id = Constants.CITY_NAME)
    })
    public List<WebElement> cityName;

    @AndroidFindBy(id = Constants.TO_CITY)
    public WebElement toCal;

    @AndroidFindBy(id = Constants.FROM_CITY)
    public WebElement fromDay;

    @AndroidFindBy(id = Constants.CAL_TITLE)
    public WebElement calTitle;

    @AndroidFindBy(id = Constants.NEXT_MONTH)
    public WebElement nextMonth;

    public BookingFlights(AppiumDriver driver) {
        super(driver);
    }

    public void getServices(){
        // go to the menu list - 1
        waitForElement(10, Constants.HOME_SIDE_MENU);
       home_side_menu.click();

        // get all services - 2


        for (WebElement service : menuItems) {
            System.out.println(service.getText());
        }
    }

    public void gotoFlights(){
        menuItems.get(0).click();
    }

    public void selectFromCity(String fromCity){
        fromCal.click();
        hideKeyboard();

        for (int i = 0; i < cityName.size(); i++) {
            if (cityName.get(i).getText().startsWith(fromCity)){
                cityName.get(i).click();
                break;
            }
        }
    }

    public void selectToCity(String toCity){
        fromCal.click();
        hideKeyboard();

        for (int i = 0; i < cityName.size(); i++) {
            if (cityName.get(i).getText().startsWith(toCity)){
                cityName.get(i).click();
                break;
            }
        }
    }

    public void selectMonth(String month){
        fromDay.click();

        while (!calTitle.getText().contains(month)) {

            nextMonth.click();
            if (calTitle.getText().contains(month)) {
                System.out.println("Month reached");
                break;
            }
        }
    }
}
