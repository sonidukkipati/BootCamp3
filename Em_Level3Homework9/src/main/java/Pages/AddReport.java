package Pages;

//*Created By Em

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddReport {
   WebDriver driver ;
   // Click on "Add Reports" link
   private By addReportLink = By.xpath("html/body/div[2]/aside[1]/div/nav/ul/li[4]/a");
   private By addReportLink2 = By.linkText("Add Report");

   //Entity
   private By entityChoose = By.xpath("//div[2]/div/div/label[@class='ng-binding']");

   //Subject Information
   private By gotoSubjectInfoPage = By.xpath("//section/div/div/form/div[1]/div[2]/ol/li[2]/h4/div");
   private By caseID=By.xpath("//input[@name='caseNumber']");
   private By subspectType = By.xpath("//option[@value='Suspect']");
   private By lastName= By.name("lastName");
   private By firstName = By.name("firstName");
   //Distribution//Gang member
   private By GangMemberPage = By.xpath("//section/div/div/form/div[1]/div[2]/ol/li[5]");
   private By gangUnitCheckbox = By.xpath("//label[contains(.,'Gang Unit')]");
   private By locationOfStop = By.name("locationOfStop");
   private By previewReport = By.xpath("//section//div/form/div[1]/div[2]/ol/li[8]");
   private By publishReport = By.xpath("//section/div/div/form/div[2]/button[1]");
   private By reportLink = By.linkText("Reports");



   public AddReport(WebDriver driver){
       this.driver=driver;

   }
   public void clickAddReportlink (){        driver.findElement(addReportLink).click();    }
   public void clickAddReportlink2 (){        driver.findElement(addReportLink2).click();    }
   public void clickReports(){        driver.findElement(reportLink).click();    }
   public void clickgangUnitCheckbox() {driver.findElement(gangUnitCheckbox).click();}

   public void clickEntity (String entityName){
      // driver.findElement(By.name(entityName)).click();
      WebElement element = driver.findElement(By.xpath("//div[@class='depth-level']//input[@value='"+entityName+"']"));
      JavascriptExecutor executor = (JavascriptExecutor)driver;
      executor.executeScript("arguments[0].click()", element);
   }
   public void SubjectInfoPage(){
       driver.findElement(gotoSubjectInfoPage).click();
   }
   public void setLastName(String strLastName){
       driver.findElement(lastName).clear();
       driver.findElement(lastName).sendKeys(strLastName);
   }
   public void setFirstName(String strFirstName){

       driver.findElement(firstName).clear();
       driver.findElement(firstName).sendKeys(strFirstName);
   }
   public void clickGangmemberPage(){
       driver.findElement(GangMemberPage ).click();
   }
   public void setLocationOfStop(String strLocation){
       driver.findElement(locationOfStop).clear();
       driver.findElement(locationOfStop).sendKeys(strLocation);
   }
   public void clickPreviewReport(){
       driver.findElement(previewReport).click();
   }
   public void clickPublishReport(){
       driver.findElement(publishReport).click();
   }


}
