package com.cbt.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

//	protected WebDriver driver;
    // @prameters  --> means that this method will expect an argument
    // from the xml file
    // name of the parameter in the xlm file is browser
    // @optional --> we use this if we dont want to
    // provide paramters in xml all the time

    @Parameters("xmlbrowser")
    @BeforeMethod
    public void setUp(@Optional String xmlbrowser) {
        String huburl="http://35.182.169.110:4444/wd/hub";
        String browser="chrome";
        if(xmlbrowser!=null){
           browser=xmlbrowser;
        }
        Driver.getDriver(browser,huburl);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
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






