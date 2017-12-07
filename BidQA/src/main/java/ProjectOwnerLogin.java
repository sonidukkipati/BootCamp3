import Bidqapages.LoginPage;
import TestResources.PageResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by sc on 8/30/2017.
 */
public class ProjectOwnerLogin {

    WebDriver dr;

    PageResources pageResources;
    LoginPage loginPage;


  @Test
  public void PWLogin() throws InterruptedException {

      dr.get("http://test.bidqa.com/");
      Thread.sleep(5000);
      pageResources.getLoginPage().LoginLink().click();
      pageResources.getLoginPage().UserName().sendKeys("chinni");
      pageResources.getLoginPage().Password().sendKeys("107fc89");
      Thread.sleep(2000);
      pageResources.getLoginPage().SignIn().click();
      Thread.sleep(5000);
  }



    @BeforeClass
    public void login() {

      dr= new ChromeDriver() ;
      loginPage = new LoginPage(dr);
      pageResources = new PageResources(dr);

    }


    @AfterClass
    public void cleanUP(){

      dr.close();
      dr.quit();

    }




}
