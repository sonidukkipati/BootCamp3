package pagestest;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import testresources.PageResources;

import java.util.List;

import static com.sun.javafx.applet.ExperimentalExtensions.get;
import static java.sql.DriverManager.getDriver;

/**
 * Created by sc on 2/20/2017.
 */
/*
   Preconditions:

 */
public class AddReportTest {
    WebDriver dr;
    PageResources pageResources;
    Faker faker = new Faker();
    Boolean checkvalidity = true;

    @BeforeClass
    public void setup() throws InterruptedException {

        dr = new ChromeDriver();
        Thread.sleep(3000);
        //dr.manage().window().maximize();
        pageResources = new PageResources(dr);
        //dr.get("http://fits.qauber.com/#/page/login");

    }

    @Test(enabled = true)
    public void reportaddtest() throws InterruptedException {
        dr.get("http://fits.qauber.com/#/page/login");
        Thread.sleep(6000);
        pageResources.getLoginPage().userNameField().sendKeys(pageResources.getLoginPage().getUsername());
        pageResources.getLoginPage().passWordField().sendKeys(pageResources.getLoginPage().getPassword());
        pageResources.getLoginPage().loginButton().click();
        Thread.sleep(5000);
        pageResources.getNavBar().addReportButton().click();
        Thread.sleep(5000);
        pageResources.getAddReportEntity().entityNamelistByIndex(0).click();
        Thread.sleep(5000);
        pageResources.getAddReportEntity().subjectInformationPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportSubjectInformation().lastNameField().click();
        Thread.sleep(5000);
        String Lastname = faker.name().lastName();
        pageResources.getAddReportSubjectInformation().lastNameField().sendKeys(Lastname);
        Thread.sleep(3000);
        pageResources.getAddReportSubjectInformation().firstNameField().click();
        String Firstname = faker.name().firstName();
        pageResources.getAddReportSubjectInformation().firstNameField().sendKeys(Firstname);
    /*pageResources.getAddReportSubjectInformation().hairColor().selectByVisibleText("Unknown");
    Thread.sleep(3000);
    pageResources.getAddReportSubjectInformation().eyeColor().selectByVisibleText("Unknown");*/
        Thread.sleep(5000);
        pageResources.getAddReportSubjectInformation().identifierPage().click();

        Thread.sleep(5000);
        pageResources.getAddReportIdentifiers().checkboxByIndex(0).click();
        pageResources.getAddReportIdentifiers().tatoos().sendKeys("tattoo on left ear");
        pageResources.getAddReportIdentifiers().idInformationPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().socialSecurity().click();
        pageResources.getAddReportIDInformation().socialSecurity().sendKeys("124-46-6789");
        pageResources.getAddReportIDInformation().scrollDownToo();
        pageResources.getAddReportIDInformation().employerName().click();
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().employerName().sendKeys("BLADE");
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().scrollToElement();
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().scrollUp();
        Thread.sleep(5000);
        //pageResources.getAddReportIDInformation().nextButton().click();
        pageResources.getAddReportIDInformation().stopInformationPage().click();
        Thread.sleep(5000);

        pageResources.getAddReportStopInformation().locationOfStop().click();
        String Stopcity = faker.address().city();
        pageResources.getAddReportStopInformation().locationOfStop().sendKeys(Stopcity);
        Thread.sleep(3000);
        pageResources.getAddReportStopInformation().vehiclePage().click();
        Thread.sleep(5000);

        pageResources.getAddReportVehicle().vehicleLicense().sendKeys("ER$%^FGTVBN");
        pageResources.getAddReportVehicle().photosPage().click();
        Thread.sleep(5000);
        pageResources.getAddReportPhotos().previewPage().click();
        Thread.sleep(5000);
        WebElement lastElement =
                dr.findElement(By.xpath("//button[@ng-click='wizard.commitReport()']"));
        int y = lastElement.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("window.scrollTo(0," + y + ")");
        Thread.sleep(3000);
        pageResources.getAddReportCommit().reportCommit().click();
        Thread.sleep(5000);
        System.out.println("Verify if Report is created");
        //String lastname =
        //String firstname =
        dr.findElement(By.xpath("//div[@class='checkbox c-checkbox mt0 mb0 p0']/label")).click();
        Thread.sleep(5000);
        List<WebElement> l1 = dr.findElements(By.xpath("//h4[@class='ng-binding']"));

        String displayed_report = l1.get(1).getText();
        System.out.println("This is displayed in Application" + displayed_report);
        String[] reportID = displayed_report.split(" ");
        System.out.println(reportID[0]);
        System.out.println(reportID[1]);
        String report_ID = reportID[0];
        String firstname = reportID[1];
        String lastname = reportID[2];



        // pageResources.getReports().viewButtonByIndex(0).click();
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().scrollDown();
        WebElement v1 = dr.findElement(By.xpath("//a[@title='View'][1]"));
        v1.click();
        Thread.sleep(10000);
        //pageResources.getAddReportIDInformation().scrollDown();

        String report = dr.findElement(By.xpath("//div[@id='reportBody']")).getText();

        Boolean checkStatus = false;

        if (report.contains(firstname))
            checkStatus = true;
        try {
            Assert.assertTrue(checkStatus == true);
            System.out.println("Found " + firstname + " in the View report text");


        } catch (Throwable t) {
            Assert.fail("Could not find " + firstname + " in the View report text");


        }
        if (report.contains(lastname))
            checkStatus = true;
        try {
            Assert.assertTrue(checkStatus == true);
            System.out.println("Found " + lastname + " in the View report text");


        } catch (Throwable t) {
            Assert.fail("Could not find " + lastname + " in the View report text");


        }
        if (report.contains(report_ID))
            checkStatus = true;
        try {
            Assert.assertTrue(checkStatus == true);
            System.out.println("Found " + report_ID+ " in the View report text");


        } catch (Throwable t) {
            Assert.fail("Could not find " + report_ID + " in the View report text");


        }
    }

        @AfterClass
        public void breakDown () {
            dr.close();
            dr.quit();

        }

    }


