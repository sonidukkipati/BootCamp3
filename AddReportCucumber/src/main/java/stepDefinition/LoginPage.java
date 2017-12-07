package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sc on 5/24/2017.
 */
public class LoginPage {
    private String username = "sinduchalasani789@gmail.com";
    private String password = "sindu.789";
    WebDriver dr;
    public LoginPage(WebDriver dr){

        this.dr = dr;
        PageFactory.initElements(dr,this);
    }

    @FindBy(xpath=".//*[@id='exampleInputEmail1']")
    WebElement userNameTextBox;
    @FindBy(xpath=".//*[@id='exampleInputPassword1']")
    WebElement passwordFieldTextBox;
    @FindBy(xpath="//button[text()='Login']")
    WebElement loginButton;

    public void typeUsername(){
        userNameTextBox.sendKeys("sinduchalasani789@gmail.com");
       // return dr.findElement(By.xpath(".//*[@id='exampleInputEmail1']"));
    }

    public void typePassword(){
        passwordFieldTextBox.sendKeys("sindu.789");
    }

    public void loginButtonClick(){
        loginButton.click();
    }
}
