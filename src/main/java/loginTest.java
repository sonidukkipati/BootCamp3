import LiveInewsPages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by sc on 12/8/2017.
 */
public class loginTest {
    WebDriver dr;
    LoginPage loginPage;

    @BeforeClass
    public void setup(){
        dr= new ChromeDriver();
        loginPage = new LoginPage(dr);
        dr.get("http://liveinews.com/login/");
        dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test

    public void test1() throws InterruptedException {

        loginPage.typeusername();
        loginPage.typepassword();
        Thread.sleep(3000);
        loginPage.loginButton();

    }
}
