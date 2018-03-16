package cabanas.garcia.ismael.inventory.domain.productStock.model;

import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.product.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.shared.AgreggateRoot;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;

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

    private ProductStock(Builder builder) {
        this.setId(builder.productStockId);
        this.storeroomId = builder.storeroomId;
        this.productId = builder.productId;
        this.stock = builder.stock;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ProductStockId productStockId;
        private StoreroomId storeroomId;
        private ProductId productId;
        private Stock stock;

        public Builder withId(ProductStockId psId) {
            this.productStockId = psId;
            return this;
        }

        public Builder withStoreroomId(StoreroomId psStoreroomId) {
            this.storeroomId = psStoreroomId;
            return this;
        }

        public Builder withProductId(ProductId psProductId) {
            this.productId = psProductId;
            return this;
        }

        public Builder withStock(Stock psStock) {
            this.stock = psStock;
            return this;
        }

        public ProductStock build() {
            return new ProductStock(this);
        }
    }
}
