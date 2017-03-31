package info.novatec.testit.webtesterdemo.junit5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import demo.page.ShopOverviewPage;
import demo.workflow.LoginFlow;

import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.factories.MarionetteFactory;
import info.novatec.testit.webtester.junit5.EnableWebTesterExtensions;
import info.novatec.testit.webtester.junit5.extensions.browsers.CreateBrowsersUsing;
import info.novatec.testit.webtester.junit5.extensions.browsers.EntryPoint;
import info.novatec.testit.webtester.junit5.extensions.browsers.Managed;
import info.novatec.testit.webtester.junit5.extensions.configuration.ConfigurationValue;
import info.novatec.testit.webtester.junit5.extensions.pages.Initialized;


@EnableWebTesterExtensions
@CreateBrowsersUsing(MarionetteFactory.class)
class ShopTestJunit5 {

    @Managed("Firefox")
    @EntryPoint("${entrypoint.main}")
    private static Browser firefox;

    @Initialized(source = "Firefox")
    private ShopOverviewPage shopOverview;

    @ConfigurationValue("customer.username")
    private String customerUsername;

    @ConfigurationValue("customer.password")
    private String customerPassword;

    private LoginFlow loginFlow;

    @BeforeAll
    void setup() {
        loginFlow = new LoginFlow(shopOverview);
    }

    @Test
    void loginTest() {

        loginFlow.login(customerUsername, customerPassword);
    }
}
