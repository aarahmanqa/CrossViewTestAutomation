package common;

import amazon.TestContext;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.Map;

public class TestBase {
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"Headless"})
    public void beforeSuite(@Optional String headless) {
        Configuration.headless = Boolean.parseBoolean(headless);
        Configuration.timeout = 50000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .includeSelenideSteps(true));
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"Device"})
    public void beforeMethod(@Optional String device) {
        if (device == null) {
            device = "Desktop";
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        switch (device) {
            case "Desktop":
                TestContext.isMobile.set(false);
                break;
            case "iPhone X":
                chromeOptions.setExperimentalOption("mobileEmulation", Map.of("deviceName", device));
                TestContext.isMobile.set(true);
                break;
        }
        Configuration.browserCapabilities = chromeOptions;
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        Selenide.closeWebDriver();
    }
}
