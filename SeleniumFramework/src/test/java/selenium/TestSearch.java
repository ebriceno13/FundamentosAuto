package selenium;

import PageObjects.BaseClass;
import dataProviders.SearchProvider;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.SearchData;


public class TestSearch extends BaseClass {



    public int getResults(){
        return driver.findElements(By.cssSelector(".product-thumb")).size();
    }

    private String[] testData;

    @Test
    @Parameters({"searchCriteria", "expectedResult"})
    public void Validate_Search(@Optional("macbook") String searchCriteria, @Optional("3") String expectedResult){
        int results = Integer.parseInt(expectedResult);

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));

        //Assert.assertEquals(results.size(), expectedResult,
        //        String.format("Expected %s results, but got %s",results.size()));

        Assert.assertEquals(getResults(), results,
                "Expecting " + expectedResult + " results, but got " + getResults());
    }

    @Test
    public void Test_Empty_Results(){
        String searchCriteria = "Star Wars";
        int expectedResult = 0;

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(searchCriteria, Keys.ENTER);

        //Assert.assertTrue(driver.getCurrentUrl().contains("search="+searchCriteria));
        //List<WebElement> results = driver.findElements(By.cssSelector(".product-thumb"));

        //Assert.assertEquals(results.size(), expectedResult,
        //        String.format("Expected %s results, but got %s",results.size()));

        Assert.assertEquals(getResults(), expectedResult,
                "Expecting " + expectedResult + " results, but got " + getResults());

    }

    @Test(dataProvider = "searchEntries", dataProviderClass = SearchProvider.class)
    public void Test_Search_WithData(SearchData testData){
        String errorMessage = "There is no product that matches the search criteria.";
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(testData.getSearchCriteria());

        driver.findElement(By.xpath("//div[@id='search]/span/button")).click();

        if(testData.getExpectedResults() > 0){
            Assert.assertEquals(getResults(), testData.getExpectedResults());
        }else{
            WebElement content = driver.findElement(By.id("content"));
            String actualErrorMessage = content.getAttribute("innerHTML");
            Assert.assertTrue(actualErrorMessage.contains(errorMessage));
        }
        this.testData = new String[]{"",""};
        this.testData[0] = testData.getSearchCriteria();
        this.testData[1] = "" + testData.getExpectedResults();

        //Assert.assertEquals(getResults(), testData.getExpectedResults());
    }
    /*
    @Attachment(value = "TestData", type = "String")
    public byte[] PrintTestData() {
        try {
            return "Search Criteria used: " + testData[0] + ", Expected results: " + testData[1];
        } catch (ExpectedCondition ex) {

        }
    }*/

    @DataProvider(name = "searchEntries")
    public Object[][] methodNumeroProvider(){
        return new Object[][]{
                {"macbook", 3},
                {"star wars", 0}
        };
    }

}
