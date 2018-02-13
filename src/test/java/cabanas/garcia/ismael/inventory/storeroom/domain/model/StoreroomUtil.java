package cabanas.garcia.ismael.inventory.storeroom.domain.model;

public final class StoreroomUtil {

    private StoreroomUtil() { }

    public static Storeroom anStoreroomWithProductAndStock(StoreroomId storeroomId, ProductId productId, Stock stock) {
        Storeroom storeroom = new Storeroom(storeroomId, "Test Storeroom");
        storeroom.load(new ProductStock(productId, stock));
        return storeroom;
    }
}
