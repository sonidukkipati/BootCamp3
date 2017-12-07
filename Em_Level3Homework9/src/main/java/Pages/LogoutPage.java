package Pages;


//*Created By Em

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

    WebDriver driver;


    private By clickUserPanel= By.cssSelector("span.mr-sm.ng-binding") ;

    private By clickSignOut= By.xpath("//button[@ng-click='app.logout()']");


    public  LogoutPage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickUserPanel(){
        driver.findElement(clickUserPanel).click();
    }
    public void clickSignOut(){ driver.findElement(clickSignOut).click();}



}

