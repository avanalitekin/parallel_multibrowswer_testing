package com.cbt.pages;

import com.cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Test_Page_Order {
    public Test_Page_Order(){        PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(linkText="Order")
    public WebElement oder_link;

    @FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement product_dropdown;
}
