package com.cbt.tests.others;

import com.cbt.tests.TestBase;
import com.cbt.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.cbt.utilities.Driver.getDriver;

/**
 * Created by ONUR on 03.12.2016.
 */
public class SecondTest extends TestBase {

    @Test
    public void GOOGLE4() {
        System.out.println("Google4 Test Started! " + "Thread Id: " +  Thread.currentThread().getId());
        getDriver().navigate().to("https://www.google.com");
        System.out.println("Google4 Test's Page title is: " +  getDriver().getTitle() +" " + "Thread Id: "+ Thread.currentThread().getId());
        Assert.assertEquals(getDriver().getTitle(), "Google");
        System.out.println("Google4 Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());
    }

    @Test
    public void YANDEX() {
        System.out.println("Yandex Test Started! " + "Thread Id: " +  Thread.currentThread().getId());
        getDriver().navigate().to("http://www.yandex.com");
        System.out.println("Yandex Test's Page title is: " + getDriver().getTitle() +" " + "Thread Id: " + Thread.currentThread().getId());
        Assert.assertEquals(getDriver().getTitle(), "Yandex");
        System.out.println("Yandex Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());
    }
}