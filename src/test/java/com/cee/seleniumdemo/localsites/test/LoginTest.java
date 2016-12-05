package com.cee.seleniumdemo.localsites.test;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author chris
 */
public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("http://localhost/software-engineering/loginregister/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * This will test the Login Page for the positive test case. Test Case:
     * Enter a valid username and valid password. Use tab to navigate to
     * password Use return key/button to submit.
     *
     */
    @Test
    public void positiveTestCases() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUsername("chrisesp@gmail.com"); // Valid
        loginPage.typeTab();
        loginPage.setPassword("123456"); // Enter Valid password
        loginPage.submit(); // Using Return/Enter key
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        /* Wait for next page to load */
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until((WebDriver d) -> {
            return d.getTitle();
        });
        assertEquals("Tile not expected", "Homepage", driver.getTitle());
        assertEquals("Username/email not expected",
                "Logged in as: chrisesp@gmail.com", home.getUsername());
    }

    /**
     * This will test the Login Page for all the negative test cases.
     *
     */
    @Test
    public synchronized void negativeTestCases() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.clickLogin();
        // Test Id: 1. valid email, invalid password
        loginPage.setUsername("chrisesp@gmail.com");
        loginPage.setPassword("123453");
        loginPage.clickLogin();
        assertEquals("Invalid message(Test id: 1)", "Incorrect password.",
                loginPage.getErrorMessage());
        loginPage.clearForms();
        // Test Id: 2 valid password, invalid email
        loginPage.setUsername("c22@gmail.com");
        loginPage.setPassword("123456");
        loginPage.clickLogin();
        assertEquals("Invalid message(Test id: 2)", "User is not registered.",
                loginPage.getErrorMessage());
        loginPage.clearForms();
        // Test Id 3. empty email and password, press enter
        loginPage.submit();
        assertEquals("Invalid message(Test id: 3)", "Username is required!",
                loginPage.getErrorMessage());
        // Test Id 4. Username blank, valid password, click login
        loginPage.clearForms();
        loginPage.setPassword("123456");
        loginPage.clickLogin();
        assertEquals("Invalid message(Test id: 4)", "Username is required!",
                loginPage.getErrorMessage());
        // Test Id 5. Password blank, enter username, click login
        loginPage.clearForms();
        loginPage.setUsername("callie@gmail.com");
        loginPage.clickLogin();
        assertEquals("Invalid message(Test id: 5)", "Password is required!",
                loginPage.getErrorMessage());
        // Test Id 6. Wrong username and password
        loginPage.clearForms();
        loginPage.setUsername("c22@gmail.com");
        loginPage.setPassword("1123");
        loginPage.clickLogin();
        assertEquals("Invalid message(Test id: 6)", "User is not registered.",
                loginPage.getErrorMessage());

    }
}
