package com.fie.stepdef;

import com.fie.core_ui.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class HooksSouceDemo {

    @Before("@soucedemo")
    public void openBrowser(){
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Before("@openYoutube")
    public void openYoutube(){
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.youtube.com/");
    }

    @Before("@openGoogle")
    public void openGoogle(){
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.google.com/");
    }
}
