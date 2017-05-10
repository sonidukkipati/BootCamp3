package oldtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by sc on 2/9/2017.
 */
public class LoginEntity {
    String username;
    String password;
    static WebDriver dr = null;

    public static void main(String[] args) throws InterruptedException {

        dr = new ChromeDriver();
        LoginEntity login1 = new LoginEntity();
        login1.username = "samhitachalasani@gmail.com";
        login1.password = "samhita.789";
        LoginEntity login2 = new LoginEntity("sinduchalasani789@gmail.com","sindu.789");
           login2.username= "sinduchalasani789@gmail.com";
           login2.password = "sindu.789";
        //login2.username= "sinduchalasani789@gmail.com";

        dr.close();
        dr.quit();

    }
        public  LoginEntity() {
            String username;
            String password;

            System.out.println("this funtion is to login into wave");
        }

    public  LoginEntity(String username, String password) throws InterruptedException {
        this.username = username;
        this.password = password;
        dr.get("http://testwave.qabidder.net/#/page/login");
        dr.manage().window().maximize();
        Thread.sleep(3000);
        dr.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys(username);
        dr.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys(password);
        dr.findElement(By.xpath("//button[text()='Login']")).click();
        Thread.sleep(3000);


    }

}




