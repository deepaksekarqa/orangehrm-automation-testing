package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class LoginPage extends BaseClass {

    // Locators
    By usernameField = By.xpath("//input[@name='username']");
    By passwordField = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[@type='submit']");

    // Enter Username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        System.out.println("Entered Username");
    }

    // Enter Password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        System.out.println("Entered Password");
    }

    // Click Login
    public void clickLogin() {
        driver.findElement(loginButton).click();
        System.out.println("Clicked Login Button");
    }

    // Complete Login Action (Reusable)
    public void login(String username, String password) throws InterruptedException {

        enterUsername(username);
        Thread.sleep(2000);

        enterPassword(password);
        Thread.sleep(2000);

        clickLogin();
        Thread.sleep(3000);

        System.out.println("Login Completed");
    }
}