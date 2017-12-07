package Level3Homework8;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import samplecode.Data_Provider;
import testresources.PageResources;

/**
 * Created by sc on 5/12/2017.
 */
public class AddReportDataProviderRandom {

    LoginPage loginPage;
    WebDriver dr;
    PageResources pageResources;
    Faker faker = new Faker();

    @Test(dataProviderClass = Data_Provider.class,dataProvider= "sampleDataProvider")
    public void TestRandom(String lastname,String firstname,String tatoo,String ssn ,String companyname ,String cityname) throws InterruptedException {
        // WebDriver dr=new ChromeDriver();
        // dr.manage().window().maximize();
        // LoginPage loginPage = new LoginPage(dr);

        dr.get("http://qabidder.net/testwave");
        Thread.sleep(5000);

        loginPage.userNameField().sendKeys("sinduchalasani789@gmail.com");
        loginPage.passWordField().sendKeys("sindu.789");
        Thread.sleep(5000);
        loginPage.loginButton().click();
        Thread.sleep(10000);
        pageResources.getNavBar().addReportButton().click();
        Thread.sleep(5000);
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
        pageResources.getAddReportIdentifiers().tatoos().sendKeys(tatoo);
        // ID Information Page
        pageResources.getAddReportIdentifiers().idInformationPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportIDInformation().socialSecurity().click();
        pageResources.getAddReportIDInformation().socialSecurity().sendKeys(ssn);
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

        String report= dr.findElement(By.tagName("body")).getText();

        Boolean checkStatus= false;

        if (report.contains(lastname))
            checkStatus= true;
        try {
            Assert.assertTrue(checkStatus == true);
            System.out.println("Found " + lastname + " in the View report text");


        } catch (Throwable t) {
            Assert.fail("Could not find " + lastname + " in the View report text");


        }

        if (report.contains("Texas"))
            checkStatus= true;
        try {
            Assert.assertTrue(checkStatus == true);
            System.out.println("Found " + "Texas" + " in the View report text");


        } catch (Throwable t) {
            Assert.fail("Could not find " + "Texas" + " in the View report text");


        }
        if (report.contains("tattoo on left ear"))
            checkStatus= true;
        try {
            Assert.assertTrue(checkStatus == true);
            System.out.println("Found " + "tattoo on left ear" + " in the View report text");


        } catch (Throwable t) {
            Assert.fail("Could not find " + "tattoo on left ear" + " in the View report text");


        }









    }
    @BeforeClass
    public void setup() throws InterruptedException {
        dr=new ChromeDriver();
        Thread.sleep(4000);
        // dr.manage().window().maximize();
        loginPage = new LoginPage(dr);
        pageResources = new PageResources(dr);

    }
    @AfterClass
    public void breakDown(){
        dr.close();
        dr.quit();

    }
}




