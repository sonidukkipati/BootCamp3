import Bidqapages.LoginPage;
import Bidqapages.PostNewProject;
import TestResources.PageResources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by sc on 8/30/2017.
 */
public class ProjectOwnerPostProject {


    WebDriver dr;
    PageResources pageResources;
    LoginPage loginPage;
    PostNewProject postNewProject;

    @Test
    public void PostNewProject() throws InterruptedException {

        dr.get("http://test.bidqa.com/");
        Thread.sleep(5000);
        pageResources.getLoginPage().LoginLink().click();
        pageResources.getLoginPage().UserName().sendKeys("chinni");
        pageResources.getLoginPage().Password().sendKeys("107fc89");
        Thread.sleep(2000);
        pageResources.getLoginPage().SignIn().click();
        Thread.sleep(10000);
        pageResources.getPostNewProject().PostNew().click();
        Thread.sleep(2000);
        pageResources.getPostNewProject().projectTiltle().sendKeys("Automation SystemTest");
        Thread.sleep(2000);
        pageResources.getPostNewProject().projectDescription().sendKeys("This is Systest Automation");
        Thread.sleep(2000);
        pageResources.getPostNewProject().categoriesBox(1);
        Thread.sleep(5000);
        pageResources.getPostNewProject().categoriesBox(3);
        Thread.sleep(2000);


    }





    @BeforeClass
    public void login() {

        dr= new ChromeDriver() ;
        loginPage = new LoginPage(dr);
        pageResources = new PageResources(dr);
        postNewProject = new PostNewProject(dr);

    }


   /* @AfterClass
    public void cleanUP(){

        dr.close();
        dr.quit();

    }
 */

}
