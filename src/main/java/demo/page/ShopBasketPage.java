package demo.page;

import static info.novatec.testit.webtester.pagefragments.identification.ByProducers.css;

import java.util.stream.Stream;

import demo.page.shared.HasItemTable;
import demo.page.shared.HasMainNavigation;
import demo.pagefragments.basketpage.ShopBasketItemRow;

import info.novatec.testit.webtester.conditions.pagefragments.PresentAndVisible;
import info.novatec.testit.webtester.pagefragments.Button;
import info.novatec.testit.webtester.pagefragments.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pagefragments.annotations.PostConstructMustBe;
import info.novatec.testit.webtester.pagefragments.annotations.WaitUntil;
import info.novatec.testit.webtester.pages.Page;


public interface ShopBasketPage extends Page, HasMainNavigation, HasItemTable {

    @PostConstructMustBe(PresentAndVisible.class)
    @WaitUntil(PresentAndVisible.class)
    @IdentifyUsing("#checkoutButton")
    Button checkOut();

    default Stream<ShopBasketItemRow> items() {
        return itemTable().findBy(css("tr"))
            .asMany(ShopBasketItemRow.class)
            .filter(row -> row.deleteFromBasket().isPresent());
    }
}
