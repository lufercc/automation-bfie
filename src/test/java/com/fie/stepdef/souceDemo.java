package com.fie.stepdef;

import com.fie.pageobject.LoginPage;
import com.fie.pageobject.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class souceDemo {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Given("I login user {string} with PW {string}")
    public void iLoginUSRWithPW(String usr, String pwd) {
        loginPage.login(usr, pwd);
    }

    @Then("I verify I logged PO")
    public void iVerifyILoggedPO() {
        boolean result = productPage.isBannerDisplayed();
        Assert.assertTrue(result, "Login was not success *****");
    }
}
