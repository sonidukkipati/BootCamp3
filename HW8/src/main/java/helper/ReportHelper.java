package helper;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import testresources.PageResources;


/**
 * Created by sc on 2/23/2017.
 */
public class ReportHelper {
    WebDriver dr;
    PageResources pageResources;
    Faker faker;
    public ReportHelper(WebDriver dr, PageResources pageResources) {

        this.dr = dr;
        this.pageResources=pageResources;
        faker = new Faker();
    }

    public void Login(String username,String password) throws InterruptedException {
        dr.get("http://qabidder.net/testwave");
        Thread.sleep(5000);
        pageResources.getLoginPage().userNameField().sendKeys(username);
        pageResources.getLoginPage().passWordField().sendKeys(password);
        pageResources.getLoginPage().loginButton().click();
        Thread.sleep(5000);

    }

    public void CreateReports(int numberOfReportsToCreate, String username, String password) throws InterruptedException {

            dr.get("http://testwave.qabidder.net/#/page/login");
            Thread.sleep(5000);
            pageResources.getLoginPage().userNameField().sendKeys(username);
            pageResources.getLoginPage().passWordField().sendKeys(password);
            pageResources.getLoginPage().loginButton().click();
            Thread.sleep(5000);
            for (int i=1;i<numberOfReportsToCreate;i++) {
                pageResources.getNavBar().addReportButton().click();
                Thread.sleep(5000);
                pageResources.getAddReportEntity().entityNamelistByIndex(1).click();
                Thread.sleep(5000);
                pageResources.getAddReportEntity().subjectInformationPage().click();
                Thread.sleep(3000);
                pageResources.getAddReportSubjectInformation().lastNameField().click();
                Thread.sleep(5000);
                pageResources.getAddReportSubjectInformation().lastNameField().sendKeys(faker.name().lastName());
                Thread.sleep(5000);
                pageResources.getAddReportSubjectInformation().firstNameField().click();
                pageResources.getAddReportSubjectInformation().firstNameField().sendKeys(faker.name().firstName());
                Thread.sleep(5000);
                pageResources.getAddReportSubjectInformation().identifierPage().click();

                Thread.sleep(5000);
                pageResources.getAddReportIdentifiers().checkboxByIndex(0).click();
                pageResources.getAddReportIdentifiers().tatoos().sendKeys("tattoo on left ear");
                pageResources.getAddReportIdentifiers().idInformationPage().click();
                Thread.sleep(3000);
                pageResources.getAddReportIDInformation().socialSecurity().click();
                pageResources.getAddReportIDInformation().socialSecurity().sendKeys("124-46-6789");
                pageResources.getAddReportIDInformation().employerName().click();
                pageResources.getAddReportIDInformation().employerName().sendKeys(faker.company().name());
                Thread.sleep(5000);
                pageResources.getAddReportIDInformation().scrollToElement();
                Thread.sleep(5000);
                pageResources.getAddReportIDInformation().scrollUp();
                Thread.sleep(5000);
                //pageResources.getAddReportIDInformation().nextButton().click();
                pageResources.getAddReportIDInformation().stopInformationPage().click();
                Thread.sleep(5000);

                pageResources.getAddReportStopInformation().locationOfStop().click();
                pageResources.getAddReportStopInformation().locationOfStop().sendKeys(faker.address().city());
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
            }




        }


    public void CreateReports(int numberOfReportsToCreate) throws InterruptedException {

        dr.get("http://testwave.qabidder.net/#/page/login");
        Thread.sleep(5000);


        for (int i=1;i<numberOfReportsToCreate;i++) {
            pageResources.getNavBar().addReportButton().click();
            Thread.sleep(5000);
            pageResources.getAddReportEntity().entityNamelistByIndex(1).click();
            Thread.sleep(5000);
            pageResources.getAddReportEntity().subjectInformationPage().click();
            Thread.sleep(3000);
            pageResources.getAddReportSubjectInformation().lastNameField().click();
            Thread.sleep(5000);
            pageResources.getAddReportSubjectInformation().lastNameField().sendKeys(faker.name().lastName());
            Thread.sleep(5000);
            pageResources.getAddReportSubjectInformation().firstNameField().click();
            pageResources.getAddReportSubjectInformation().firstNameField().sendKeys(faker.name().firstName());
            Thread.sleep(5000);
            pageResources.getAddReportSubjectInformation().identifierPage().click();

            Thread.sleep(5000);
            pageResources.getAddReportIdentifiers().checkboxByIndex(0).click();
            pageResources.getAddReportIdentifiers().tatoos().sendKeys("tattoo on left ear");
            pageResources.getAddReportIdentifiers().idInformationPage().click();
            Thread.sleep(3000);
            pageResources.getAddReportIDInformation().socialSecurity().click();
            pageResources.getAddReportIDInformation().socialSecurity().sendKeys("124-46-6789");
            pageResources.getAddReportIDInformation().employerName().click();
            pageResources.getAddReportIDInformation().employerName().sendKeys(faker.company().name());
            Thread.sleep(5000);
            pageResources.getAddReportIDInformation().scrollToElement();
            Thread.sleep(5000);
            pageResources.getAddReportIDInformation().scrollUp();
            Thread.sleep(5000);
            //pageResources.getAddReportIDInformation().nextButton().click();
            pageResources.getAddReportIDInformation().stopInformationPage().click();
            Thread.sleep(5000);

            pageResources.getAddReportStopInformation().locationOfStop().click();
            pageResources.getAddReportStopInformation().locationOfStop().sendKeys(faker.address().city());
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
        }




    }



}

