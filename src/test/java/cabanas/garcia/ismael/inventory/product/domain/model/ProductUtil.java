package cabanas.garcia.ismael.inventory.product.domain.model;

public final class ProductUtil {
    private ProductUtil() {
    }

    public static Product someProductWithName(ProductId productId, String productName) {
        return Product.builder()
                .withName(productName)
                .withId(productId)
                .build();
    }
}
