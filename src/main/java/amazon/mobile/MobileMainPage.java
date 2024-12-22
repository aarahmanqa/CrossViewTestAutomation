package amazon.mobile;

import amazon.MainPage;
import amazon.SearchResultsPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MobileMainPage extends MainPage {

    private final SelenideElement searchField = $("input[role='searchbox']");

    public SearchResultsPage searchForProduct(String productName) {
        searchField
                .should(Condition.appear)
                .setValue(productName)
                .pressEnter();
        return SearchResultsPage.init();
    }
}
