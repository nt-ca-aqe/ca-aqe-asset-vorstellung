package info.novatec.testit.webtesterdemo.junit5;

import static info.novatec.testit.webtester.support.assertj.WebTesterAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demo.page.ShopBasketPage;
import demo.page.ShopSearchPage;
import demo.workflow.LoginFlow;
import demo.workflow.ShoppingFlow;

import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.factories.ChromeFactory;
import info.novatec.testit.webtester.junit5.EnableWebTesterExtensions;
import info.novatec.testit.webtester.junit5.extensions.browsers.CreateBrowsersUsing;
import info.novatec.testit.webtester.junit5.extensions.browsers.EntryPoint;
import info.novatec.testit.webtester.junit5.extensions.browsers.Managed;
import info.novatec.testit.webtester.junit5.extensions.configuration.ConfigurationValue;
import info.novatec.testit.webtester.junit5.extensions.pages.Initialized;


@EnableWebTesterExtensions
@CreateBrowsersUsing(ChromeFactory.class)
class ShopTestJunit5 {

    @Managed("Chrome")
    @EntryPoint("${entrypoint.main}")
    private static Browser firefox;

    @Initialized(source = "Chrome")
    private ShopSearchPage shopSearchPage;

    @ConfigurationValue(source = "Chrome", value = "customer.username")
    private String customerUsername;

    @ConfigurationValue(source = "Chrome", value = "customer.password")
    private String customerPassword;

    private LoginFlow loginFlow;
    private ShoppingFlow shoppingFlow;

    @BeforeEach
    void setup() {
        loginFlow = new LoginFlow();
    }

    @Test
    @DisplayName("Verifies successful login of the testuser")
    void successfulLoginTest() {
        shopSearchPage = loginFlow.from(shopSearchPage).login(customerUsername, customerPassword);
        assertThat(shopSearchPage.navBar().logout()).isVisible();
    }

    @Test
    @DisplayName("Add 3 random items to basket")
    void canAddItemsToBasket() {
        int itemCount = 3;
        shoppingFlow = new ShoppingFlow();
        shopSearchPage = loginFlow.from(shopSearchPage).login(customerUsername, customerPassword);
        ShopBasketPage basketPage =
            shoppingFlow.with(shopSearchPage).addRandomItemsToBasket(itemCount).navigateTo(ShopBasketPage.class);

        assertThat(basketPage.items().count()).isEqualTo(itemCount);
    }

}
