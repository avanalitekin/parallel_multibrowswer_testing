package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wait_Visibility_Clickability {
    public Wait_Visibility_Clickability (){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="//button[contains(text(),'Click me')]")
    public WebElement click_me_to_start;

    @FindBy(xpath="//*[text()='WebDriver']")
    public WebElement webdriver_text;
}
