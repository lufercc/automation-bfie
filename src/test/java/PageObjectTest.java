import core_ui.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.LoginPage;
import pageobject.ProductPage;

public class PageObjectTest {

    @AfterMethod
    public void otherafter(){
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
}
