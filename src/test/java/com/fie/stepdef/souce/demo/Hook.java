package com.fie.stepdef.souce.demo;

import com.fie.core_ui.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hook {
    @Before("@soucedemo")
    public void openBrowser(){
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @After()
    public void closeBrowser(){
        DriverManager.getInstance().quitDriver();
    }
}
