package amazon;

import amazon.mobile.MobileSearchResultsPage;
import amazon.web.WebSearchResultsPage;
import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$$x;

public abstract class SearchResultsPage {
    protected final List<SelenideElement> seProductsList = $$x("//div[@data-cy='title-recipe']");

    public static SearchResultsPage init() {
        return TestContext.isMobile.get() ? new MobileSearchResultsPage() : new WebSearchResultsPage();
    }

    public abstract SearchResultsPage chooseBrands(String... brands);

    public boolean validateProductsAreFromSameBrand(String...brands) {
        List<String> productNames = seProductsList.stream()
                .map(selenideElement -> selenideElement.should(appear))
                .map(SelenideElement::text)
                .toList();
        return productNames.stream()
                .allMatch(productName -> Arrays.stream(brands).anyMatch(productName::contains));
    }
}
