package amazon.web;

import amazon.SearchResultsPage;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class WebSearchResultsPage extends SearchResultsPage {
    private final SelenideElement seSeeMoreLinkInBrands = $x("//a[@aria-label='See more, Brands']");
    private final List<SelenideElement> seBrandsList = $$x("//div[@id='brandsRefinements']//li/span");
    private final List<SelenideElement> seProductsList = $$x("//div[@data-cy='title-recipe']");

    public SearchResultsPage chooseBrands(String... brands) {
        seSeeMoreLinkInBrands.click();

        for (String brand : brands) {
            for(SelenideElement element : seBrandsList) {
                element.should(appear);
                if (element.text().equalsIgnoreCase(brand)) {
                    element.click();
                    break;
                }
            }
        }
        return this;
    }

    public List<String> validateProductsAreFromSameBrand() {
        return seProductsList.stream()
                .map(selenideElement -> selenideElement.should(appear))
                .map(SelenideElement::text)
                .collect(Collectors.toList());
    }
}
