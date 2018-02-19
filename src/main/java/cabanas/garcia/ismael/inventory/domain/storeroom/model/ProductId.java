package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class ProductId extends ValueObject<ProductId> {
    private String id;

    public ProductId() {
        id = UUID.randomUUID().toString();
    }

    private ProductId(Builder builder) {
        id = builder.productId;
    }

    @Override
    protected int hashCodeCore() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    protected boolean equalsCore(ProductId other) {
        return new EqualsBuilder()
                .append(id, other.id)
                .isEquals();
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
