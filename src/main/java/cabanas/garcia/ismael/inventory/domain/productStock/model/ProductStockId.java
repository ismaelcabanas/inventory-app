package cabanas.garcia.ismael.inventory.domain.productStock.model;

import cabanas.garcia.ismael.inventory.domain.shared.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class ProductStockId extends ValueObject<ProductStockId> {
    private String value;

    public ProductStockId() {
        value = UUID.randomUUID().toString();
    }

    private ProductStockId(Builder builder) {
        this.value = builder.productStockId;
    }

    @Override
    protected int hashCodeCore() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }

    @Override
    protected boolean equalsCore(ProductStockId other) {
        return new EqualsBuilder()
                .append(value, other.value)
                .isEquals();
    }

    public String value() {
        return value;
    }

    public static Builder builder(String psId) {
        return new Builder();
    }

    public static class Builder {
        private String productStockId;

        public Builder withId(String psId) {
            this.productStockId = psId;
            return this;
        }

        public ProductStockId build() {
            return new ProductStockId(this);
        }
    }
}
