/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cee.seleniumdemo.localsites.test;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author chris
 */
public class SimpleCalculatorTest {

    private WebDriver driver;

    @Before
    public void setUpClass() {
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("http://localhost/software-engineering/simplecalculator/calculator.html");
    }

    @After
    public void tearDown() {
//        driver.quit();
    }

    /**
     * This method contains all the postiiv test cases
     */
    @Test
    public void positiveTestCases() {
        SimpleCalculatorPage page = PageFactory.initElements(driver,
                SimpleCalculatorPage.class);
        // Test Id 1. Add
        page.inputCharacters("5");
        page.inputCharacters("+");
        page.inputCharacters("6");
        page.clickEquals();
        assertEquals("There was an error on Add", "11", page.getInput());

        // Test Id 2. Subtract
        page.clearInput();
        page.inputCharacters("250");
        page.inputCharacters("-");
        page.inputCharacters("350");
        page.clickEquals();
        assertEquals("There was an error on Subtract", "-100", page.getInput());

        // Test Id 3. Multiply
        page.clearInput();
        page.inputCharacters("6");
        page.inputCharacters("*");
        page.inputCharacters("50");
        page.clickEquals();
        assertEquals("There was an error on Subtract", "300", page.getInput());

        // Test Id 4. Divide
        page.clearInput();
        page.inputCharacters("15");
        page.inputCharacters("/");
        page.inputCharacters("3.2");
        page.clickEquals();
        assertEquals("There was an error on Subtract", "4.6875", page.getInput());

        // Test Id 5. Decimal Values
        page.clearInput();
        page.inputCharacters("15.2");
        page.inputCharacters("*");
        page.inputCharacters("15.5");
        page.clickEquals();
        assertEquals("There was an error on Subtract", "235.6", page.getInput());

        // Test Id 6. Using enter/return key
        page.clearInput();
        page.inputCharacters("15");
        page.inputCharacters("+");
        page.inputCharacters("25");
        page.pressEnter();
        assertEquals("There was an error on Subtract", "40", page.getInput());

        // Test Id 7. clearButton
        page.clearInput();
        assertEquals("There was an error on Subtract", "", page.getInput());

    }

    /**
     * This method contains all the negative test cases
     */
    @Test
    public void negativeTestCases() {
    }

}
