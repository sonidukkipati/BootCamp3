package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sc on 5/25/2017.
 */
public class NavigationBarPage {

    WebDriver dr;

    public NavigationBarPage(WebDriver dr){
        this.dr=dr;
        PageFactory.initElements(dr,this);

    }
    @FindBy(xpath="//span[contains(text(),'Add Report')]")
    WebElement AddReportButton;
    @FindBy(xpath="//a[@title='Users']")
    WebElement UserButton;
    @FindBy(xpath="//a[@title='Entities']")
    WebElement EntityButton;
    @FindBy(xpath="//a[@title='Reports']")
    WebElement ReportsButton;


    public void reportLink(){
        ReportsButton.click();
    }
    public void addReportLink(){
        AddReportButton.click();
    }
    public void addEntityLink(){
        EntityButton.click();
    }


}
