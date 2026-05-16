# 👥 OrangeHRM – HR Management System Testing

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.18.1-green?style=flat-square&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red?style=flat-square)
![Apache POI](https://img.shields.io/badge/Apache%20POI-5.2.3-blue?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.x-blue?style=flat-square&logo=apachemaven)
![Status](https://img.shields.io/badge/Tests-7%2F7%20Passed-brightgreen?style=flat-square)

---

## 📌 Project Overview

End-to-end **Data-Driven automation framework** for the OrangeHRM HR management demo application.  
This project demonstrates **Apache POI + @DataProvider** integration reading employee test data from an Excel file and running the Add Employee test multiple times with different data sets.

**Application Under Test:** https://opensource-demo.orangehrmlive.com/

---

## 🎯 Test Cases Covered

| # | Test Method | Description | Iterations | Result |
|---|------------|-------------|-----------|--------|
| 1 | testLogin | Login with valid credentials | 1 | ✅ PASSED |
| 2 | testDashboard | Verify dashboard loads after login | 1 | ✅ PASSED |
| 3 | testAddEmployee | Add employee via @DataProvider | 3 | ✅ PASSED (×3) |
| 4 | testSearchEmployee | Search for added employee | 1 | ✅ PASSED |
| 5 | testLogout | Logout successfully | 1 | ✅ PASSED |

**Total: 7/7 Passed — 0 Failures — 0 Skips**  
*(5 test methods × data-driven iterations = 7 total executions)*

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| Java | 17 | Programming language |
| Selenium WebDriver | 4.18.1 | Browser automation |
| TestNG | 7.11.0 | Test framework and @DataProvider |
| Apache POI | 5.2.3 | Read employee data from Excel (.xlsx) |
| Maven | 3.x | Build tool and dependency management |
| WebDriverManager | 5.7.0 | Automatic ChromeDriver management |

---

## 📁 Project Structure

```
OrangeHRMAutomation/
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── BaseClass.java          ← static WebDriver, @BeforeClass, @AfterClass
│   │   └── pages/
│   │       ├── LoginPage.java          ← Login module
│   │       ├── DashboardPage.java      ← Dashboard module
│   │       ├── EmployeePage.java       ← Add & Search Employee module
│   │       └── LogoutPage.java         ← Logout module
│   └── test/java/
│       └── tests/
│           └── OrangeHRMTests.java     ← 5 @Test methods + @DataProvider
├── testData/
│   └── EmployeeData.xlsx               ← Test data file (3 employee records)
├── pom.xml
└── testng.xml
```

---

## 📊 Test Data — EmployeeData.xlsx

The `@DataProvider` reads from `testData/EmployeeData.xlsx`:

| First Name | Last Name | Employee ID |
|-----------|----------|------------|
| Deepak | Sekar | EMP001 |
| Ravi | Kumar | EMP002 |
| Priya | Sharma | EMP003 |

> ⚠️ **Note:** No real personal data is used. These are dummy test data entries for automation practice only.

---

## ⚙️ Prerequisites

- Java 17 or higher installed
- Maven 3.x installed
- Google Chrome browser installed

---

## 🚀 How to Run

### Option 1 — Run from Eclipse IDE

1. Clone this repository
   ```bash
   git clone https://github.com/deepaksekarqa/orangehrm-automation-testing.git
   ```
2. Open Eclipse → **File → Import → Maven → Existing Maven Project**
3. Right click `testng.xml` → **Run As → TestNG Suite**

### Option 2 — Run from Command Line (Maven)

```bash
# Clone the repo
git clone https://github.com/deepaksekarqa/orangehrm-automation-testing.git

# Navigate into project
cd orangehrm-automation-testing

# Run tests
mvn test
```

---

## 📊 Test Results

```
===============================================
OrangeHRM Test Suite
Total tests run: 7, Passes: 7, Failures: 0, Skips: 0
===============================================
```

---

## 🔑 Key Implementation Highlights

- **Data-Driven Testing** — Apache POI reads `.xlsx` file; @DataProvider feeds rows into test method at runtime
- **@DataProvider** — `testAddEmployee` runs 3 times automatically — once per employee row in Excel
- **Page Object Model** — Separate page class per module (Login, Dashboard, Employee, Logout)
- **Static WebDriver** — `driver` declared static in BaseClass — shared across all page class instances
- **No scope test** — TestNG dependency has no `<scope>test</scope>` so page classes in `src/main/java` can access it

---

## ✨ Framework Features

- Data-Driven Testing using Apache POI
- Reusable Page Object Model structure
- Maven Dependency Management
- Screenshot Capture Support
- TestNG Reporting
- Cross-browser scalability support
- Organized project architecture
- Easy maintenance and scalability

---

## ⚠️ Important Notes

- No real credentials are hardcoded — application uses OrangeHRM public demo credentials
- Employee names in `EmployeeData.xlsx` are fictional — created for test data purposes only
- SLF4J and CDP warnings in console are harmless

---

## 👨‍💻 Author

**Deepak S** — QA Engineer (Automation & Manual Testing)  
📍 Chennai, India  
🔗 [LinkedIn](https://www.linkedin.com/in/deepaksekar7/) | [GitHub](https://github.com/deepaksekarqa)

---


