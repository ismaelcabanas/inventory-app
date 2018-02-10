package cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom;

import cabanas.garcia.ismael.inventory.common.Entity;

public class Stock extends Entity<String> {

    private final StockId stockId;
    private final Storeroom storeroom;
    private final Product product;
    private int quantity;

    public Stock(StockId stockId, Storeroom storeroom, Product product, int quantity) {
        this.stockId = stockId;
        this.storeroom = storeroom;
        this.product = product;
        this.quantity = quantity;
    }

    public Product product() {
        return product;
    }

    public void add(int quantity) {
        this.quantity += quantity;
    }

    public int quantity() {
        return quantity;
    }

    public void remove(int quantity) {
        this.quantity -= quantity;
    }
}
