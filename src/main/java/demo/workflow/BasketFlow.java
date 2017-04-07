package demo.workflow;

import demo.page.ShopBasketPage;

import info.novatec.testit.webtester.waiting.Wait;


/**
 * @author Sebastian Letzel
 */
public class BasketFlow extends ShopFlow {

    private final ShopBasketPage shopBasketPage;

    BasketFlow(ShopBasketPage shopBasketPage) {
        super(shopBasketPage);
        this.shopBasketPage = shopBasketPage;
    }

    public long itemCount() {
        return shopBasketPage.items().count();
    }

    public void clearBasket() {
        long start = itemCount();

        while (itemCount() > 0) {
            deleteFirstItem();
            long reducedItemCount = --start;
            Wait.untilSupplied(this::itemCount).is((count) -> count.equals(reducedItemCount));
        }
    }

    private void deleteFirstItem() {
        shopBasketPage.items().findFirst().get().deleteFromBasket().click();
    }
}
