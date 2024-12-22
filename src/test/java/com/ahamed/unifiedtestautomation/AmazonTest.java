package com.ahamed.unifiedtestautomation;

import amazon.MainPage;
import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class AmazonTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        open("https://amazon.in");
    }

    @Test
    public void amazonTestSamsungSearch() {
        boolean productMatchingStatus = MainPage.init()
                .searchForProduct("Smart Phones")
                .chooseBrands("Samsung")
                .validateProductsAreFromSameBrand("Samsung");
        Assert.assertTrue(productMatchingStatus, "Product Name should contain Apple");
    }
}
