package helper;

/**
 * Created by sc on 3/15/2017.
 */

import com.github.javafaker.Faker;
import jxl.Sheet;
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

public class Data_Provider {

    Faker faker;
    @DataProvider(name = "ExcelDataProvider")
    public static Object[][] ReadDataExcel() throws Exception {
        String FilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\UserData.xls";
        String sheetName =  "Sheet1" ;
        ReadData readData = new ReadData();
        Object[][] ReadDataExcel = readData.ReadExcelData(FilePath,sheetName);


        return ReadDataExcel;

    }



}

