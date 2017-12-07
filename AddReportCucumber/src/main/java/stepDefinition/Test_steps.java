package stepDefinition;

import com.github.javafaker.Faker;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import pages.*;
import testresources.PageResources;
/**
 * Created by sc on 6/6/2017.
 */
public class Test_steps {


    WebDriver dr;
    NavigationBarPage navigationBarPage;
    AddReportPage addReportPage;
    LoginPage loginPage;
    PageResources pageResources;
    Faker faker;
    AddReportSubjectInformationPage addReportSubjectInformationPage;
    Profile profile;

    @Before
    public void setupdriver() {
        dr = new ChromeDriver();
        loginPage = new LoginPage(dr);
        navigationBarPage = new NavigationBarPage(dr);
        addReportPage = new AddReportPage(dr);
        pageResources = new PageResources(dr);
        profile = new Profile(dr);
        faker = new Faker();

        addReportSubjectInformationPage = new AddReportSubjectInformationPage(dr);
    }

    @Given("^User logs into the application with valid credentials\\.$")
    public void user_logs_into_the_application_with_valid_credentials() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //LoginPage loginPage = new LoginPage(dr);
        // WebDriver dr = new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dr.get("http://qabidder.net/testwave/#/page/login");
        Thread.sleep(5000);
        loginPage.typeUsername();
        Thread.sleep(3000);

        loginPage.typePassword();

        loginPage.loginButtonClick();
        Thread.sleep(4000);


    }

    @When("^User clicks on Add Repots Tab and adds Report and publishes it\\.$")
    public void user_clicks_on_Add_Repots_Tab_and_adds_Report_and_publishes_it() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // Adding the Report
        //Click Add Reports link on Navigation page
        navigationBarPage.AddReportButton.click();
        //select the entity
        addReportPage.entityNamelistByIndex(1).click();

        //addReportPage.selectEntity("Gibson-Gibson");

        addReportPage.setSubjectInformationfield();

        Thread.sleep(3000);
        String lastname = faker.name().lastName();
        String firstname = faker.name().firstName();
        addReportSubjectInformationPage.inputLastname(lastname);
        addReportSubjectInformationPage.inputFirstname(firstname);

        addReportSubjectInformationPage.setDistributionPage();
        Thread.sleep(3000);
        pageResources.getAddReportStopInformation().locationOfStop().click();
        pageResources.getAddReportStopInformation().locationOfStop().sendKeys("san Jose");
        Thread.sleep(3000);
        Thread.sleep(3000);
        pageResources.getAddReportStopInformation().vehiclePage().click();
        Thread.sleep(3000);
        pageResources.getAddReportVehicle().vehicleLicense().sendKeys("ER$%^FGTVBN");
        pageResources.getAddReportVehicle().photosPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportPhotos().previewPage().click();
        Thread.sleep(3000);
        pageResources.getAddReportCommit().reportCommit().click();
        Thread.sleep(5000);
        WebElement el = dr.findElement(By.xpath("//button[text()='YES']"));
        //WebElement el =driver.findElement(By.cssSelector(".btn-success"));
        el.click();
        Thread.sleep(7000);
       /* dr.findElement(By.xpath("//div[@class='checkbox c-checkbox mt0 mb0 p0']/label")).click();
        Thread.sleep(5000);
        // pageResources.getReports().viewButtonByIndex(0).click();
        Thread.sleep(5000);
        pageResources.getAddReportIDInformation().scrollDown();
        WebElement v1 = dr.findElement(By.xpath("//a[@title='View'][1]"));
        v1.click();
        Thread.sleep(10000); */
        //pageResources.getAddReportIDInformation().scrollDown();


    }

    @Then("^Verify if Report created with required fields\\.$")
    public void verify_if_Report_created_with_required_fields() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
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

        String report = dr.findElement(By.tagName("body")).getText();

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
    @After
    public void Close(){
        dr.close();
        dr.quit();
    }

   /* @Given("^User clicks on Logout$")
    public void Logout() throws InterruptedException {
        profile.CaretDownLink().click();
        Thread.sleep(4000);
        profile.LogoutButton().click();
        Thread.sleep(3000);

    }

    @Then("^Verify user is logged out of application$")
    public void VerifyLogout() {
        String text = dr.findElement(By.xpath("//button[@text='Login']")).getText();
        if (text.contains("Login")) {
            dr.close();
            dr.quit();
        }*/
    }
