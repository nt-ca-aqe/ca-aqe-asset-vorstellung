package demo.page;

import static info.novatec.testit.webtester.pagefragments.identification.ByProducers.css;

import java.util.stream.Stream;

import demo.page.shared.HasItemTable;
import demo.page.shared.HasMainNavigation;
import demo.pagefragments.searchpage.ShopSearchItemRow;
import info.novatec.testit.webtester.pages.Page;


public interface ShopSearchPage extends Page, HasMainNavigation, HasItemTable {

    default Stream<ShopSearchItemRow> items() {
        return itemTable().findBy(css("tr"))
            .asMany(ShopSearchItemRow.class)
            .filter(row -> row.addToBasket().isPresent());
    }
}
