package com.cbt.pages;


import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Double_Click_Rigth_Click {
    public Double_Click_Rigth_Click(){
        PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath="//*[text()='right click me']")
    public WebElement right_click;

    @FindBy(xpath="//*[text()='Double-Click Me To See Alert']")
    public WebElement double_click;
}
