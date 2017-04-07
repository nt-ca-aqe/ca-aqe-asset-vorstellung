package demo.pagefragments.basketpage;

import info.novatec.testit.webtester.pagefragments.Link;
import info.novatec.testit.webtester.pagefragments.TableRow;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;


public interface ShopBasketItemRow extends TableRow {
    @IdentifyUsing(".btn[ng-click^='delete']")
    Link deleteFromBasket();
}
