import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by sc on 2/7/2017.
 */
public class test {
    WebDriver dr;

    public static void main(String [] args){

        WebDriver dr = new ChromeDriver();
        dr.get("http://www.google.com");
        dr.close();

    }

}
