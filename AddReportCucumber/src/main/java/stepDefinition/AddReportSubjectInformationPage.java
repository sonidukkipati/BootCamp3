package stepDefinition;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sc on 5/25/2017.
 */
public class AddReportSubjectInformationPage {

    WebDriver dr;
    Faker faker;
    public AddReportSubjectInformationPage(WebDriver dr){

        this.dr = dr;
        PageFactory.initElements(dr,this);
        faker= new Faker();
    }
    //String firstname = faker.name().firstName();
    //String lastname = faker.name().lastName();

    @FindBy(xpath= "//input[@name='lastName']")
    WebElement lastnameField;

    @FindBy(xpath="//input[@name='firstName']")
    WebElement firstnameField;

    @FindBy(xpath="//div[@title='Gang Membership']")
    WebElement distributionPage;

    public void setDistributionPage(){
        distributionPage.click();
    }

    public void inputLastname(String lastname){

        lastnameField.sendKeys(lastname);
    }

    public void inputFirstname(String firstname){
        firstnameField.sendKeys(firstname);
    }
}
