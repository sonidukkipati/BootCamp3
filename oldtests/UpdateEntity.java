package oldtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by sc on 2/9/2017.
 */
public class UpdateEntity {

    public static void main(String[] args) throws InterruptedException {

        // Opening the Browser and adding an entity
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

       Thread.sleep(3000);
        WebElement box = dr.findElement(By.cssSelector(".nav.ng-scope"));
        Thread.sleep(3000);
        //WebElement box = dr.findElement(By.className("nav ng-scope"));
        List<WebElement> links = box.findElements(By.tagName("a"));
        String text = links.get(1).getText();
        Thread.sleep(3000);
        System.out.println(text);
        System.out.println("**********");

        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
            links.get(i).click();
            System.out.println(dr.getTitle());

        }
//Try to close popup
        WebElement box1 = dr.findElement(By.xpath("//div[@class='ngdialog-content']"));

        WebElement button1 =  box1.findElement(By.xpath("//button[text()='YES']"));
        button1.click();
        Thread.sleep(3000);

        links.get(0).click();
        Thread.sleep(3000);


// To disable popup window and click on Entities
      /*  WebElement box2 = dr.findElement(By.xpath("//div[@class='ngdialog-content']"));

        WebElement button2 =  box2.findElement(By.xpath("//button[text()='YES']"));
        button2.click();
        Thread.sleep(3000);*/

        //links.get(0).click();
        // Thread.sleep(3000);

        ///html/body/div[2]/section/div/div/div/div/table/tbody/tr[2]/td[2]/button[1]
        // dr.findElement(By.xpath("//button[@class='btn btn-default btn-sm bg-gray-lighter mr-sm']//button[@title='Assign permissions']")).click();
        WebElement tb = dr.findElement(By.xpath("//table"));
        tb.findElement(By.xpath("//button[@title='Edit']")).click();
        Thread.sleep(3000);
        dr.findElement(By.name("name")).clear();
        dr.findElement(By.name("name")).sendKeys("Networks1");
        dr.findElement(By.name("address1")).clear();
        dr.findElement(By.name("address1")).sendKeys("4231 Feafel Ct");
        dr.findElement(By.name("city")).clear();
        dr.findElement(By.name("city")).sendKeys("San Jose");
        Thread.sleep(3000);
        Select drop_down2 = new Select(dr.findElement(By.name("state")));
        drop_down2.selectByVisibleText("California");
        dr.findElement(By.name("zip")).clear();
        dr.findElement(By.name("zip")).sendKeys("94215");

        Thread.sleep(3000);
        Thread.sleep(3000);
//Clicking on Update button
        WebElement update=dr.findElement(By.xpath("//div[@class='panel-footer clearfix']"));
        update.findElement(By.xpath("//button[@class='btn btn-primary btn-labeled pull-right']")).click();
        Thread.sleep(3000);
        Thread.sleep(3000);
        WebElement tb1 = dr.findElement(By.xpath("//table"));
        //List<WebElement> entity_names = tb1.findElements(By.tagName("a"));
        List<WebElement> entityRow = tb1.findElements(By.tagName("a"));
        for (WebElement entity : entityRow) {

            System.out.println(entity.getText());
            if(entity.getText()== "Networks1"){
                System.out.println("Success");
                return;
            }
        }
        WebElement tb3 = dr.findElement(By.xpath("//table"));
        tb3.findElement(By.xpath("//button[@title='Edit']")).click();
        Thread.sleep(3000);
        String City=dr.findElement(By.name("city")).getText();
        System.out.println(City);
        if(City.contains("California")){
            System.out.println("Success");
        }

dr.close();
dr.quit();


    }
}
