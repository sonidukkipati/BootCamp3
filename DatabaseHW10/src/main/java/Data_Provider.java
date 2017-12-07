/**
 * Created by sc on 5/19/2017.
 */
import org.testng.annotations.DataProvider;

import java.sql.*;
import java.util.ArrayList;

public class Data_Provider {

    @DataProvider(name = "ExcelDataProvider")
    public static Object[][] getData() throws Exception {

        String FilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\UserData.xls";
        String sheetName = "Sheet1";
        ReadData readData = new ReadData();
        Object[][] getData = readData.ReadExcelData(FilePath, sheetName);
        return getData;
    }
     @DataProvider(name = "giveBrowserPlatforms")
    public static Object[][]getplatforms() throws SQLException, ClassNotFoundException {

        ReadData readData1 = new ReadData();
        Object[][] getplatforms = readData1.giveBrowserstackPlatforms();
        return getplatforms;
    }
}


