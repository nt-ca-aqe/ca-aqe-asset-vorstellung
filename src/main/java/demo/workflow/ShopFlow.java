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

    public static BasketFlow from(ShopBasketPage shopBasketPage) {
        return new BasketFlow(shopBasketPage);
    }

    public static SearchResultFlow from(ShopSearchPage shopSearchPage) {
        return new SearchResultFlow(shopSearchPage);
    }

    public static LoginFlow loginFrom(HasMainNavigation hasMainNavigation) {
        return new LoginFlow(hasMainNavigation);
    }

    public static void logout(Browser browser) {
        HasMainNavigation hasMainNavigation = browser.create(HasMainNavigation.class);
        hasMainNavigation.navBar().logout().click();
    }

    public BasketFlow navigateToBasket() {
        ShopBasketPage shopBasketPage = navigationPage.navBar().navToBasket();
        return from(shopBasketPage);
    }

    public SearchResultFlow searchFor(String searchString) {
        ShopSearchPage shopSearchPage = navigationPage.navBar().searchTerm(searchString).search();
        return new SearchResultFlow(shopSearchPage);
    }
}
