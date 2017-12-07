/**
 * Created by sc on 3/15/2017.
 */

import com.github.javafaker.Faker;
import helper.ReadData;
import org.testng.annotations.DataProvider;

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

