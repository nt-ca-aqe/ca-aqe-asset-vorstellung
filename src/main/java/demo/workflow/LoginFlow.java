package demo.workflow;

import demo.page.HasMainNavigation;
import demo.page.ShopSearchPage;


public class LoginFlow extends ShopFlow {

    LoginFlow(HasMainNavigation hasMainNavigation) {
        super(hasMainNavigation);
    }

    public ShopSearchPage login(String customerUsername, String customerPassword) {
        return navigationPage.navBar().navToLogin().setUsername(customerUsername).setPassword(customerPassword).clickLogin();
    }
}
