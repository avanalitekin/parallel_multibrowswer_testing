package com.cbt.tests;

import com.cbt.utilities.Pages;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.*;

import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected Pages pages;
    private static String browser;
    private String huburl;

    static { Driver.huburl="http://35.182.169.110:4444/wd/hub";
        browser= Driver.Browsers.CHROME.getBrowser();}

//	protected WebDriver driver;
    // @prameters  --> means that this method will expect an argument
    // from the xml file
    // name of the parameter in the xlm file is browser
    // @optional --> we use this if we dont want to
    // provide paramters in xml all the time

    @Parameters("xmlbrowser")
    @BeforeMethod
    public void setUp(@Optional String xmlbrowser) {
        String browser="chrome";
        if(xmlbrowser!=null){
           browser=xmlbrowser;
        }
        Driver.getDriver(browser);
        Driver.getDriver().manage().window().maximize();
        try {
            Driver.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        } catch (TimeoutException timeoutException){
            Driver.getDriver().navigate().refresh();
        } catch (WebDriverException webDriverException){
            Driver.getDriver().navigate().refresh();
        }
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        pages=new Pages();
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().quit();
    }

    @AfterClass
    void terminate() {
        //Remove the ThreadLocalMap element
        Driver.closeDriver();
    }

}