package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WayToGo {
    public WayToGo(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//*[@title='User ID']")
    public WebElement user_name_box;
    @FindBy(xpath ="//*[@id='login_submit']" )
    public WebElement login_botton;
    @FindBy(xpath="//*[@id='password']")
    public WebElement password;

    @FindBy(id="moreInformationDropdownSpan")
    public WebElement details_link;

    @FindBy(id="invalidcert_continue")
    public WebElement continue_link;

}
