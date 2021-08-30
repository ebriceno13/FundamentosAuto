package selenium;

import com.google.gson.JsonObject;
import dataProviders.ProductsProvider;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.ProductsData;

public class TestProductCurrency extends BaseClass{
/*
    Caso 3 del Proyecto
    Dado un json con productos y precios en distintas monedas.
    Ir a la página del producto.
    Verificar el precio de cada producto en las distintas monedas.
*/
    @Description("Verificar el precio de un producto en las distintas monedas.")
    @Test(dataProvider = "getProductsDataFromJson", dataProviderClass = ProductsProvider.class)
    public void Test_Currency(ProductsData testProducts) {

        /*
        System.out.println(testProducts.getDollarPrice());
        System.out.println(testProducts.getEuroPrice());
        System.out.println(testProducts.getPoundPrice());
        System.out.println(testProducts.getProductName());
         */
        String productName = testProducts.getProductName();
        String imageURL = testProducts.getImageURL();
        String dollarPrice = testProducts.getDollarPrice();
        String poundPrice = testProducts.getPoundPrice();
        String euroPrice = testProducts.getEuroPrice();
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(productName, Keys.ENTER);
        WebElement productLink = driver.findElement(By.linkText(productName));
        productLink.click();
        headerPage().clickCurrencyButton();
        headerPage().clickDollarCurrencyButton();
        String productDollarPrice = productPage().GetPrice();
        Assert.assertEquals(productDollarPrice, dollarPrice);
        headerPage().clickCurrencyButton();
        headerPage().clickEuroCurrencyButton();
        String productEuroPrice = productPage().GetPrice();
        Assert.assertEquals(productEuroPrice, euroPrice);
        headerPage().clickCurrencyButton();
        headerPage().clickPoundCurrencyButton();
        String productPoundPrice = productPage().GetPrice();
        Assert.assertEquals(productPoundPrice, poundPrice);
    }
}
