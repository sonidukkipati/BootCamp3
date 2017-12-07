package Bidqapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by sc on 5/15/2017.
 */
public class LoginPage {
    WebDriver dr;
    public LoginPage(WebDriver dr){
        this.dr = dr;
    }

    public WebElement LoginLink(){
        return dr.findElement(By.xpath("//a[text()='Log In']"));

    }

    public WebElement UserName(){
        return dr.findElement(By.xpath("//p/input[@id='log']"));

    }
    public WebElement Password(){
        return dr.findElement(By.xpath("//p/input[@id='login_password']"));
    }

    public WebElement SignIn(){
        return dr.findElement(By.xpath("//p/input[@id='submits']"));
    }

}
