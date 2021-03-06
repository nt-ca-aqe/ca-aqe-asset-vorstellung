package demo.pagefragments.searchpage;

import info.novatec.testit.webtester.pagefragments.Link;
import info.novatec.testit.webtester.pagefragments.TableRow;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;


public interface ShopSearchItemRow extends TableRow{

    @IdentifyUsing(".btn[ng-click^='addToBasket']")
    Link addToBasket();
}

