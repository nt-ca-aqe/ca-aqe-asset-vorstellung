package demo.workflow;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import demo.page.ShopSearchPage;
import demo.pagefragments.searchpage.ShopSearchItemRow;


public class ShoppingFlow extends ShopFlow {

    private ShopSearchPage shopSearchPage;

    public ShoppingFlow with(ShopSearchPage shopSearchPage) {
        this.shopSearchPage = shopSearchPage;
        return this;
    }

    public ShoppingFlow addRandomItemsToBasket(int itemCount) {
        Stream<ShopSearchItemRow> items = shopSearchPage.items();
        assert items.count() >= itemCount;
        List<ShopSearchItemRow> collected = items.collect(Collectors.toList());
        Collections.shuffle(collected);
        collected.forEach(row -> row.addToBasket().click());
        return this;
    }
}
