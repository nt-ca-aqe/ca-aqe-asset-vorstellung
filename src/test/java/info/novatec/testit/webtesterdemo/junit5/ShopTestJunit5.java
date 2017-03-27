package info.novatec.testit.webtesterdemo.junit5;

import org.junit.jupiter.api.Test;

import demo.page.ShopLoginPage;

import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.factories.FirefoxFactory;
import info.novatec.testit.webtester.junit5.EnableWebTesterExtensions;
import info.novatec.testit.webtester.junit5.extensions.browsers.CreateBrowsersUsing;
import info.novatec.testit.webtester.junit5.extensions.browsers.EntryPoint;
import info.novatec.testit.webtester.junit5.extensions.browsers.Managed;
import info.novatec.testit.webtester.junit5.extensions.configuration.ConfigurationValue;
import info.novatec.testit.webtester.junit5.extensions.pages.Initialized;


@EnableWebTesterExtensions
@CreateBrowsersUsing(FirefoxFactory.class)
class ShopTestJunit5 {

    @Managed("Firefox")
    //TODO
    @EntryPoint("${properties.url}")
    Browser firefox;

    @Initialized(source = "browser-1")
    ShopLoginPage loginPage;

    @ConfigurationValue("customer.username")
    String customerUsername;

    @ConfigurationValue("customer.password")
    String customerPassword;

    @Test
    void loginTest() {

    }
}
