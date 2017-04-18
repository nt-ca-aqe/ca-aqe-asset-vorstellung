package demo.page;

import demo.page.shared.HasMainNavigation;

import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.PasswordField;
import info.novatec.testit.webtester.pagefragments.TextField;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pages.Page;


public interface ShopLoginPage extends Page, HasMainNavigation {

    @IdentifyUsing("#userEmail")
    TextField username();

    @IdentifyUsing("#userPassword")
    PasswordField password();

    @IdentifyUsing("#loginButton")
    Button loginButton();

    default ShopLoginPage setUsername(String customerUsername) {
        username().setText(customerUsername);
        return this;
    }

    default ShopLoginPage setPassword(String customerPassword) {
        password().setText(customerPassword);
        return this;
    }

    default ShopSearchPage clickLogin() {
        loginButton().click();
        return create(ShopSearchPage.class);
    }
}
