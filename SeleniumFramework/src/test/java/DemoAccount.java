import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoAccount {

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @Ignore//ignora la prueba
    @Test
    public void test_capabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1700,800");
        options.addArguments("--headless");//corre la prueba sin abrir el browser
        //options.setHeadless(true); otra manera de correr la prueba sin abrir el browser
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        Assert.assertTrue(driver.findElement(By.id("content")).isDisplayed());

        //driver.manage().window().maximize();

        driver.close();
        driver.quit();
    }

    @Ignore
    @Test
    public void test_waits() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);//aplica a todas las pruebas

        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        driver.findElement(By.id("downloadButton")).click();

        boolean result = false;
        //manejo de excepciones
        try{
            result = wait.until(
                    ExpectedConditions.textToBe(
                            By.className("progress-label"), "Complete!"));
        }
        catch(WebDriverException exception){
            System.out.println("No funcionó");
        }

        driver.close();
        driver.quit();

    }

    @Ignore
    @Test
    public void drag_and_drop() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

        Actions actions = new Actions(driver);

        WebElement caja1 = driver.findElement(By.xpath("//span[text()='Draggable1']"));
        WebElement drop = driver.findElement(By.id("mydropzone"));
        Assert.assertTrue(drop.isDisplayed());

        Point punto = drop.getLocation();

        actions.dragAndDrop(caja1, drop).build().perform();
        actions.dragAndDropBy(caja1, punto.getX(), punto.getY()).release().build().perform();

        actions.perform();

        driver.close();
        driver.quit();
    }

}