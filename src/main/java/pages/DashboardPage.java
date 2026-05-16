package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class DashboardPage extends BaseClass {

    // Locators
    By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    By pimMenu = By.xpath("//span[text()='PIM']");

    // Verify Dashboard is displayed
    public void verifyDashboard() throws InterruptedException {

        Thread.sleep(3000);

        if (driver.findElement(dashboardHeader).isDisplayed()) {
            System.out.println("Dashboard Verified - Login Successful");
        } else {
            System.out.println("Dashboard NOT Displayed - Login Failed");
        }
    }

    // Click PIM Menu
    public void clickPIM() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(pimMenu).click();

        System.out.println("Clicked PIM Menu");
    }
}