package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private Driver() {}
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver(String browser ,String huburl) {
            browser = browser == null ? "chrome" : browser;
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("start-maximized");
                    options.addArguments("test-type");
                    options.addArguments("allow-running-insecure-content");
                    options.addArguments("disable-extensions");
                    options.addArguments("--ignore-certificate-errors");
                    options.addArguments("test-type=browser");
                    options.addArguments("disable-infobars");
                    driver.set(new ChromeDriver());
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions heaadless_options = new ChromeOptions();
                    heaadless_options.addArguments("--headless");
                    driver.set(new ChromeDriver(heaadless_options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "ie":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not  support the requested browser");
                    } else {
                        WebDriverManager.iedriver().setup();
                        driver.set(new InternetExplorerDriver());
                        break;

                    }
                case "edge":
                    if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your operating system does not  support the requested browser");
                    } else {
                        WebDriverManager.edgedriver().setup();
                        driver.set(new EdgeDriver());
                        break;
                    }
                case "safari":
                    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your operating system does not  support the  requested browswer");
                    } else {
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        driver.set(new SafariDriver());
                        break;
                    }
                case "remotechrome":
                    DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
                    capabilities.setPlatform(Platform.ANY);
                    try {
                        driver.set(new RemoteWebDriver(new URL(huburl), capabilities));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "remotefirefox":
                    DesiredCapabilities firefoxcapabilities = new DesiredCapabilities().firefox();
                    firefoxcapabilities.setPlatform(Platform.ANY);
                    try {
                        driver.set(new RemoteWebDriver(new URL(huburl), firefoxcapabilities));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "remoteie":
                    DesiredCapabilities iecapabilities = new DesiredCapabilities().internetExplorer();
                    iecapabilities.setPlatform(Platform.ANY);
                    try {
                        driver.set(new RemoteWebDriver(new URL(huburl), iecapabilities));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        return driver.get();
    }

    public static WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }
    /**
     * Call this method to terminate the WebDriver instance as below in your class using WebDriver instance.
     * BaseDriver.closeDriver();
     */
    public static void closeDriver() {
        driver.remove();
    }

}
