package cabanas.garcia.ismael.inventory.domain.productStock.model;

import cabanas.garcia.ismael.inventory.domain.common.AgreggateRoot;

import java.util.Objects;

public class ProductStock extends AgreggateRoot<ProductStockId> {
    private final StoreroomId storeroomId;
    private final ProductId productId;
    private Stock stock;

    public ProductStock(StoreroomId storeroomId, ProductId productId, Stock stock) {
        Objects.requireNonNull(productId, "ProductId must not be null");
        Objects.requireNonNull(stock, "Stock must not be null");
        Objects.requireNonNull(storeroomId, "A product must be associated to non null storeroom");

        setId(new ProductStockId());
        this.storeroomId = storeroomId;
        this.productId = productId;
        this.stock = stock;
    }

    public Stock stock() {
        return stock;
    }

    public ProductId product() {
        return productId;
    }

    public StoreroomId storeroom() {
        return storeroomId;
    }

    public void consume(Stock theStock) {
        this.stock = this.stock.decrease(theStock);
    }

    public void fill(Stock theStock) {
        this.stock = this.stock.increase(theStock);
    }
}
