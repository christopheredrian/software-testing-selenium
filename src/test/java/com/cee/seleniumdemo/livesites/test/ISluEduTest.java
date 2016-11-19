/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cee.seleniumdemo.livesites.test;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Test cases for i.slu.edu.ph
 *
 * @author chris
 */
@Ignore
public class ISluEduTest {

    private WebDriver driver;
    private WebElement buttonLogin;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("http://i.slu.edu.ph");
        buttonLogin = driver.findElement(By.name("buttonlogin"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    /**
     * This test is for both invalid username and password
     */
    @Test
    public void testIncorrectLogin() {
        WebElement idNumber = driver.findElement(By.name("textusername"));
        idNumber.sendKeys("2343212"); // Random id number
        WebElement password = driver.findElement(By.name("textpassword"));
        password.sendKeys("12345653");
        buttonLogin.click();
        //        boolean isFound = new WebDriverWait(driver, 15).until(
        //                (ExpectedCondition<Boolean>) (WebDriver input)
        //                -> driver.findElement(
        //                        By.className("mws-form-message")).isEnabled());
        //        assertTrue("Error message is not present", isFound);
        WebElement errorMessage = driver.findElement(By.className("mws-form-message"));
        assertEquals("Error message is not present", "User is not registered.", errorMessage.getText());

    }

    /**
     * This test has the username valid but an empty parameter for the password
     */
    @Test
    public void noPasswordTest() {
        WebElement idNumber = driver.findElement(By.name("textusername"));
        idNumber.sendKeys("2121920"); // Valid id number
        buttonLogin.click();
        WebElement errorMessage = driver.findElement(By.className("mws-form-message"));
        assertEquals("Error message is not present", "Password is Required!", errorMessage.getText());
    }

    /**
     * This test is for empty arguments or empty username field
     */
    @Test
    public void noUsername() {
        buttonLogin.click();
        WebElement errorMessage = driver.findElement(By.className("mws-form-message"));
        assertEquals("Error message is not present", "Username is Required!", errorMessage.getText());
    }

    /**
     * This test is for the display of the User Guidelines
     */
    @Test
    public void userGuidelinesTest() {
        WebElement userGuidelinesLink = driver.findElement(By.linkText("User Guidelines"));
        userGuidelinesLink.click();
        WebElement loginnote = driver.findElement(By.id("login-note"));
        assertTrue("User Guidelines note not shown", loginnote.isDisplayed());
    }
}
