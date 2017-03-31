package demo.workflow;

import demo.page.HasMainNavigation;
import demo.page.ShopSearchPage;


public class LoginFlow extends ShopFlow{

    public ShopSearchPage login(String customerUsername, String customerPassword) {
        return navigation.navToLogin()
            .setUsername(customerUsername)
            .setPassword(customerPassword)
            .clickLogin();
    }

    public LoginFlow from(HasMainNavigation hasMainNavigation) {
        navigation = hasMainNavigation.navBar();
        return this;
    }
}
