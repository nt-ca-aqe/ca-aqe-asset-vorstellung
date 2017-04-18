package info.novatec.testit.webtesterdemo.junit5;

import static info.novatec.testit.webtester.support.assertj.WebTesterAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demo.page.ShopSearchPage;
import demo.workflow.BasketFlow;
import demo.workflow.SearchResultFlow;
import demo.workflow.ShopFlow;

import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.factories.ChromeFactory;
import info.novatec.testit.webtester.junit5.EnableWebTesterExtensions;
import info.novatec.testit.webtester.junit5.extensions.browsers.CreateBrowsersUsing;
import info.novatec.testit.webtester.junit5.extensions.browsers.EntryPoint;
import info.novatec.testit.webtester.junit5.extensions.browsers.Managed;
import info.novatec.testit.webtester.junit5.extensions.configuration.ConfigurationValue;
import info.novatec.testit.webtester.junit5.extensions.pages.Initialized;
import info.novatec.testit.webtester.waiting.Wait;


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
        SearchResultFlow login = ShopFlow.loginFrom(shopSearchPage).login(customerUsername, customerPassword);
        assertThat(login.getNavigation().logout()).isVisible();
    }
}
class SearchResultTests extends  ShopTestJunit5 {

    private SearchResultFlow searchResultFlow;
    private final String searchTerm = "apple";

    @BeforeEach
    void setup() {
        searchResultFlow = ShopFlow.loginFrom(shopSearchPage).login(customerUsername, customerPassword);
    }

    @Test
    @DisplayName("Seaching for "+searchTerm+" returns the appropriate amount")
    void opensAndCollapsesPaymentOptions() {
        int expectedAmount = 2;

        searchResultFlow.searchFor(searchTerm);
        Wait.exactly(1, TimeUnit.SECONDS);
        assertThat(searchResultFlow.itemCount()).isEqualTo(expectedAmount);
    }
}
class BasketTests extends ShopTestJunit5 {

    private SearchResultFlow searchResultFlow;

    @BeforeEach
    void setup() {
        searchResultFlow = ShopFlow.loginFrom(shopSearchPage).login(customerUsername, customerPassword);
    }

    @Test
    @DisplayName("Add 3 random items to basket and delete them")
    void canAddItemsToBasket() {
        int itemCount = 3;

        BasketFlow basketFlow = searchResultFlow.addRandomItemsToBasket(itemCount).navigateToBasket();
        assertThat(basketFlow.itemCount()).isEqualTo(itemCount);

        basketFlow.clearBasket();

        assertThat(basketFlow.itemCount()).isEqualTo(0);
    }
}
