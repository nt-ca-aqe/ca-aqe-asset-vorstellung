package demo.pagefragments;

import demo.page.ShopBasketPage;
import demo.page.ShopLoginPage;
import demo.page.ShopSearchPage;

import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.Link;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.TextField;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.identification.producers.LinkText;
import info.novatec.testit.webtester.pagefragments.identification.producers.TagName;


public interface MainNavigation extends PageFragment {

    @IdentifyUsing(how = LinkText.class, value = "Login")
    Link login();

    @IdentifyUsing(how = LinkText.class, value = "Logout")
    Link logout();

    @IdentifyUsing(how = LinkText.class, value = "Your Basket")
    Link basket();

    @IdentifyUsing(how = TagName.class, value = "input")
    TextField searchQuery();

    @IdentifyUsing("#searchButton")
    Button searchButton();

    default ShopLoginPage navToLogin() {
        login().click();
        return create(ShopLoginPage.class);
    }

    default ShopBasketPage navToBasket() {
        basket().click();
        return create(ShopBasketPage.class);
    }

    default MainNavigation searchTerm(String searchString) {
        searchQuery().setText(searchString);
        return this;
    }

    default ShopSearchPage search() {
        searchButton().click();
        return create(ShopSearchPage.class);
    }
}
