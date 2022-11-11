package pageobject;

import core_ui.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(css = "#user-name")
    private WebElement userInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = "#login-button")
    private WebElement loginButton;


    public LoginPage(){
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }


    public void login(String user, String password){
        openBrowser();
        userInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    private void openBrowser(){
        driver.get("https://www.saucedemo.com/");
    }
}
