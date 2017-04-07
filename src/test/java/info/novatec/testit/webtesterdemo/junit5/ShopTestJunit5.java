package info.novatec.testit.webtesterdemo.junit5;

import static info.novatec.testit.webtester.support.assertj.WebTesterAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demo.page.ShopSearchPage;
import demo.workflow.BasketFlow;
import demo.workflow.ShopFlow;

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
    private static Browser chrome;

    @Initialized(source = "Chrome")
    ShopSearchPage shopSearchPage;

    @ConfigurationValue(source = "Chrome", value = "customer.username")
    String customerUsername;

    @ConfigurationValue(source = "Chrome", value = "customer.password")
    String customerPassword;

    @AfterEach
    void tearDown() {
        ShopFlow.logout(chrome);
    }
}

class LoginTests extends ShopTestJunit5 {

    @Test
    @DisplayName("Verifies successful login of the testuser")
    void successfulLoginTest() {
        shopSearchPage = ShopFlow.loginFrom(shopSearchPage).login(customerUsername, customerPassword);
        assertThat(shopSearchPage.navBar().logout()).isVisible();
    }
}

class BasketTests extends ShopTestJunit5 {

    @BeforeEach
    void setup() {
        shopSearchPage = ShopFlow.loginFrom(shopSearchPage).login(customerUsername, customerPassword);
    }

    @Test
    @DisplayName("Add 3 random items to basket and delete them")
    void canAddItemsToBasket() {
        int itemCount = 3;

        BasketFlow basketFlow = ShopFlow.from(shopSearchPage).addRandomItemsToBasket(itemCount).navigateToBasket();
        assertThat(basketFlow.itemCount()).isEqualTo(itemCount);

        basketFlow.clearBasket();

        assertThat(basketFlow.itemCount()).isEqualTo(0);
    }
}
