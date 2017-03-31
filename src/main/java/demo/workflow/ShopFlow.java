package demo.workflow;

import demo.page.ShopBasketPage;
import demo.pagefragments.MainNavigation;


public class ShopFlow {

    protected MainNavigation navigation;

    public ShopBasketPage navigateTo(Class<ShopBasketPage> basketPageClass) {
        return navigation.navToBasket();
    }
}
