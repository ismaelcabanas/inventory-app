package cabanas.garcia.ismael.inventory.domain.storeroom;

import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;

public final class StoreroomUtil {

    private StoreroomUtil() { }

    public static Storeroom anStoreroomWithProductAndStock(StoreroomId storeroomId, ProductId productId, Stock stock) {
        Storeroom storeroom = Storeroom.builder("Test Storeroom")
                .withId(storeroomId)
                .build();
        storeroom.load(productId, stock);
        return storeroom;
    }
}
