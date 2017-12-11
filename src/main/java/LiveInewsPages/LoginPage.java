package LiveInewsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sc on 12/8/2017.
 */
public class LoginPage {
    WebDriver dr;
    private String useremail="sinduchalasani789@gmail.com";
    private  String password="sindu";

    public LoginPage(WebDriver dr){

        this.dr=dr;
        PageFactory.initElements(dr,this);
    }

    @FindBy(xpath="//input[@name='log']")
    WebElement usernamefield;

    @FindBy(xpath="//input[@name='pwd']")
    WebElement passwordfield;

    public void typeusername(){
        usernamefield.sendKeys(useremail);
    }
    public void typepassword() { passwordfield.sendKeys(password);}
    public void loginButton() { WebElement ele = dr.findElement(By.xpath("//button[@name='wp-submit']"));
    ele.click();
    }
}

