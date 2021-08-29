package selenium;

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
    Dado un json con productos y precios en distintas monedas.
    Ir a la página del producto.
    Verificar el precio de cada producto en las distintas monedas.
*/
    @Description("Verificar el precio de un producto en las distintas monedas.")
    @Test(dataProvider = "getProductsCurrencyData", dataProviderClass = ProductsProvider.class)
    public void Test_Currency(ProductsData testProducts){

        String productName = testProducts.getProductName();
        String imageURL = testProducts.getImageURL();
        String dollarPrice = testProducts.getDollarPrice();
        String poundPrice = testProducts.getPoundPrice();
        String euroPrice = testProducts.getEuroPrice();
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(productName, Keys.ENTER);
        WebElement productLink = driver.findElement(By.linkText(productName));
        productLink.click();
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
