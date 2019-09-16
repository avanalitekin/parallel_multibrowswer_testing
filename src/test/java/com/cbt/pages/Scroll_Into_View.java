package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Scroll_Into_View {
    public Scroll_Into_View(){
        PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath="//*[text()='Get to Know Us']")
    public WebElement get_to_know_us;

    @FindBy(xpath="//*[contains(text(),'deals under $25')]")
    public WebElement today_s_deals;

    @FindBy(xpath="//*[@id='mobile-menu']//*[text()='ABOUT']")
    public WebElement about_to_scroll;
}
