package testcases.android.makemytrip;

import base.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import screens.android.nativeapp.makemytrip.BookingFlights;
import utils.ExcelReader;
import utils.TestUtils;

import java.util.HashMap;

public class BookingTickets extends TestBase {

    @BeforeTest
    public void init(){
        mmt = new BookingFlights(driver);
    }

    @Test(priority = 1)
    public void getServices(){
        mmt.getServices();
    }

    @Test(dataProvider="getData",priority = 2)
    public void searchFlights(HashMap<String,String> data){
        mmt.gotoFlights();
        mmt.selectFromCity(data.get("fromCity"));
        mmt.selectToCity(data.get("toCity"));
        mmt.selectMonth(data.get("month"));
    }

    @DataProvider
    public static Object[][] getData(){
        return TestUtils.getData("BookingTickets");
    }

}
