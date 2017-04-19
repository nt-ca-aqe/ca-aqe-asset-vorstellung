package info.novatec.testit.webtesterdemo.junit4;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;

import info.novatec.testit.webtester.browser.Browser;
import info.novatec.testit.webtester.browser.factories.ChromeFactory;
import info.novatec.testit.webtester.junit.annotations.ConfigurationValue;
import info.novatec.testit.webtester.junit.annotations.CreateUsing;
import info.novatec.testit.webtester.junit.annotations.EntryPoint;
import info.novatec.testit.webtester.junit.runner.WebTesterJUnitRunner;


@RunWith(WebTesterJUnitRunner.class)
public class ShopTestJunit4 {

    @ConfigurationValue("customer.username")
    String customerUsername;
    @ConfigurationValue("customer.password")
    String customerPassword;

    @Resource
    @CreateUsing(ChromeFactory.class)
    @EntryPoint("${entrypoint.main}")
    private Browser firefox;

    @Test
    public void loginTest() throws Exception {

    }
}
