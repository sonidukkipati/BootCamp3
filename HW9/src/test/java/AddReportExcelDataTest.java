import com.github.javafaker.Faker;
import helper.Data_Provider;
import helper.ReportHelper;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Users;
import testresources.PageResources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;

import static org.testng.reporters.jq.BasePanel.C;

/**
 * Created by sc on 5/16/2017.
 */
public class AddReportExcelDataTest {
    WebDriver dr;
    LoginPage loginPage;
    Faker faker = new Faker();
    PageResources pageResources;
    ReportHelper reportHelper;






    @Test(dataProviderClass = Data_Provider.class, dataProvider = "ExcelDataProvider")
    public void ReadDataExcelReport(String lastname, String firstname, String companyname, String cityname) throws BiffException, InterruptedException {


        dr.get("http://qabidder.net/testwave");
        Thread.sleep(5000);

        loginPage.userNameField().sendKeys("sinduchalasani789@gmail.com");
        loginPage.passWordField().sendKeys("sindu.789");
        Thread.sleep(5000);
        loginPage.loginButton().click();
        Thread.sleep(12000);
        pageResources.getNavBar().addReportButton().click();
        Thread.sleep(6000);
        // Selecting Entity Name-- By selecting the radio button
        pageResources.getAddReportEntity().entityNamelistByIndex(1).click();
        Thread.sleep(5000);
        pageResources.getAddReportEntity().subjectInformationPage().click();
        Thread.sleep(3000);
        // In the Subject Information, enter Last name and Firstname fields.--- Text Boxes(fields)
        pageResources.getAddReportSubjectInformation().lastNameField().click();
        //String last_name = faker.name().lastName();
        pageResources.getAddReportSubjectInformation().lastNameField().sendKeys(lastname);
        Thread.sleep(3000);
        pageResources.getAddReportSubjectInformation().firstNameField().click();
        pageResources.getAddReportSubjectInformation().firstNameField().sendKeys(firstname);

        // Click on Identifier Page: Check the check box
        Thread.sleep(5000);
        pageResources.getAddReportSubjectInformation().identifierPage().click();

        Thread.sleep(2000);
        pageResources.getAddReportIdentifiers().checkboxByIndex(0).click();
        pageResources.getAddReportIdentifiers().tatoos().sendKeys("tatoo");
        // ID Information Page
        pageResources.getAddReportIdentifiers().idInformationPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().socialSecurity().click();
        pageResources.getAddReportIDInformation().socialSecurity().sendKeys("324-123-8790");
        pageResources.getAddReportIDInformation().employerName().click();
        pageResources.getAddReportIDInformation().employerName().sendKeys(companyname);
        //Selecting from Drop Down
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().employerstate().selectByVisibleText("Texas");
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().scrollToElement();
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().scrollUp();
        Thread.sleep(5000);
        //pageResources.getAddReportIDInformation().nextButton().click();
        pageResources.getAddReportIDInformation().stopInformationPage().click();
        Thread.sleep(5000);

        pageResources.getAddReportStopInformation().locationOfStop().click();
        pageResources.getAddReportStopInformation().locationOfStop().sendKeys(cityname);
        Thread.sleep(3000);
        pageResources.getAddReportStopInformation().vehiclePage().click();
        Thread.sleep(5000);
        pageResources.getAddReportVehicle().vehicleLicense().sendKeys("ER$%^FGTVBN");
        pageResources.getAddReportVehicle().photosPage().click();
        Thread.sleep(5000);
        pageResources.getAddReportPhotos().previewPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportCommit().reportCommit().click();
        Thread.sleep(5000);
        WebElement el = dr.findElement(By.xpath("//button[@ng-click='confirm()']"));
        el.click();
        Thread.sleep(5000);
        dr.findElement(By.xpath("//div[@class='checkbox c-checkbox mt0 mb0 p0']/label")).click();
        Thread.sleep(5000);
        // pageResources.getReports().viewButtonByIndex(0).click();
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().scrollDown();
        WebElement v1 = dr.findElement(By.xpath("//a[@title='View'][1]"));
        v1.click();
        Thread.sleep(10000);
        pageResources.getAddReportIDInformation().scrollDown();

        String report = dr.findElement(By.tagName("body")).getText();

        Boolean checkStatus = false;

        if (report.contains(lastname))
            checkStatus = true;
        try {
            Assert.assertTrue(checkStatus == true);
            System.out.println("Found " + lastname + " in the View report text");


        } catch (Throwable t) {
            Assert.fail("Could not find " + lastname + " in the View report text");


        }


    }
    public String randomString() {
        return new BigInteger(16, new SecureRandom()).toString(16);
    }

    public static final String USERNAME = "sonichalasani1";
    public static final String AUTOMATE_KEY = "f6sqpETfKNw8woBnEKQY";
    public static final String URL1 = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";



    @org.testng.annotations.Parameters(value = {"browser", "version", "os", "osVersion"})
    @BeforeClass
    public void setupDriver(String browser,String version,String os,String os_version) throws InterruptedException, IOException {
        dr = new ChromeDriver();
        Thread.sleep(4000);
        // dr.manage().window().maximize();
        loginPage = new LoginPage(dr);
        pageResources = new PageResources(dr);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser",browser);
        caps.setCapability("browser_version", version);
        caps.setCapability("os", os);
        caps.setCapability("os_version",os_version);
        caps.setCapability("browserstack.debug", "true");

        WebDriver dr = new RemoteWebDriver(new URL(URL1), caps);
        dr.get("http://qabidder.net/testwave/#/page/login");
        Thread.sleep(8000);
        dr = (RemoteWebDriver) new Augmenter().augment(dr);
        File srcFile = (File) ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\HW9_ScreenShots\\"+ "ScreenShot"+randomString()+".png"));
//        takeScreenShot.takeScreenshot(driver,"ScreenShot"+generateRandomNameString());
        Thread.sleep(8000);
        pageResources = new PageResources(dr);
        pageResources.getLoginPage().userNameField().sendKeys("tester@mailinator.com");
        pageResources.getLoginPage().passWordField().sendKeys("tester");
        //loginToWave("qaubertester@mailinator.com", "qaubertester");
        dr = (RemoteWebDriver) new Augmenter().augment(dr);
        File srcFile2 = (File) ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile2, new File("C:\\HW9_ScreenShots\\"+ "ScreenShot"+randomString()+".png"));
        Thread.sleep(8000);



    }

    @AfterClass
    public void breakDown() {
        dr.close();
        dr.quit();
    }

}