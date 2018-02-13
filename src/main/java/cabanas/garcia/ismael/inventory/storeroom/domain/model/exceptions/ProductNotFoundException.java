package cabanas.garcia.ismael.inventory.storeroom.domain.model.exceptions;

import cabanas.garcia.ismael.inventory.storeroom.domain.model.ProductId;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(ProductId productId) {
        super(String.format("The product %s not exist", productId));
    }
}