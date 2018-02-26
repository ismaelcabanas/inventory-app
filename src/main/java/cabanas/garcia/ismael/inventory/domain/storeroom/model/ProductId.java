package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class ProductId extends ValueObject<ProductId> {
    private String value;

    public ProductId() {
        value = UUID.randomUUID().toString();
    }

    private ProductId(Builder builder) {
        value = builder.productId;
    }

    @Override
    protected int hashCodeCore() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }

    @Override
    protected boolean equalsCore(ProductId other) {
        return new EqualsBuilder()
                .append(value, other.value)
                .isEquals();
    }

    public static Builder builder(String productId) {
        return new Builder(productId);
    }

    public String value() {
        return value;
    }

    public static class Builder {

        private final String productId;

        public Builder(String productId) {
            this.productId = productId;
        }

        public ProductId build() {
            return new ProductId(this);
        }
    }
}
