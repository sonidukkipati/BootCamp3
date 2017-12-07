package helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class TakeScreenShot {

    public void takeScreenshot(WebDriver driver,String fileName){
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        FileUtils.copyFile(src, new File("C:\\HW9_ScreenShots\\"+ fileName+".png"));

        }
        catch (IOException e){
            System.out.println("Not able to create Screenshot .. Check it ..");
        }

    }
}
