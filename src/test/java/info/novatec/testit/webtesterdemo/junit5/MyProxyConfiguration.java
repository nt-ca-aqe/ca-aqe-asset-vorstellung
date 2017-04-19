package info.novatec.testit.webtesterdemo.junit5;

import info.novatec.testit.webtester.browser.proxy.ProxyConfiguration;
import org.openqa.selenium.Proxy;

/**
 * Created by afa on 4/19/17.
 */
public class MyProxyConfiguration implements ProxyConfiguration {

    @Override
    public void configureProxy(Proxy proxy) {
        proxy.setHttpProxy("localhost:8085");
        proxy.setSslProxy("localhost:8085");
    }
}
