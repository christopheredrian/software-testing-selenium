package com.cee.seleniumdemo.localsites.test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author chris
 */
public class SimpleCalculatorPage {

    @FindBy(name = "Input")
    private WebElement input;
    @FindBy(name = "plus")
    private WebElement plus;
    @FindBy(name = "minus")
    private WebElement minus;
    @FindBy(name = "times")
    private WebElement times;
    @FindBy(name = "div")
    private WebElement div;
    @FindBy(name = "clear")
    private WebElement clear;
    @FindBy(name = "calculate")
    private WebElement calculate;

    /**
     * Clears the input text
     */
    public void clearInput() {
        clear.click();
    }

    /**
     * Input string to input box
     *
     * @param keysToSend - string to input
     */
    public void inputCharacters(String keysToSend) {
        input.sendKeys(keysToSend);
    }

    /**
     * Returns current string inside the input box
     *
     * @return Stirng input
     */
    public String getInput() {
        return input.getAttribute("value");
    }

    /**
     * 
     */
    public void clickEquals() {
        calculate.click();
    }

    /**
     * Press the enter/return key
     */
    public void pressEnter() {
        input.sendKeys(Keys.ENTER);
    }

}
