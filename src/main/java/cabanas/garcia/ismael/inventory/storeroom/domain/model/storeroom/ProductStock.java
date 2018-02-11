package cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom;

import cabanas.garcia.ismael.inventory.common.Entity;

public class ProductStock extends Entity<ProductStockId> {
    protected ProductStock(ProductStockId productStockId) {
        super(productStockId);
    }
}
