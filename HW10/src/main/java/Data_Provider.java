/**
 * Created by sc on 5/19/2017.
 */
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import testresources.PageResources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.*;

public class Data_Provider {

    @DataProvider(name = "ExcelDataProvider")
    public static Object[][] getData() throws Exception {

        String FilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\UserData.xls";
        String sheetName =  "Sheet1" ;
        ReadData readData = new ReadData();
        Object[][] getData = readData.ReadExcelData(FilePath,sheetName);
        return getData;
    }
    @DataProvider(name="givePlatformandBrowsers")
    public static Object[][] giveBrowserstackPlatforms() throws ClassNotFoundException, SQLException {
        Object[][] giveBrowserstackPlatforms = new Object[1][3];

        giveBrowserstackPlatforms[0][0] = "chrome";
        giveBrowserstackPlatforms[0][1] ="58.0.3029.110";
        giveBrowserstackPlatforms[0][2] ="Windows";
       // giveBrowserstackPlatforms[0][3] = "10";

        return giveBrowserstackPlatforms;

    }
}
