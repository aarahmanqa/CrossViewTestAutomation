package amazon.mobile;

import amazon.SearchResultsPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;

public class MobileSearchResultsPage extends SearchResultsPage {
    private final SelenideElement seFilters = $("button[id='s-all-filters-announce']");
    private final SelenideElement seBrandTab = $x("//div[contains(@class,'vtabs-tabs-container')]//div[@id='brandsRefinements']");
    private final ElementsCollection seBrandNames = $$x("//div[@id='brandsRefinements']//a[@data-csa-c-type='element']");
    private final SelenideElement seShowResultsInModal = $x("//a[contains(@class,'sf-show-results')]");

    public SearchResultsPage chooseBrands(String... brands) {
        seFilters.click();
        seBrandTab.click();

        Arrays.stream(brands)
                        .forEach(brand -> seBrandNames.filter(Condition.attribute("innerText", brand)).first().click());
        seShowResultsInModal.click();
        return this;
    }
}
