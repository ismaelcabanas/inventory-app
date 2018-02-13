package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import cabanas.garcia.ismael.inventory.common.Entity;

import java.util.Objects;

public class ProductStock extends Entity<ProductStockId> {
    private final ProductId productId;
    private Stock stock;

    public ProductStock(ProductId productId, Stock stock) {
        super(new ProductStockId());
        Objects.requireNonNull(productId, "ProductId must not be null");
        Objects.requireNonNull(stock, "Stock must not be null");
        this.productId = productId;
        this.stock = stock;
    }

    public ProductId product() {
        return this.productId;
    }

    public void addStock(Stock stockToAdd) {
        this.stock = this.stock.increase(stockToAdd);
    }

    public void removeStock(Stock stockToRemove) {
        this.stock = this.stock.decrease(stockToRemove);
    }

    public Stock stock() {
        return this.stock;
    }

}
