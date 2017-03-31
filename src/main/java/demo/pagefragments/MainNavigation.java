package demo.pagefragments;

import demo.page.ShopBasketPage;
import demo.page.ShopLoginPage;

import info.novatec.testit.webtester.pagefragments.Link;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.LinkText;


public interface MainNavigation extends PageFragment {

    @IdentifyUsing(how = LinkText.class, value = "Login")
    Link login();

    @IdentifyUsing(how = LinkText.class, value = "Logout")
    Link logout();

    @IdentifyUsing(how = LinkText.class, value = "Your Basket")
    Link basket();

    default ShopLoginPage navToLogin() {
        login().click();
        return create(ShopLoginPage.class);
    }

    default ShopBasketPage navToBasket() {
        basket().click();
        return create(ShopBasketPage.class);
    }
}
