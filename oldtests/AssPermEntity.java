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
public class AssPermEntity {

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

        WebElement box1 = dr.findElement(By.xpath("//div[@class='ngdialog-content']"));

        WebElement button1 =  box1.findElement(By.xpath("//button[text()='YES']"));
        button1.click();
        Thread.sleep(3000);

        links.get(0).click();
        Thread.sleep(3000);


// To disable popup window and click on Entities
      /*  WebElement box1 = dr.findElement(By.xpath("//div[@class='ngdialog-content']"));

        WebElement button1 =  box1.findElement(By.xpath("//button[text()='YES']"));
        button1.click();*/
        Thread.sleep(3000);

        //links.get(0).click();
       // Thread.sleep(3000);

        ///html/body/div[2]/section/div/div/div/div/table/tbody/tr[2]/td[2]/button[1]
       // dr.findElement(By.xpath("//button[@class='btn btn-default btn-sm bg-gray-lighter mr-sm']//button[@title='Assign permissions']")).click();
        WebElement tb = dr.findElement(By.xpath("//table"));
        tb.findElement(By.xpath("//button[@title='Assign permissions']")).click();
        Thread.sleep(3000);

        //Select drop_down1= new Select(dr.findElement(By.xpath("//select[@class='text-center ng-pristine ng-valid ng-empty ng-touched']")));
        //Select drop_down1 = new Select(dr.findElement(By.xpath("//*[@id=\"ngdialog2\"]/div[2]/div[1]/div/table/tbody/tr[1]/td[2]/select")));
        //drop_down1.selectByVisibleText("Admin");
        // //*[@id="ngdialog2"]/div[2]/div[1]/div/table/tbody/tr[1]/td[2]/select
        //trying different way
        Select drop_down1= new Select(dr.findElement(By.xpath("//select[1]")));
        drop_down1.selectByVisibleText("Admin");
        Thread.sleep(3000);
        Thread.sleep(3000);

       //Select drop_down2 =new Select( tb1.findElement(By.name("Select Role"))[1]);
        //Thread.sleep(3000);
        //drop_down2.selectByVisibleText("Admin");
       // System.out.println(st1);

        dr.findElement(By.xpath("//button[@title='Save changes']")).click();
        Thread.sleep(3000);
        Thread.sleep(3000);
        dr.close();
        dr.quit();

    }


}
