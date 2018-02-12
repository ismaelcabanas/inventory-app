package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import cabanas.garcia.ismael.inventory.common.Entity;

public class ProductStock extends Entity<ProductStockId> {
    private final ProductId productId;
    private Stock stock;

    public ProductStock(ProductId productId, int stockAmount) {
        super(new ProductStockId());
        this.productId = productId;
        this.stock = new Stock(stockAmount);
    }

    public ProductId product() {
        return this.productId;
    }

    public void addStock(int stock) {
        this.stock = this.stock.increase(stock);
    }

    public Stock stock() {
        return this.stock;
    }
}
