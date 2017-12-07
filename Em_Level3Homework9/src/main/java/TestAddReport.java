import TestResources.PageResources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import org.openqa.selenium.remote.Augmenter;


public class TestAddReport {
    private WebDriver driver;
    private PageResources pageResources;
    private TakeScreenShot takeScreenShot;




    public static final String USERNAME = "emmafoster2";
    public static final String AUTOMATE_KEY = "x8spXdgFcxLwMYybhgSb";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public String randomString() {
        return new BigInteger(16, new SecureRandom()).toString(16);
    }


    @BeforeClass
    @org.testng.annotations.Parameters(value={"browser","version","os", "osVersion"})
    public void setDriver(String browser, String version, String os, String osVersion) throws Exception {

      //System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver-v0.15.0-win64\\geckodriver.exe");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browser);
        caps.setCapability("browser_version", version);
        caps.setCapability("os", os);

        caps.setCapability("os_version", osVersion);
        caps.setCapability("browserstack.debug", "true");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
       driver.get("http://qabidder.net/testwave/#/page/login");
        Thread.sleep(8000);
        driver = (RemoteWebDriver) new Augmenter().augment(driver);
        File srcFile = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\HW9_ScreenShots\\"+ "ScreenShot"+randomString()+".png"));
//        takeScreenShot.takeScreenshot(driver,"ScreenShot"+generateRandomNameString());
        Thread.sleep(8000);
        pageResources = new PageResources(driver);
        pageResources.getLoginPage().loginToWave("qaubertester@mailinator.com", "qaubertester");
        driver = (RemoteWebDriver) new Augmenter().augment(driver);
        File srcFile2 = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile2, new File("C:\\HW9_ScreenShots\\"+ "ScreenShot"+randomString()+".png"));
        Thread.sleep(8000);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test(dataProvider = "reportData", dataProviderClass = Data_Provider.class)
    public void addReport(String strEntity, String strFirstName, String strLastName, String strLocation) throws InterruptedException,IOException
    { pageResources.getAddReport().clickAddReportlink();
        Thread.sleep(4000);
        pageResources.getAddReport().clickEntity(strEntity);
        Thread.sleep(5000);
        pageResources.getAddReport().SubjectInfoPage();
        Thread.sleep(8000);


        pageResources.getAddReport().setFirstName(strFirstName);
        Thread.sleep(3000);
        pageResources.getAddReport().setLastName(strLastName);
        Thread.sleep(3000);
        pageResources.getAddReport().clickGangmemberPage();

        driver = (RemoteWebDriver) new Augmenter().augment(driver);
        File srcFile4 = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile4, new File("C:\\HW9_ScreenShots\\"+ "ScreenShot"+randomString()+".png"));


        Thread.sleep(8000);
        pageResources.getAddReport().setLocationOfStop(strLocation);
        Thread.sleep(3000);
        pageResources.getAddReport().clickPreviewReport();
        driver = (RemoteWebDriver) new Augmenter().augment(driver);
        File srcFile5 = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile5, new File("C:\\HW9_ScreenShots\\"+ "ScreenShot"+randomString()+".png"));
        Thread.sleep(8000);
        String expectedExportID=driver.findElement((By.xpath("//div[@class='col-sm-4 form-group'][./span='Report ID']//div[@class='text-bold ng-binding']"))).getText();
        Thread.sleep(3000);
        String actualLocation=driver.findElement((By.xpath("//div[@class='col-sm-12 form-group'][./span='Location of Stop']//div[@class='text-bold ng-binding']"))).getText();
        Thread.sleep(3000);
        pageResources.getAddReport().clickPublishReport();
        Thread.sleep(8000);
        driver.findElement(By.cssSelector(".btn-success")).click();
        Thread.sleep(3000);
        String reportName= driver.findElement(By.xpath("//div [@class='col-lg-12']/h4[@class='ng-binding']")).getText();
        Boolean reportID=reportName.contains(expectedExportID);
        Boolean firstName=reportName.contains(strFirstName);
        Boolean lastName=reportName.contains(strLastName);
        try {
            Assert.assertTrue(reportID);
            System.out.println("Preview Page: Report ID = " + expectedExportID);
            System.out.println("Report List: Report Name = " + reportName);
            System.out.println("\n");
            Assert.assertTrue(firstName);
            System.out.println("First Name From Data Provider= " + strFirstName);
            System.out.println("Report List: Report Name = " + reportName);
            System.out.println("\n");
            Assert.assertTrue(lastName);
            System.out.println("Last Name From Data Provider = " + strLastName);
            System.out.println("Report List: Report Name = " + reportName);
            System.out.println("\n");
            Assert.assertEquals(strLocation,actualLocation);
            System.out.println("Location From Data Provider= " + strLocation);
            System.out.println("Actual Location on Preview Page = " + actualLocation);
            System.out.println("############################################################################");

        }
        catch (Throwable t) {
            Assert.fail("expected and actual result do not match");
        }

    }
    @AfterClass
    public void driverQuit()
    {driver.close();

    }


}
