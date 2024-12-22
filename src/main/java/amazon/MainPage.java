package amazon;

import amazon.mobile.MobileMainPage;
import amazon.web.WebMainPage;

public abstract class MainPage {

    public static MainPage init() {
        return TestContext.isMobile.get() ? new MobileMainPage() : new WebMainPage();
    }

    public abstract SearchResultsPage searchForProduct(String productName);

}
