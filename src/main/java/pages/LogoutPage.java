package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class LogoutPage extends BaseClass {

    // Locators
    By profileIcon = By.xpath("//p[@class='oxd-userdropdown-name']");
    By logoutOption = By.xpath("//a[text()='Logout']");
    By usernameField = By.xpath("//input[@name='username']");

    // Click Profile Icon
    public void clickProfileIcon() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(profileIcon).click();

        System.out.println("Clicked Profile Icon");
    }

    // Click Logout
    public void clickLogout() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(logoutOption).click();

        System.out.println("Clicked Logout");
    }

    // Verify Logout
    public void verifyLogout() throws InterruptedException {

        Thread.sleep(3000);

        if (driver.findElement(usernameField).isDisplayed()) {
            System.out.println("Logout Successful - Back to Login Page");
        } else {
            System.out.println("Logout Failed");
        }
    }

    // Complete Logout Flow
    public void logout() throws InterruptedException {

        clickProfileIcon();
        clickLogout();
        verifyLogout();
    }
}