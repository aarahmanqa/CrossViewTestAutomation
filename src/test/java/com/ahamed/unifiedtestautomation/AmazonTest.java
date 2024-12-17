package com.ahamed.unifiedtestautomation;

import amazon.MainPage;
import com.codeborne.selenide.Selenide;
import common.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class AmazonTest extends TestBase {

    @BeforeMethod
    public void beforeMethod() {
        open("https://amazon.in");
    }

    @Test
    public void amazonTestSearch() {
        List<String> productNames = new MainPage()
                .searchForProduct("Smart Phones")
                .chooseBrands("Samsung")
                .getProductNames();
        System.out.println(productNames);
    }
}
