package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HardAssertions {

     WebDriver driver;
     @BeforeMethod(alwaysRun = true)
     public void launchTheWebsite() {
         WebDriverManager.edgedriver().setup();
         driver= new EdgeDriver();
         driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login%22");
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.manage().window().maximize();
     }

     @Test(groups = {"regression"})
    public void invalidCredentials() {
     //  username
         WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
         userName.sendKeys("admin");
     //  password
         WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
         password.sendKeys("Hum");
     //  login
         WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
         logIn.click();
     //  invalid credentials
         WebElement invalidCreds = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
         String actualError = invalidCreds.getText();
         String expectedErrorMsg = "Invalid credentials";
     //  Assertion
         Assert.assertEquals(actualError,expectedErrorMsg);
     //   confirm that the error message is displayed
         boolean isDisplayed = invalidCreds.isDisplayed();
     //    assertion will pass if the parameter boolean is "true" will fail if the parameter boolean is false
         Assert.assertTrue(isDisplayed);

     }

     @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
         driver.quit();

     }
}
