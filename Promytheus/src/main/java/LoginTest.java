import PromytheusPages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by sc on 10/17/2017.
 */
public class LoginTest {

    WebDriver dr;
    LoginPage loginPage;


    @BeforeTest
    public void setup(){
        dr = new ChromeDriver();
        loginPage = new LoginPage(dr);

    }
@Test
    public void Login() throws InterruptedException {

    dr.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
    dr.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
    dr.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com");
    Thread.sleep(5000);
    loginPage.typeUsername();
    Thread.sleep(3000);
    loginPage.typePassword();
    Thread.sleep(3000);
    loginPage.clickLogin();
    Thread.sleep(3000);
}

}
