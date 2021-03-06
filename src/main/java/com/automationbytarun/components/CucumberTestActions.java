package com.automationbytarun.components;

import com.automationbytarun.browser.DriverManager;
import com.automationbytarun.properties.PropertiesLoader;
import com.automationbytarun.properties.PropertiesValidator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class CucumberTestActions {

    public ThreadLocal<WebDriver> driver= new ThreadLocal<>();// to run test cases in parallel, used instead of below
    //public WebDriver driver;
    public DriverManager driverManager;
    public BaseActions pageActions;

    @BeforeSuite
    public void setUpConfigurations() throws Exception {
        PropertiesLoader.initializeProperties();
        PropertiesValidator.validateConfigurations();
        driverManager = new DriverManager();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser() throws Exception {
        driverManager.loadDriver();
        driver.set(driverManager.getDriver());// used to run multiple test cases
//        driver = driverManager.getDriver();
        pageActions = new BaseActions(driver.get());
        pageActions.launchUrl(PropertiesLoader.appUrl);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() throws Exception {
        driverManager.closeBrowser();
    }

    @AfterSuite
    public void tearDownObjects() throws Exception {
        PropertiesLoader.configProperties = null;
    }

}
