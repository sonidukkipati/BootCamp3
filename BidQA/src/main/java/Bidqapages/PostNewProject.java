package Bidqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

/**
 * Created by sc on 5/15/2017.
 */
public class PostNewProject {
 WebDriver dr;
 Select select;
    public PostNewProject(WebDriver dr){
        this.dr = dr;

    }


    // clicking on Post New Project
    public WebElement PostNew(){
       return dr.findElement(By.partialLinkText("Post New"));
    }

    //To Get all Links on Page and clicking if href attribute matches
    public void clickLinkByHref(String refh){
        List<WebElement> anchors  = dr.findElements(By.tagName("a"));
        Iterator i = anchors.iterator();

        while (i.hasNext()){

            WebElement anch = (WebElement) i.next();
            if (anch.getAttribute("href").contains(refh)){
                anch.click();
                break;
            }

        }


    }

    //Selecting Function Test
    public void functionTestcategary(){

        String st3 = "//div[@class='multi_cat_placeholder_thing']/label[5]/input[contains(text(),'Function Test')]";
      WebElement el =  dr.findElement(By.xpath(st3));
      el.click();
       // [@name = 'project_cat_cat_multi[]']
    }

  public WebElement projectTiltle(){
       return dr.findElement(By.xpath("//p/input[@name='project_title']"));
  }

    public WebElement projectDescription(){
        return dr.findElement(By.xpath("//p/textarea[@name='project_description']"));

    }

    // Selecting the Categories
    public void categoriesBox(int index) {

        HashMap<Integer,String> hp = new HashMap<Integer,String>();
        hp.put(65,"Automation - Mobile");
        hp.put(88,"Automation-System");
        hp.put(2,"Black Box");
        hp.put(5055,"Compatibility Test");

        WebElement categories = dr.findElement(By.xpath("//div[@class='multi_cat_placeholder_thing']"));
        List<WebElement> el = categories.findElements(By.xpath("//label"));
        List<WebElement> BB =  dr.findElements(By.name("project_cat_cat_multi[]"));
        String name = "project_cat_cat_multi[]";

        String l1 = el.get(index).getText();
        //********************************************************************************

        System.out.println(l1);
        String sValue = (BB.get(index).getAttribute("value"));
        String labelNumber = "//label/input[@value="+"'"+sValue+"']";
        System.out.println(sValue);
        Set set =hp.entrySet();
        Iterator iterator = set.iterator();

        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());

            String categary;
            categary = (String) mentry.getValue();
            Integer value = (Integer) mentry.getKey();
            System.out.println(categary);
            JavascriptExecutor jse = (JavascriptExecutor)dr;
            jse.executeScript("scroll(0,250)"); // Since the checkbox is at the bottom
            if (categary.equals(l1))  {

                //JavascriptExecutor jse = (JavascriptExecutor)dr;
                //jse.executeScript("scroll(0,250)"); // Since the heckbox is at the bottom
                //WebElement we = dr.findElement(By.xpath("//input[@value='88']"));
                WebElement we = dr.findElement(By.xpath(labelNumber));
                if(!we.isSelected()){
                    we.click();
                }
                 break;
            }

        }






    }


    public WebElement tags(){
        return dr.findElement(By.xpath("//p/input[@name='project_tags']"));

    }

    //Selecting the skill set
    public void skillType(int index){
        HashMap<Integer,String> hp = new HashMap<Integer,String>();
        hp.put(65,"Automation - Mobile");
        hp.put(88,"Automation-System");
        hp.put(2,"Black Box");
        hp.put(5055,"Compatibility Test");
        hp.put(5049,"Function Test");
        hp.put(5051,"Integration Test" + "");
        hp.put(5048,"GUI UX");
        hp.put(89,"Gray Box");
        hp.put(89,"Gray Box");
        hp.put(89,"Gray Box");



        WebElement categories = dr.findElement(By.xpath("//div[@class='multi_cat_placeholder_thing']"));
        List<WebElement> el = categories.findElements(By.xpath("//label"));
        List<WebElement> BB =  dr.findElements(By.name("project_skill_cat_multi[]"));
        String name = "project_cat_cat_multi[]";

        String l1 = el.get(index).getText();
        //********************************************************************************

        System.out.println(l1);
        String sValue = (BB.get(index).getAttribute("value"));
        String labelNumber = "//label/input[@value="+"'"+sValue+"']";
        System.out.println(sValue);
        Set set =hp.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());

            String categary;
            categary = (String) mentry.getValue();
            Integer value = (Integer) mentry.getKey();
            System.out.println(categary);
            JavascriptExecutor jse = (JavascriptExecutor)dr;
            jse.executeScript("scroll(0,250)"); // Since the checkbox is at the bottom
            if (categary.equals(l1))  {

                //JavascriptExecutor jse = (JavascriptExecutor)dr;
                //jse.executeScript("scroll(0,250)"); // Since the heckbox is at the bottom
                //WebElement we = dr.findElement(By.xpath("//input[@value='88']"));
                WebElement we = dr.findElement(By.xpath(labelNumber));
                if(!we.isSelected()){
                    we.click();
                }
                break;
            }

        }

    }


    //Project Budget
    public void projectBudget(String type){
        select = new Select(dr.findElement(By.xpath("//select[@name='budgets']")));
        select.selectByValue(type);
    }


    //select project End Date
    public WebElement projectEndDate(){
        return dr.findElement(By.xpath("//p/input[@name='ending' and @id='ending']"));
    }


  //Country selection
    public void selectCountry(String type) {
        select = new Select(dr.findElement(By.xpath("//select[@id='do_input_new']")));
        select.selectByValue(type);
    }
}
