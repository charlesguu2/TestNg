package class04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class loginTest {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void launchTheWebsite() {
        WebDriverManager.edgedriver().setup();
        driver= new EdgeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login%22");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void invalidCredentials() {
        //  username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
        //  password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("123456");
        //  login
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();
        //  invalid credentials
        WebElement invalidCreds = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String actualError = invalidCreds.getText();
        String expectedErrorMsg = "Invalid credentials";
        //   if we want use soft Assertion we call it from the class SoftAssert by declaring an instance
        SoftAssert soft = new SoftAssert();
        //    assertion
        soft.assertEquals(actualError,expectedErrorMsg);
        //    check if the webelement error message isDisplayed
        boolean isDisplayed = invalidCreds.isDisplayed();
        //   assertion
        soft.assertTrue(isDisplayed);
        //   assert all the assertions that have been made
        soft.assertAll();
    }



    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}
