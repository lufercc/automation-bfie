import core_ui.DriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageobject.CartPage;
import pageobject.LoginPage;
import pageobject.ProductPage;

import java.text.DecimalFormat;

public class PageObjectTest {

    @AfterMethod
    public void otherafter() {
        System.out.println("AFTER METH");
        DriverManager.getInstance().quitDriver();
    }

    @Test
    public void souceDemoAddItemToCart() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addProductToCart("Sauce Labs Onesie");
        productPage.addProductToCart("Sauce Labs Bike Light");
        productPage.addProductToCart("Fleece Jacket");
        productPage.removeProductToCart("Sauce Labs Onesie");
    }

    @Test
    public void addAndRemoveProduct() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addProductToCart("Sauce Labs Onesie");
        productPage.addProductToCart("Sauce Labs Bike Light");
        productPage.addProductToCart("Fleece Jacket");
        String current = productPage.getQuantityItems();
        assert current.equalsIgnoreCase("3");
        productPage.removeProductToCart("Sauce Labs Onesie");
        String current2 = productPage.getQuantityItems();
        assert current2.equalsIgnoreCase("2");
    }

    @Test
    public void checkoutProducts() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();
        loginPage.login("standard_user", "secret_sauce");
        String onesiePrice = productPage.getPriceProduct("Sauce Labs Onesie");
        productPage.addProductToCart("Sauce Labs Onesie");
        String jacketPrice = productPage.getPriceProduct("Fleece Jacket");
        productPage.addProductToCart("Fleece Jacket");
        productPage.goCartPage();
        cartPage.doCheckoutBtn();
        cartPage.setForm();
        String subtotal = cartPage.getSubtotal();

        //DecimalFormat df = new DecimalFormat("0.00");
        float total = Float.parseFloat(onesiePrice) + Float.parseFloat(jacketPrice);
        float subtotalFloat = Float.parseFloat(subtotal);

        Assert.assertEquals(total, subtotalFloat,0.004);
        //assert subtotal.substring(0,2).compareTo(total);
    }

}
