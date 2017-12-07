package samplecode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by sc on 4/6/2017.
 */
public class Test1 {

    Division division = new Division();

  @Test()
    public void dividing(){

      int k = division.divide(5,2);
      System.out.println(k);

  }

}
