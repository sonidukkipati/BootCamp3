package oldtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by sc on 2/8/2017.
 */


    public class DeleteEntity {

        public static void main(String[] args) throws InterruptedException {
            //



            // Opening the Browser and adding an entity
            WebDriver dr = new ChromeDriver();
            dr.get("http://testwave.qabidder.net/#/page/login");
            dr.manage().window().maximize();
            //A time of 10 seconds is given to implicitly wait.(A synchronization wait for the findElement() function)
            //dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);

            dr.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys("sinduchalasani789@gmail.com");
            dr.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("sindu.789");
            //dr.findElement(By.tagName("button")).click();
            //dr.findElement(By.cssSelector(".btn.btn-block.btn-primary.mt-lg")).click();
            dr.findElement(By.xpath("//button[text()='Login']")).click();


            Thread.sleep(6000);
            Thread.sleep(3000);
            //dr.findElement(By.cssSelector("div.ng-binding div#Entities")).click();

            WebElement box = dr.findElement(By.cssSelector(".nav.ng-scope"));
            Thread.sleep(6000);
            List<WebElement> links = box.findElements(By.tagName("a"));
            String text = links.get(1).getText();
            Thread.sleep(3000);
            System.out.println(text);
            System.out.println("**********");

            for(int i=0;i<links.size();i++){
                System.out.println(links.get(i).getText());
                links.get(i).click();
                System.out.println(dr.getTitle());

            }
            //Click Entities
            links.get(0).click();
            Thread.sleep(3000);

            dr.findElement(By.xpath("html/body/div[2]/section/div/div/div/div/table/tbody/tr[2]/td[2]/button[4]")).click();
            //dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            Thread.sleep(3000);
            dr.findElement(By.cssSelector(".btn.btn-danger.mr")).click();
            dr.findElement(By.cssSelector(".btn.btn-danger.mr")).click();
            Thread.sleep(3000);
            //dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            WebElement success = dr.findElement(By.cssSelector(".uk-notify-message.alert-dismissable.alert.alert-success"));
            //dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            Thread.sleep(3000);
            String text_success =success.getText();
            System.out.println(text_success);
            if (text_success.contains("deleted"))
            {
                System.out.println("Success");

            }
            dr.close();
            dr.quit();

        }

    }


