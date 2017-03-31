package demo.pagefragments;

import info.novatec.testit.webtester.pagefragments.Link;
import info.novatec.testit.webtester.pagefragments.PageFragment;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;


public interface MainNavigation extends PageFragment {

    @IdentifyUsing("a[href=#/login")
    Link login();
}
