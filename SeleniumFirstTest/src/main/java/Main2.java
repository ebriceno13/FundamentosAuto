import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main2 {

    public static void main(String[] args) {
        String pathToDriver = Main.class.getResource("/chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com");

        WebElement emailElement = driver.findElement(By.name("search"));
        emailElement.sendKeys("macbook");

        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();

        driver.findElement(By.xpath("//div[contains(@class, 'caption')]/h4/a[1]")).click();
        driver.findElement(By.id("button-cart")).click();

        //driver.close();
        //driver.quit();
    }
}
