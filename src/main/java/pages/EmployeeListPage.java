package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class EmployeeListPage extends BaseClass {

    // Locators
	By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    By searchButton = By.xpath("//button[@type='submit']");
    By resultName = By.xpath("//div[@role='row']//div[3]");

    // Enter Employee Name
    public void enterEmployeeName(String name) throws InterruptedException {

        Thread.sleep(3000);

        driver.findElement(employeeNameField).clear();
        driver.findElement(employeeNameField).sendKeys(name);

        Thread.sleep(3000); // wait for suggestion

        // Press DOWN + ENTER to select suggestion
        driver.findElement(employeeNameField).sendKeys(org.openqa.selenium.Keys.ARROW_DOWN);
        driver.findElement(employeeNameField).sendKeys(org.openqa.selenium.Keys.ENTER);

        System.out.println("Entered Employee Name in Search");
    }

    // Click Search
    public void clickSearch() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(searchButton).click();

        System.out.println("Clicked Search Button");
    }

    // Verify Employee
    public void verifyEmployee(String name) throws InterruptedException {

        Thread.sleep(3000);

        String pageSource = driver.getPageSource();

        if (pageSource.contains(name)) {
            System.out.println("Employee Verified Successfully: " + name);
        } else {
            System.out.println("Employee NOT Found");
        }
    }

    // Complete Search Flow
    public void searchEmployee(String name) throws InterruptedException {

        enterEmployeeName(name);
        clickSearch();
        verifyEmployee(name);
    }
}