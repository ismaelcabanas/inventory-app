package cabanas.garcia.ismael.inventory.product.domain.model;

import cabanas.garcia.ismael.inventory.common.domain.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class ProductId extends ValueObject<ProductId> {

    private String value;

    public ProductId() {
        this.value = UUID.randomUUID().toString();
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
}
