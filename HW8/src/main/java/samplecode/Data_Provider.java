package samplecode;

/**
 * Created by sc on 3/15/2017.
 */

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

import static org.apache.commons.lang3.RandomStringUtils.*;

public class Data_Provider {

    Faker faker;


    @DataProvider(name = "LoginTestDataProvider")

    public static Object[][] getData(){
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

    @DataProvider(name = "DoLoginTestDataProvider")

    public static Object[][] getRData(){
        Object[][] data = new Object[1][2] ; //1st

        //1st row
        data[0][0] = "U7";
        data[0][1] = "P7";




        return data;


    }
    @DataProvider(name = "Login_TestDataProvider")

    public static Object[][] getlogData(){
        Object[][] data = new Object[1][2];
        data[0][0]= "sinduchalasani789@gmail.com";
        data[0][1]= "sindu.789";
        return data;
    }
    @DataProvider(name = "sampleDataProvider")

    public static Object[][] getSData(Method m){
        Faker faker = new Faker();
        RandomStringUtils randomStringUtils = new RandomStringUtils();

        Object[][] data = null ; //1st


        if (m.getName().equals("testA")){

            data = new Object[2][3] ; //1st

            //1st row
            data[0][0] = "U12";
            data[0][1] = "P12";
            data[0][2] = 123;

            //2nd  row
            data[1][0] = "U13";
            data[1][1] = "P13";
            data[1][2] = 234;



        }
        else if (m.getName().equals("testB") )
        {
            data = new Object[2][4] ;
            //1st row
            data[0][0] = "U14";
            data[0][1] = "P14";
            data[0][2] = 123;
            data[0][3] = "g@gmail.com";

            //2nd  row
            data[1][0] = "U15";
            data[1][1] = "P15";
            data[1][2] = 234;
            data[1][3] = "c@gmail.com";
        }

        else if (m.getName().equals("TestRandom")){
            String lastname = RandomStringUtils.randomAlphabetic(5).toLowerCase();
            String firstname = RandomStringUtils.randomAlphabetic(4).toLowerCase();
            String ssn = RandomStringUtils.randomNumeric(9);
            String company_name= RandomStringUtils.randomAlphabetic(7).toLowerCase();
            String city =  RandomStringUtils.randomAlphabetic(7).toLowerCase();

            data = new Object[1][6];
            data[0][0] = lastname;
            data[0][1] = firstname;
            data[0][2] = "Tatoos in Right Ear";
            data[0][3] = ssn;
            data[0][4] = company_name;
            data[0][5] = city;
        }




        else if (m.getName().contains("TestR")){


            data = new Object[1][6];

            data[0][0] = "Marty";
            data[0][1] = "Sam";
            data[0][2] = "Tatoos on Left Ear";
            data[0][3] = "245-126-7658";
            data[0][4] = "BLADE";
            data[0][5] = "San Jose";
        }



        return data;


    }



}

