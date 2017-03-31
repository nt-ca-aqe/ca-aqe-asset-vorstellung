package demo.page;

import static info.novatec.testit.webtester.pagefragments.identification.ByProducers.css;

import java.util.stream.Stream;

import demo.pagefragments.basketpage.ShopBasketItemRow;

import info.novatec.testit.webtester.pages.Page;


public interface ShopBasketPage extends Page, HasMainNavigation, HasItemTable {

    default Stream<ShopBasketItemRow> items() {
        return itemTable().findBy(css("tr"))
            .asMany(ShopBasketItemRow.class)
            .filter(row -> row.trashIcon().isVisible());
    }
}
