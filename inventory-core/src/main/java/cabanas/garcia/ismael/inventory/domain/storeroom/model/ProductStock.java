package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.model.Stock;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import cabanas.garcia.ismael.inventory.domain.shared.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Objects;

public class ProductStock extends ValueObject<ProductStock> {

    private final ProductId productId;
    private final Stock stock;

    public ProductStock(ProductId productId, Stock stock) {
        Objects.requireNonNull(productId, "productId is required");
        Objects.requireNonNull(stock, "stock is required");
        this.productId = productId;
        this.stock = stock;
    }

    @Override
    protected int hashCodeCore() {
        return new HashCodeBuilder(17, 37)
                .append(productId)
                .append(stock)
                .toHashCode();
    }

    @Override
    protected boolean equalsCore(ProductStock other) {
        return new EqualsBuilder()
                .append(productId, other.productId)
                .append(stock, other.stock)
                .isEquals();
    }

    public ProductId productId() {
        return productId;
    }

    public Stock stock() {
        return stock;
    }

    public ProductStock consume(Stock stockConsumed) {
        return new ProductStock(productId, stock.decrease(stockConsumed));
    }

    public ProductStock refill(Stock stockRefilled) {
        return new ProductStock(productId, stock.increase(stockRefilled));
    }
}
