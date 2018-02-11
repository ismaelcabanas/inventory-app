package cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom;

import cabanas.garcia.ismael.inventory.common.Entity;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.ProductId;

public class Product extends Entity<ProductId>{
    public Product(ProductId productId) {
        super(productId);
    }

    /*
    private final String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
    */
}
