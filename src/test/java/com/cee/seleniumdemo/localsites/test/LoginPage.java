/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cee.seleniumdemo.localsites.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author chris
 */
public class LoginPage {

    @FindBy(name = "username")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "submit")
    private WebElement submit;
    @FindBy(id = "error-message")
    private WebElement errorMessage;

    /**
     * Set the username for the LoginPage
     *
     * @param text String
     */
    public void setUsername(String text) {
        username.sendKeys(text);
    }

    /**
     * Set password for the page
     *
     * @param text String
     */
    public void setPassword(String text) {
        password.sendKeys(text);
    }

    /**
     * Submits the form via the "Return/Enter" key
     */
    public void submit() {
        password.sendKeys(Keys.ENTER);
    }

    /**
     * Click the Login button
     */
    public void clickLogin() {
        submit.click();
    }
    
    /**
     * Send a tab key
     */
    public void typeTab(){
        username.sendKeys(Keys.TAB);
    }
    
    /**
     * Returns the error message text
     * @return String - Error Message
     */
    public String getErrorMessage(){
        return errorMessage.getText();
    }
    
    /**
     * Empty username and password fields
     */
    public void clearForms(){
        username.clear();
        password.clear();
    }
 
}
