package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class View_All_Orders {
    public View_All_Orders(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(linkText = "View all orders")
    public WebElement view_all_orders_link;

    @FindBy(xpath="//table[@class='SampleTable']")
    public WebElement web_table;
}
