package com.fie.core_ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static DriverManager instance = null;
    private WebDriver driver;

    private DriverManager(){}

    public static DriverManager getInstance(){
        if(instance == null){
            instance = new DriverManager();
        }
        return instance;
    }
    public WebDriver getDriver(){
        if(driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }
}
