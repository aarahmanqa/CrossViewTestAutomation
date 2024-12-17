package common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.qameta.allure.selenide.AllureSelenide;

public class TestBase {
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .includeSelenideSteps(true));
    }
}
