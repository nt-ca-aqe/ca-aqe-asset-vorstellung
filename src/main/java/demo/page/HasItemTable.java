package demo.page;

import info.novatec.testit.webtester.pagefragments.Table;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;


public interface HasItemTable {

    @IdentifyUsing(".table-striped.table-bordered.table-condensed")
    Table itemTable();
}
