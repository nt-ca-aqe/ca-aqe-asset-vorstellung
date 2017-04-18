package demo.workflow;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import demo.page.ShopSearchPage;
import demo.pagefragments.searchpage.ShopSearchItemRow;


public class SearchResultFlow extends ShopFlow {

    private ShopSearchPage shopSearchPage;

    SearchResultFlow(ShopSearchPage shopSearchPage) {
        super(shopSearchPage);
        this.shopSearchPage = shopSearchPage;
    }

    public SearchResultFlow addRandomItemsToBasket(int itemCount) {
        List<ShopSearchItemRow> randomItems =
            shopSearchPage.items().collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                Collections.shuffle(list);
                return list.subList(0, itemCount);
            }));

        randomItems.forEach(item -> item.addToBasket().click());
        return this;
    }
}
