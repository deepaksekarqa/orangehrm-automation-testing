package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class AddEmployeePage extends BaseClass {

    // Locators
    By firstNameField = By.name("firstName");
    By lastNameField = By.name("lastName");
    By saveButton = By.xpath("//button[@type='submit']");

    // Enter First Name
    public void enterFirstName(String fname) {
        driver.findElement(firstNameField).sendKeys(fname);
        System.out.println("Entered First Name");
    }

    // Enter Last Name
    public void enterLastName(String lname) {
        driver.findElement(lastNameField).sendKeys(lname);
        System.out.println("Entered Last Name");
    }

    // Click Save
    public void clickSave() {
        driver.findElement(saveButton).click();
        System.out.println("Clicked Save Button");
    }

    // Complete Add Employee Action
    public void addEmployee(String fname, String lname) throws InterruptedException {

        Thread.sleep(3000);

        enterFirstName(fname);
        Thread.sleep(2000);

        enterLastName(lname);
        Thread.sleep(2000);

        clickSave();
        Thread.sleep(6000);

        System.out.println("Employee Added Successfully");
    }
}