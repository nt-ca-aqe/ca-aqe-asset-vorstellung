package demo.workflow;

import demo.page.HasMainNavigation;
import demo.page.ShopBasketPage;
import demo.page.ShopSearchPage;

import info.novatec.testit.webtester.browser.Browser;


public class ShopFlow {

    HasMainNavigation navigationPage;

    ShopFlow(HasMainNavigation hasMainNavigation) {
        this.navigationPage = hasMainNavigation;
    }

    public BasketFlow navigateToBasket() {
        ShopBasketPage shopBasketPage = navigationPage.navBar().navToBasket();
        return from(shopBasketPage);
    }

    private BasketFlow from(ShopBasketPage shopBasketPage) {
        return new BasketFlow(shopBasketPage);
    }

    public static SearchFlow from(ShopSearchPage shopSearchPage) {
        return new SearchFlow(shopSearchPage);
    }

    public static LoginFlow loginFrom(HasMainNavigation hasMainNavigation) {
        return new LoginFlow(hasMainNavigation);
    }

    public static void logout(Browser browser) {
        HasMainNavigation hasMainNavigation = browser.create(HasMainNavigation.class);
        hasMainNavigation.navBar().logout().click();
    }
}
