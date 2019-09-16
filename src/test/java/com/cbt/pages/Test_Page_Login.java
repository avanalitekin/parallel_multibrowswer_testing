package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test_Page_Login {
    public Test_Page_Login() {
        PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(id="ctl00_MainContent_username")
    public WebElement username_box;

    @FindBy(id="ctl00_MainContent_password")
    public WebElement password_box;

    @FindBy(id="ctl00_MainContent_login_button")
    public WebElement login_button;

    public void login(){
        username_box.sendKeys("Tester");
        password_box.sendKeys("test");
        login_button.click();
    }

}