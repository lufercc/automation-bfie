package com.fie.pageobject;

import com.fie.core_ui.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;
    static String REM_PRODUCT_LOCATOR = "//div[contains(text(),'ITEM_NAME')]//ancestor::div[@class='cart_item']//button";
    static String VALIDADOR_PRODUCT_LOCATOR = "//div[contains(text(),'ITEM_NAME')]";

    @FindBy(css = "#checkout")
    private WebElement checkoutBtn;

    @FindBy(css = "#first-name")
    private WebElement firstName;

    @FindBy(css = "#last-name")
    private WebElement lastName;

    @FindBy(css = "#postal-code")
    private WebElement postalCode;

    @FindBy(css = "#continue")
    private WebElement continueFinish;

    @FindBy(css = ".summary_subtotal_label")
    private WebElement subtotal;


    public CartPage() {
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public void removeProductToCart(String productName) {
        String itemLocator = REM_PRODUCT_LOCATOR.replace("ITEM_NAME", productName);
        driver.findElement(By.xpath(itemLocator)).click();
    }

    public boolean isProductInCart(String productName) {
        try {
            String itemLocator = VALIDADOR_PRODUCT_LOCATOR.replace("ITEM_NAME", productName);
            return driver.findElement(By.xpath(itemLocator)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void doCheckoutBtn(){
        checkoutBtn.click();
    }

    public void setForm () {
        firstName.sendKeys("Cintia");
        lastName.sendKeys("Melendrez");
        postalCode.sendKeys("123");
        continueFinish.click();
    }

    public String getSubtotal(){
        return subtotal.getText().replaceAll("[^\\.123456789]", "");
    }
}
