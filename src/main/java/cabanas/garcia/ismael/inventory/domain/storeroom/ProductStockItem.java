package cabanas.garcia.ismael.inventory.domain.storeroom;

import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStockId;
import cabanas.garcia.ismael.inventory.domain.shared.Entity;

import java.util.Objects;

public class ProductStockItem extends Entity<ProductStockId> {
    private final ProductId productId;
    private Stock stock;
    private final StoreroomId storeroomId;

    public ProductStockItem(StoreroomId storeroomId, ProductId productId, Stock stock) {
        Objects.requireNonNull(productId, "ProductId must not be null");
        Objects.requireNonNull(stock, "Stock must not be null");
        Objects.requireNonNull(storeroomId, "A product must be associated to non null storeroom");
        setId(new ProductStockId());
        this.storeroomId = storeroomId;
        this.productId = productId;
        this.stock = stock;
    }

    public ProductStockItem(StoreroomId storeroomId, ProductId productId) {
        this.storeroomId = storeroomId;
        this.productId = productId;
        this.stock = Stock.NONE;
    }

    public ProductId productId() {
        return this.productId;
    }

    public Stock stock() {
        return this.stock;
    }

    public StoreroomId storeroomId() {
        return storeroomId;
    }

    @Override
    public String toString() {
        return "ProductStockItem{"
                + "storeroomId=" + storeroomId
                + "productId=" + productId
                + ", stock=" + stock
                + '}';
    }
}
