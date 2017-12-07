package samplecode;

/**
 * Created by sc on 3/15/2017.
 */

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;


//Parameterizing a test
//Executing a test with multiple sets of Data

public class LoginTest {


    @AfterMethod
    public void aftermethod(){

        System.out.println("XXXXX");
    }

    @Test(dataProviderClass = Data_Provider.class,dataProvider= "LoginTestDataProvider") //It is a testcase //2nd
    public void doLoginTest(//3rd
                            String username,
                            String password,
                            String result,
                            String Browser,
                            int phone){
        System.out.println(username);
        System.out.println(phone);




    }
    @DataProvider(parallel=true)  //for parameterizing the test with different input parameters
    public Object[][] getData(){
        Object[][] data = new Object[3][5] ; //1st

        //1st row
        data[0][0] = "U1";
        data[0][1] = "P1";
        data[0][2] = "Pass";
        data[0][3]  = "Mozilla";
        data[0][4] = 12345;


        //2nd row
        data[1][0] = "U2";
        data[1][1] = "P2";
        data[1][2] = "Pass";
        data[1][3]  = "Mozilla";
        data[1][4]  = 3456;

        //3rd row
        data[2][0] = "U3";
        data[2][1] = "P3";
        data[2][2] = "Fail";
        data[2][3]  = "Mozilla";
        data[2][4]  = 6789;

        return data;


    }

}


