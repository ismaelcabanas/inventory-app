package cabanas.garcia.ismael.inventory.domain.storeroom.model;

public final class StoreroomUtil {

    private StoreroomUtil() { }

    public static Storeroom anStoreroomWithProductAndStock(StoreroomId storeroomId, ProductId productId, Stock stock) {
        Storeroom storeroom = Storeroom.builder("Test Storeroom")
                .withId(storeroomId)
                .build();
        storeroom.load(new ProductStock(productId, stock));
        return storeroom;
    }
}
