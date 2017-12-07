package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by sc on 5/25/2017.
 */
public class AddReportDistributionPage {

    WebDriver dr;
    public AddReportDistributionPage(WebDriver dr){
        this.dr = dr;
    }

    @FindBy(xpath="//input[@name='Gang Membership']")
        WebElement distributionPage;

     @FindBy(xpath="//input[@name='locationOfStop']")
        WebElement stopLocationTextBox;


    public void stoplocationcity(){
        stopLocationTextBox.click();
        stopLocationTextBox.sendKeys("san jose");
    }
}
