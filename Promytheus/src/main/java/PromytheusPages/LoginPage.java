package PromytheusPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sc on 10/16/2017.
 */
public class LoginPage {

    private String username = "dukki.pati235@gmail.com";
    private String password = "soni235";
    WebDriver dr;

    public LoginPage(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr,this);

    }


    @FindBy(xpath="//input[@name='email']")
    WebElement usernameTextBox;

    @FindBy(xpath="//input[@name='password']")
    WebElement passWordBox;

    @FindBy(xpath="//button[text()='Login']")
    WebElement loginButton;

    public void typeUsername(){
        usernameTextBox.sendKeys(username);
    }

    public void typePassword(){
        passWordBox.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }



}
