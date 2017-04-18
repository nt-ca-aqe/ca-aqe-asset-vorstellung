package demo.workflow;

import demo.page.HasMainNavigation;
import demo.page.ShopSearchPage;


public class LoginFlow extends ShopFlow {

    LoginFlow(HasMainNavigation hasMainNavigation) {
        super(hasMainNavigation);
    }

    public SearchResultFlow login(String customerUsername, String customerPassword) {
        ShopSearchPage shopSearchPage =
            navigationPage.navBar().navToLogin().setUsername(customerUsername).setPassword(customerPassword).clickLogin();
        return new SearchResultFlow(shopSearchPage);
    }
}
