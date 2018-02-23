package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.Entity;

import java.util.Objects;

public class ProductStock extends Entity<ProductStockId> {
    private final ProductId productId;
    private Stock stock;
    private final Storeroom storeroom;

    public ProductStock(Storeroom storeroom, ProductId productId, Stock stock) {
        Objects.requireNonNull(productId, "ProductId must not be null");
        Objects.requireNonNull(stock, "Stock must not be null");
        Objects.requireNonNull(storeroom, "A product must be associated to non null storeroom");
        setId(new ProductStockId());
        this.storeroom = storeroom;
        this.productId = productId;
        this.stock = stock;
    }

    public ProductStock(Storeroom storeroom, ProductId productId) {
        this.storeroom = storeroom;
        this.productId = productId;
        this.stock = Stock.NONE;
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

    public Storeroom storeroom() {
        return storeroom;
    }
}
