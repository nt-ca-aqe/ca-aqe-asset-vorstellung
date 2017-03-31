package demo.page;

import demo.pagefragments.MainNavigation;

import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;


public interface HasMainNavigation {

    @IdentifyUsing(".navbar.navbar-default")
    MainNavigation navBar();
}
