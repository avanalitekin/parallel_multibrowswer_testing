package com.cbt.tests.login;

import static org.testng.Assert.assertEquals;

import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.cbt.pages.AllOrdersPage;
import com.cbt.pages.LoginPage;
import com.cbt.tests.TestBase;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;

public class LoginTests extends TestBase {

	@Test()
	public void positiveloginTest() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		Driver.getDriver().findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();
		BrowserUtils.waitFor(2);
	}

	@Test(priority = 2)
	public void positiveLoginUsingPOM() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		LoginPage loginPage = new LoginPage();
		loginPage.userName.sendKeys(ConfigurationReader.getProperty("username"));
		loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
		loginPage.loginButton.click();

	}

//	@Ignore
	@Test(priority = 1, groups = "functest")
	public void invalidUsernameTest() {
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		LoginPage loginPage = new LoginPage();
		loginPage.userName.sendKeys("invalid");
		loginPage.password.sendKeys("test");
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].value='invalid';", loginPage.userName);
//		js.executeScript("arguments[0].value='test';", loginPage.password);
		loginPage.loginButton.click();
		String errMsg = loginPage.invalidUserNameErrMsg.getText();

		assertEquals(errMsg, "Invalid Login or Password.");
	}

}
