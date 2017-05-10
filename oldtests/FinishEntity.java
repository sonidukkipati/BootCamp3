package oldtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by sc on 2/7/2017.
 */
public class FinishEntity {
    public static void main(String[] args) throws InterruptedException {
//
        // Opening the Browser and adding an entity
        WebDriver dr = new ChromeDriver();
        dr.get("http://testwave.qabidder.net/#/page/login");
        dr.manage().window().maximize();
        //A time of 10 seconds is given to implicitly wait.(A synchronization wait for the findElement() function)
        Thread.sleep(3000);

        dr.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys("sinduchalasani789@gmail.com");
        dr.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("sindu.789");
        dr.findElement(By.xpath("//button[text()='Login']")).click();

       // dr.findElement(By.cssSelector(".btn.btn-block.btn-primary.mt-lg")).click();


        Thread.sleep(6000);
        //dr.findElement(By.cssSelector("div.ng-binding div#Entities")).click();

        WebElement box = dr.findElement(By.cssSelector(".nav.ng-scope"));
        Thread.sleep(6000);

        List<WebElement> links = box.findElements(By.tagName("a"));
        String text = links.get(1).getText();
        System.out.println(text);
        System.out.println("**********");

        for(int i=0;i<links.size();i++){
            System.out.println(links.get(i).getText());
            links.get(i).click();
            System.out.println(dr.getTitle());

        }
        Thread.sleep(3000);
        if (dr.findElements(By.xpath("//div[@class='ngdialog-content']")).size()>0) {
            dr.findElement(By.xpath("//button[text()='YES']")).click();
        }
        Thread.sleep(3000);
        //Click Entities
        links.get(0).click();
        dr.findElement(By.xpath("//table//tr[4]//button[3]")).click();
       // WebElement tb = dr.findElement(By.xpath("//table"));
       // tb.findElement(By.xpath("//button[@title='Finish creating the entity']")).click();
        Thread.sleep(3000);
        Thread.sleep(6000);
        WebElement finish = dr.findElement(By.cssSelector(".panel-footer.text-right"));
        List<WebElement> finish_button = finish.findElements(By.tagName("button"));

        String st1 = finish_button.get(1).getText();
        System.out.println(st1);
        finish_button.get(1).click(); //Go to PayPal


        Thread.sleep(6000);
        dr.findElement(By.xpath("//input[@value='Pay with my PayPal account']")).click();
        //dr.findElement(By.xpath("//span[class='buttonAsLink']")).click();
        //dr.findElement(By.name("login_button")).click();
        Thread.sleep(6000);
        Thread.sleep(3000);
        //Entering the information into Paypal account

        dr.findElement(By.cssSelector("#login_email")).clear();
        dr.findElement(By.cssSelector("#login_email")).sendKeys("sinduchalasani789@gmail.com");
        dr.findElement(By.cssSelector("#login_password")).clear();
        dr.findElement(By.cssSelector("#login_password")).sendKeys("sindu.789");
        dr.findElement(By.cssSelector("#submitLogin")).click();

        //Time to authenticate
        Thread.sleep(6000);
        dr.findElement(By.cssSelector("#continue")).click();


        //Time to add and go to wave again
        Thread.sleep(3000);
        dr.close();
        dr.quit();





    }
}
