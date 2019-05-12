package utils;

import base.TestBase;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class TestUtils extends TestBase {

    @DataProvider
    public static Object[][] getData(String sheetName){

        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows-1][1];

        HashMap<String,String> table = null;

        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            table = new HashMap<>();
            for (int colNum = 0; colNum < cols; colNum++) {
                table.put(excel.getCellData(sheetName,colNum,1),excel.getCellData(sheetName,colNum,rowNum));
                data[rowNum-2][0] = table;
            }
        }

        return data;
    }
}
