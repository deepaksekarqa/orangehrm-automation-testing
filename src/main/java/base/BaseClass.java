package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    // Static WebDriver (shared across project)
    public static WebDriver driver;

    // Setup Method (Launch Browser)
    @BeforeClass
    public void setup() {

        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        // Launch Chrome Browser
        driver = new ChromeDriver();

        // Maximize Window
        driver.manage().window().maximize();

        // Open Application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Browser Launched and Application Opened");
    }

    // TearDown Method (Close Browser)
    @AfterClass
    public void tearDown() {

        driver.quit();

        System.out.println("Browser Closed");
    }
}