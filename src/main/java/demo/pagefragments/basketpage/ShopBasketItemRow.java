package demo.pagefragments.basketpage;

import info.novatec.testit.webtester.pagefragments.GenericElement;
import info.novatec.testit.webtester.pagefragments.TableRow;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;


public interface ShopBasketItemRow extends TableRow {
    @IdentifyUsing(".fa.fa-trash-o")
    GenericElement trashIcon();
}
