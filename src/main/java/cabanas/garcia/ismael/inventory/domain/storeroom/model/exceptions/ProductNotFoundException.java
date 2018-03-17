package cabanas.garcia.ismael.inventory.domain.storeroom.model.exceptions;

import cabanas.garcia.ismael.inventory.domain.product.model.ProductId;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(ProductId productId) {
        super(String.format("The product %s not exist", productId));
    }
}
