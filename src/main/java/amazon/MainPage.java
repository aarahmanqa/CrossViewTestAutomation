package amazon;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement searchField = $(By.id("twotabsearchtextbox"));

    public SearchResultsPage searchForProduct(String productName) {
        searchField
                .should(Condition.appear)
                .setValue(productName)
                .pressEnter();
        return new SearchResultsPage();
    }
}
