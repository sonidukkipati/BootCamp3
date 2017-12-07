package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by sc on 5/24/2017.
 */
public class AddReportPage
{

    WebDriver dr;
    public AddReportPage(WebDriver dr){
        this.dr = dr;
        PageFactory.initElements(dr,this);

    }

    public List<WebElement> entityNameList(){

        return dr.findElements(By.xpath("//input[@ng-model='wizard.report.key']"));

    }

    public WebElement entityNamelistByIndex(int rowIndex){

        return entityNameList().get(rowIndex);

    }

    @FindBy (xpath="//div[@ title='Subject Information']")
    WebElement subjectInformationfield;

    public void setSubjectInformationfield(){
        subjectInformationfield.click();
    }

    public void selectEntity(String entity){

        List<WebElement> box = dr.findElements(By.xpath("//fieldset/*[@class='ng-scope']"));
        List<WebElement> boxentity = dr.findElements(By.xpath("//label"));
        for(int i=0;i<boxentity.size();i++){

             WebElement name = boxentity.get(i);
             String entityname = name.getText();
             if(entityname.contains(entity)){
                 System.out.println("Match found");
                 WebElement element = name.findElement(By.xpath("/span"));
                 element.click();
             }
        }
    }
}
