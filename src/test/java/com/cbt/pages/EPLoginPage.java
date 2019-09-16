package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EPLoginPage {

    public EPLoginPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }
    @FindBy(xpath="//*[@formcontrolname='username']")
    public WebElement username;
        @FindBy(xpath="//*[@type='submit']")
    public WebElement login_button;
        @FindBy(xpath="//*[@formcontrolname='password']")
    public WebElement password;
}
