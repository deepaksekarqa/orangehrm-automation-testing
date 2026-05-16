package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class PIMPage extends BaseClass {

    // Locators
    By pimHeader = By.xpath("//h6[text()='PIM']");
    By addEmployeeTab = By.xpath("//a[text()='Add Employee']");
    By employeeListTab = By.xpath("//a[text()='Employee List']");

    // Verify PIM Page
    public void verifyPIMPage() throws InterruptedException {

        Thread.sleep(3000);

        if (driver.findElement(pimHeader).isDisplayed()) {
            System.out.println("PIM Page Verified");
        } else {
            System.out.println("PIM Page NOT Displayed");
        }
    }

    // Click Add Employee
    public void clickAddEmployee() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(addEmployeeTab).click();

        System.out.println("Clicked Add Employee Tab");
    }

    // Click Employee List
    public void clickEmployeeList() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(employeeListTab).click();

        System.out.println("Clicked Employee List Tab");
    }
}