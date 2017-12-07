package PromytheusPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by sc on 10/17/2017.
 */
public class CategoryPage {

    WebDriver dr;

    public CategoryPage(WebDriver dr){

        this.dr=dr;
        PageFactory.initElements(dr,this);

    }


    @FindBy(xpath="//span[@aria-label='Select box activate']")
    WebElement Category;

    public void categoryselect(String str1) {
        Select category = new Select(dr.findElement(By.xpath("//span[@aria-label='Select box activate']")));
        category.selectByVisibleText(str1);

    }

    //Next Button
    @FindBy(xpath="//button[text()='Next']")
    WebElement NextButton;

    //Clicking next button
    public void nextbuttonClick(){
        NextButton.click();
    }

    //Previous Button
    @FindBy(xpath="//button[text()='Previous']")
    WebElement PrevButton;

    //Clicking prev button

    public void prevbuttonClick(){
        PrevButton.click();
    }
}
