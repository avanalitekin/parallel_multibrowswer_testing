package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class Test_Radio_Checkbox {
    public Test_Radio_Checkbox(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath="//*[@type='radio']")
    public List<WebElement> radio_buttons;

    @FindBy(xpath="//*[@type='checkbox']")
    public List<WebElement> check_boxes;
}
