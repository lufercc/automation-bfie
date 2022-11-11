package pageobject;

import core_ui.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    private WebDriver driver;

    static String ADD_PRODUCT_LOCATOR = "//div[contains(text(),'ITEM_NAME')]//ancestor::div[@class='inventory_item_description']//button[contains(@data-test, 'add')]";
    static String REMOVE_PRODUCT_LOCATOR = "//div[contains(text(),'ITEM_NAME')]//ancestor::div[@class='inventory_item_description']//button[contains(@data-test, 'remove')]";

    @FindBy(css = ".shopping_cart_badge")
    private WebElement quantity_items;


    public ProductPage(){
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }


    public void addProductToCart(String productName){
        String itemLocator = ADD_PRODUCT_LOCATOR.replace("ITEM_NAME", productName);
        driver.findElement(By.xpath(itemLocator)).click();
    }

    public void removeProductToCart(String productName){
        String itemLocator = REMOVE_PRODUCT_LOCATOR.replace("ITEM_NAME", productName);
        driver.findElement(By.xpath(itemLocator)).click();
    }

    public String getQuantityItems(){
        return quantity_items.getText();
    }
}
