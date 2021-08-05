import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestAccount extends BaseClass{

    @Description("Validate a test login was successful")
    @Test
    public void Test_Login_Successfull(){
        String userName = "enrique.briceno.martinez@ucreativa.com";
        String password = "qwerty";

        //Go to login page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Login")).click();

        //Llenar formulario
        driver.findElement(By.name("email")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logOutButton.isDisplayed());

        driver.close();
        driver.quit();

    }

    @Description("Validate that the login is working with non valid credentials")
    @Test
    public void Test_Login_Unsuccessfull(){
        String userName = "enrique.briceno.martinez@ucreativa.com";
        String password = "qwerty113";
        String expectedMessage = "warning: no match for e-mail address and/or password.";

        //Go to login page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Login")).click();

        //Llenar formulario
        driver.findElement(By.name("email")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value='Login']")).click();

        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());

    }



}
