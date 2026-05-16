package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.LoginPage;
import pages.DashboardPage;
import pages.PIMPage;
import pages.AddEmployeePage;
import pages.EmployeeListPage;
import pages.LogoutPage;
import utils.ExcelUtils;
import utils.ScreenshotUtils;

public class TestRun extends BaseClass {

    // ─────────────────────────────────────────
    // TC01 — Login
    // ─────────────────────────────────────────
    @Test(priority = 1, description = "Login to OrangeHRM")
    public void testLogin() throws InterruptedException {
        LoginPage login = new LoginPage();
        login.login("Admin", "admin123");
        ScreenshotUtils screenshot = new ScreenshotUtils();
        screenshot.captureScreenshot("Login_Success");
        System.out.println("TC01 - Login Test Passed");
    }

    // ─────────────────────────────────────────
    // TC02 — Verify Dashboard
    // ─────────────────────────────────────────
    @Test(priority = 2, description = "Verify Dashboard is displayed")
    public void testDashboard() throws InterruptedException {
        DashboardPage dashboard = new DashboardPage();
        dashboard.verifyDashboard();
        ScreenshotUtils screenshot = new ScreenshotUtils();
        screenshot.captureScreenshot("Dashboard");
        System.out.println("TC02 - Dashboard Test Passed");
    }

    // ─────────────────────────────────────────
    // DATA PROVIDER — reads from Excel
    // Must be in the same class as the @Test that uses it
    // ─────────────────────────────────────────
    @DataProvider(name = "employeeData")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getTestData("testdata/EmployeeData.xlsx", "Sheet1");
    }

    // ─────────────────────────────────────────
    // TC03 — Add Employee (Data-Driven)
    // Runs once per row in Excel automatically
    // ─────────────────────────────────────────
    @Test(priority = 3, dataProvider = "employeeData", description = "Add multiple employees from Excel")
    public void testAddEmployee(String firstName, String lastName,
                                String username, String password) throws InterruptedException {
        DashboardPage dashboard = new DashboardPage();
        dashboard.clickPIM();

        PIMPage pim = new PIMPage();
        pim.verifyPIMPage();
        pim.clickAddEmployee();

        AddEmployeePage addEmp = new AddEmployeePage();
        addEmp.addEmployee(firstName, lastName);

        ScreenshotUtils screenshot = new ScreenshotUtils();
        screenshot.captureScreenshot("Employee_Added_" + firstName);
        System.out.println("TC03 - Employee Added: " + firstName + " " + lastName);
    }

    // ─────────────────────────────────────────
    // TC04 — Search & Verify Employee
    // ─────────────────────────────────────────
    @Test(priority = 4, description = "Search and verify added employee")
    public void testSearchEmployee() throws InterruptedException {
        DashboardPage dashboard = new DashboardPage();
        dashboard.clickPIM();

        PIMPage pim = new PIMPage();
        pim.clickEmployeeList();

        EmployeeListPage empList = new EmployeeListPage();
        empList.searchEmployee("Deepak");

        ScreenshotUtils screenshot = new ScreenshotUtils();
        screenshot.captureScreenshot("Employee_Verified");
        System.out.println("TC04 - Employee Search Test Passed");
    }

    // ─────────────────────────────────────────
    // TC05 — Logout
    // ─────────────────────────────────────────
    @Test(priority = 5, description = "Logout from OrangeHRM")
    public void testLogout() throws InterruptedException {
        LogoutPage logout = new LogoutPage();
        logout.logout();
        ScreenshotUtils screenshot = new ScreenshotUtils();
        screenshot.captureScreenshot("Logout_Success");
        System.out.println("TC05 - Logout Test Passed");
    }
}