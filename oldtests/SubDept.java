package oldtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Created by sc on 2/9/2017.
 */
public class SubDept {

    public static void main(String[] args) throws InterruptedException {

        WebDriver dr = new ChromeDriver();
        dr.get("http://testwave.qabidder.net/#/page/login");
        dr.manage().window().maximize();
        Thread.sleep(3000);
        //A time of 10 seconds is given to implicitly wait.(A synchronization wait for the findElement() function)
        //dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        // To get the window handle of popup and closing it
        //String parentHandle = dr.getWindowHandle();

        dr.findElement(By.xpath(".//*[@id='exampleInputEmail1']")).sendKeys("sinduchalasani789@gmail.com");
        dr.findElement(By.xpath(".//*[@id='exampleInputPassword1']")).sendKeys("sindu.789");
        dr.findElement(By.xpath("//button[text()='Login']")).click();

        Thread.sleep(3000);

        WebElement box = dr.findElement(By.cssSelector(".nav.ng-scope"));
        //WebElement box = dr.findElement(By.className("nav ng-scope"));
        List<WebElement> links = box.findElements(By.tagName("a"));
        String text = links.get(1).getText();
        System.out.println(text);
        System.out.println("**********");

        for(int i=0;i<links.size();i++){
            System.out.println(links.get(i).getText());
            links.get(i).click();
            System.out.println(dr.getTitle());

        }
        //Click Entities
       // /html/body/div[2]/section/div/div/div/div/table/tbody/tr[3]/td[1]/div/div[1]/a
        /*WebElement box1 = dr.findElement(By.xpath("div[@class='ngdialog-message']"));
        box1.findElement(By.xpath("//button[text()='YES']")).click();
        Thread.sleep(3000);
        Thread.sleep(3000);*/
       // String parentHandle = dr.getWindowHandle();
       /* for (String winHandle : dr.getWindowHandles()) {

            dr.switchTo().window(winHandle);
        }
        //close pop up
        //dr.close();

        dr.switchTo().window(parentHandle);*/

        //links.get(0).click();
       // Thread.sleep(3000);
        WebElement box1 = dr.findElement(By.xpath("//div[@class='ngdialog-content']"));

        WebElement button1 =  box1.findElement(By.xpath("//button[text()='YES']"));
        button1.click();
        Thread.sleep(3000);

        links.get(0).click();
        Thread.sleep(3000);
       //WebElement box1 = dr.findElement(By.xpath("div[@class='ngdialog-message']"));
        // /html/bodbutty
        //dr.findElement(By.xpath("//button[text()='YES']")).click();
      // WebElement button1 =  box1.findElement(By.xpath("//button[text()='YES']"));
      // button1.click();
        Thread.sleep(3000);
      //  dr.findElement(By.xpath("//a[@class='ng-binding']and[text()='Networks']")).click();
        dr.findElement(By.xpath("/html/body/div[2]/section/div/div/div/div/table/tbody/tr[3]/td[1]/div/div[1]/a")).click();

        Thread.sleep(3000);
        Thread.sleep(3000);
        dr.findElement(By.xpath("//button[text()='Add Department']")).click();
        Thread.sleep(3000);
        dr.findElement(By.xpath("//input[@placeholder='Department name']")).sendKeys("Gig Networks");
        Thread.sleep(3000);
        dr.findElement(By.xpath("//button[text()='Add']")).click();
        Thread.sleep(3000);
        Thread.sleep(3000);
        
        WebElement tb = dr.findElement(By.xpath("//table"));
        List<WebElement> entity_names = tb.findElements(By.tagName("a"));
        List<WebElement> entityRow = tb.findElements(By.tagName("a"));
        for (WebElement entity : entityRow) {

            System.out.println(entity.getText());
            if(entity.getText()== "Gig Networks"){
                System.out.println("Success");
                return;
            }
        }
        

       /*for(int i=1;i<10;i++)
        {
          Strin =  dr.findElement(By.xpath("/html/body/div[2]/section/div/div/div/div/table/tbody/tr[i]/td[1]/div/div[1]/a")).getText();
          System.out.println(addtext);
        }*/
        dr.close();
        dr.quit();



    }
}
