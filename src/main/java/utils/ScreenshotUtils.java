package utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class ScreenshotUtils extends BaseClass {

    public void captureScreenshot(String fileName) {

        // Take Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Destination path
        File destination = new File("screenshots/" + fileName + ".png");

        try {
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot captured: " + fileName);
        } catch (IOException e) {
            System.out.println("Screenshot failed");
            e.printStackTrace();
        }
    }
}