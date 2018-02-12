package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import cabanas.garcia.ismael.inventory.common.Entity;

import java.util.Objects;

public class ProductStock extends Entity<ProductStockId> {
    private final ProductId productId;
    private Stock stock;

    public ProductStock(ProductId productId, Stock stock) {
        super(new ProductStockId());
        Objects.requireNonNull(productId, "ProductId must not be null");
        this.productId = productId;
        this.stock = stock;
    }

    public ProductId product() {
        return this.productId;
    }

    public void addStock(Stock stock) {
        this.stock = this.stock.increase(stock);
    }

    public Stock stock() {
        return this.stock;
    }
}
