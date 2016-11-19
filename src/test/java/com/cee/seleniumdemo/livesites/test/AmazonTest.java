package com.cee.seleniumdemo.livesites.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Test for amazon.com
 * @author chris
 */
@Ignore
public class AmazonTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // load Firefox Driver
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        //Set implicit time out to find WebElements
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // set page load time out
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //maximize the browser window
        // driver.manage().window().fullscreen();
        // get website url
        driver.get("http://www.amazon.com");
    }

    @After
    public void tearDown() {
        // close the browser
        driver.quit();
    }

    /**
     * This test will search for the first returned "Software Engineering"
     * result on amazon.com
     */
    @Test
    public void searchBook() {
        // find the search drop down as a WebElement
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        // get Select from the WebElement
        Select searchDropdownBox = new Select(dropdown);
        // select option from the search dropdown
        searchDropdownBox.selectByVisibleText("Books");
        // find the search text box
        WebElement twotabsearchtextbox = driver.findElement(By.id("twotabsearchtextbox"));
        // type into search text box
        twotabsearchtextbox.sendKeys("Software engineering");
        // find the go button
        WebElement submit = driver.findElement(By.className("nav-input"));
        // click the go button
        submit.click();
        // Wait for the resutlsCol div for 10 seconds 
        boolean isFound = new WebDriverWait(driver, 10).until(
                (ExpectedCondition<Boolean>) (WebDriver input) -> driver.findElement(
                        By.id("resultsCol")
                ).isEnabled());
        // assert that the page loaded
        assertTrue("the results page did not load", isFound);
        // find the book title by the anchor text
        WebElement bookTitle = driver.findElement(By.
                linkText("Beginning Software Engineering"));
        assertEquals("The first book was not correct",
                "Beginning Software Engineering", bookTitle.getText());
    }

}
