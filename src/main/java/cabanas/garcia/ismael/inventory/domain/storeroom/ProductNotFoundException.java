package cabanas.garcia.ismael.inventory.domain.storeroom;

import cabanas.garcia.ismael.inventory.domain.product.ProductId;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(ProductId productId) {
        super(String.format("The product %s not exist", productId));
    }
}
