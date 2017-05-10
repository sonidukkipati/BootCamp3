package oldtests; /**
 * Created by sc on 2/7/2017 */
 import java.util.List;
 import java.util.concurrent.TimeUnit;

 import com.github.javafaker.Faker;
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.firefox.FirefoxDriver;
 import org.openqa.selenium.support.ui.Select;
 import org.testng.annotations.AfterClass;
 import org.testng.annotations.BeforeClass;
 import org.testng.annotations.Test;
 import pages.LoginPage;


public class AddEntity {
 LoginPage loginPage;
 WebDriver dr;
@Test
 public void AddEntityScript() throws InterruptedException {
 // Opening the Browser and adding an entity
  Faker faker = new Faker();
 //WebDriver dr = new ChromeDriver();
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

     // for (String winHandle : dr.getWindowHandles()) {

     //dr.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)

     //}

     ////close the popup

     //dr.close();

     ////switch to parenthandle

     //dr.switchTo().window(parentHandle);

     //dr.findElement(By.name("Login")).click();
//dr.findElement(By.cssSelector("button[class='.btn.btn-block.btn-primary.mt-lg']")).click();

  //dr.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div[2]/form/button")).click();
    // Thread.sleep(3000);


 //dr.manage().timeouts().implicitlyWait(32,TimeUnit.SECONDS);
 //dr.findElement(By.cssSelector("div.ng-binding div#Entities")).click();

     Thread.sleep(12000);

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
 links.get(0).click();
 Thread.sleep(3000);
 //Click Add Entity
 //dr.findElement(By.cssSelector(".pull-right.btn.btn-info.btn-sm.mt-sm.ng-binding")).click();
 dr.findElement(By.xpath("//button[text()='Add Entity']"));
 //Input text to create/add entity
     Thread.sleep(9000);
 dr.findElement(By.name("name")).sendKeys(faker.company().name());
 WebElement drop_down1= dr.findElement(By.name("country"));
// drop_down1.sendKeys("United States");
 dr.findElement(By.name("address1")).sendKeys(faker.address().streetAddress());
 dr.findElement(By.name("city")).sendKeys(faker.address().city());

 Select drop_down2 = new Select(dr.findElement(By.name("state")));
 drop_down2.selectByVisibleText("Texas");


 dr.findElement(By.name("zip")).sendKeys(faker.address().zipCode());
 dr.findElement(By.xpath("html/body/div[2]/section/div/div/div[2]/button[2]")).click();

 // clicking the next step and Prev step buttons

 WebElement box1 = dr.findElement(By.cssSelector(".panel-footer.text-right"));
 List<WebElement> button_links = box1.findElements(By.tagName("button"));

 String str1 = button_links.get(0).getText();
 String str2 = button_links.get(1).getText();

 System.out.println(str1);
 System.out.println(str2);

 //Click the  first Next Step button
 button_links.get(1).click();
 Thread.sleep(3000);
// dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

 //Click the  second Next Step button
 button_links.get(1).click();
 Thread.sleep(3000);
// dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

 // Click the finish button
 WebElement finish = dr.findElement(By.cssSelector(".panel-footer.text-right"));
 List<WebElement> finish_button = finish.findElements(By.tagName("button"));

 String st1 = finish_button.get(1).getText();
 System.out.println(st1);
 finish_button.get(1).click();
 finish_button.get(1).click();

Thread.sleep(3000);
// dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
// dr.close();
// dr.quit();

 }

 @BeforeClass
 public void setup(){
  dr=new ChromeDriver();
  dr.manage().window().maximize();
  loginPage = new LoginPage(dr);

 }
 /*@AfterClass
 public void breakDown(){
  dr.close();
  dr.quit();

 }*/

 }
