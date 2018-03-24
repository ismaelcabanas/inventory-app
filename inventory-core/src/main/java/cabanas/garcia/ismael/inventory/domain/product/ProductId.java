package cabanas.garcia.ismael.inventory.domain.product;

import cabanas.garcia.ismael.inventory.domain.shared.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class ProductId extends ValueObject<ProductId> {

    private String value;

    public ProductId() {
        this.value = UUID.randomUUID().toString();
    }

    private ProductId(Builder builder) {
        this.value = builder.productId;
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

    public String value() {
        return value;
    }

    public static Builder builder(String productId) {
        return new Builder(productId);
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
