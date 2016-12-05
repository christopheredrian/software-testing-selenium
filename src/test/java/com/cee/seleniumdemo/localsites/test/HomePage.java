package com.cee.seleniumdemo.localsites.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author chris
 */
public class HomePage {

    @FindBy(id = "username")
    private WebElement username;

    /**
     * Returns username string
     *
     * @return String
     */
    public String getUsername() {
        return username.getText(); // Logged in As
    }

}
