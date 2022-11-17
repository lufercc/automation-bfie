package com.fie.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MyStepdefs {
    @io.cucumber.java.en.Given("^Hello \"([^\"]*)\"$")
    public void hello(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("***********Hola *********** " + name );
    }

    WebDriver driver;

    @Given("I open Chome")
    public void iOpenChome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @And("I go to {string}")
    public void iGoTo(String url) {
        driver.get(url);
    }

    @When("I put userName {string}")
    public void iPutUserName(String user) {
        driver.findElement(By.cssSelector("#user-name")).sendKeys(user);
    }

    @And("I put password {string}")
    public void iPutPassword(String pasword) {
        driver.findElement(By.cssSelector("#password")).sendKeys(pasword);
        driver.findElement(By.cssSelector("#login-button")).click();
    }

    @Then("I verify I logged")
    public void iVerifyILogged() {
        boolean result = driver.findElement(By.cssSelector(".app_logo")).isDisplayed();
        Assert.assertTrue(result, "Baner not Show");
    }


    @Given("TEStetste {string}")
    public void testetste(String arg0) {
    }
}
