package com.fie.stepdef.souce.demo;

import com.fie.pageobject.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
//import org.junit.Assert;

public class CartSteps {
    ProductPage productPage;

    public CartSteps(ProductPage productPage){
        this.productPage = productPage;
    }

    @And("I add to the cart item {string}")
    public void iAddToTheCartItem(String itemName) {
        productPage.addProductToCart(itemName);
    }

    @Then("I verify the cart has {int} item")
    public void iVerifyTheCartHasItem(int quantityItem) {
        String qItems = productPage.getQuantityItems();
        Assert.assertEquals(quantityItem, Integer.parseInt(qItems), "the quantity no match" );
//        Assert.assertEquals(quantityItem, Integer.parsent(qItems), 0.5, "the quantity no match");
    }
}
