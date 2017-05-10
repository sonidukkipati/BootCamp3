package Level3HomeWork5;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.NavBar;
import testresources.PageResources;

/**
 * Created by sc on 5/8/2017.
 */
public class TestBase {
    WebDriver dr ;
    LoginPage loginPage ;
    NavBar navbarpage;
    PageResources pageResources;
    Faker faker;


public void TestBaseLogin() throws InterruptedException {
    WebDriver dr = new ChromeDriver();
    LoginPage loginPage = new LoginPage(dr);
    NavBar navbarpage= new NavBar(dr);
    PageResources pageResources = new PageResources(dr) ;
    dr.get("http://qabidder.net/testwave");
    Thread.sleep(5000);
    loginPage.userNameField().sendKeys("sinduchalasani789@gmail.com");
    loginPage.passWordField().sendKeys("sindu.789");
    Thread.sleep(5000);
    loginPage.loginButton().click();
    Thread.sleep(10000);
    dr.close();
    dr.quit();
}

public void TestBaseLogout() throws InterruptedException {
    WebDriver dr = new ChromeDriver();
    LoginPage loginPage = new LoginPage(dr);
    NavBar navbarpage= new NavBar(dr);
    PageResources pageResources = new PageResources(dr) ;

    dr.get("http://qabidder.net/testwave");
    Thread.sleep(5000);
    loginPage.userNameField().sendKeys("sinduchalasani789@gmail.com");
    loginPage.passWordField().sendKeys("sindu.789");
    Thread.sleep(5000);
    loginPage.loginButton().click();
    Thread.sleep(10000);
    pageResources.getProfile().CaretDownLink().click();
    Thread.sleep(4000);
    pageResources.getProfile().LogoutButton().click();
    Thread.sleep(4000);

    //verification that Application logged out
    WebElement Text = dr.findElement(By.xpath("//p"));
    String signInText = Text.getText();
    System.out.println(signInText);
    String actualText = "SIGN IN TO CONTINUE.";

    Boolean checkStatus= false;
    if(actualText.contains(signInText)) {
        checkStatus = true;
    }

    try {
        Assert.assertEquals(signInText,actualText);
        System.out.println("Found " + actualText + " in the SignIn of Page");


    } catch (Throwable t) {
        Assert.fail("Could not find " + actualText + " in the SignIn of Page");


    }
  dr.close();
    dr.quit();

}
}
