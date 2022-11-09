import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.sql.SQLOutput;

public class Seleniumhook {
    WebDriver driver;


    @Test
    public void souceDemo() {
        System.out.println("TEST2");
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
    }

    @Test
    public void souceDemoProblemUser() {
        System.out.println("TEST1");
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("problem_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
    }

    @AfterMethod
    public void otherafter(){
        System.out.println("AFTER METH");
        driver.quit();
    }

    @BeforeMethod
    public void setupDriver(){
        System.out.println("BEFORE CLASS");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

}
