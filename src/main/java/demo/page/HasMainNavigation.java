package demo.page;

import demo.pagefragments.MainNavigation;

import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pages.Page;


public interface HasMainNavigation extends Page{

    @IdentifyUsing(".navbar.navbar-default")
    MainNavigation navBar();
}
