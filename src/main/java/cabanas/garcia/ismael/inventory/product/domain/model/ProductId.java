package cabanas.garcia.ismael.inventory.product.domain.model;

import cabanas.garcia.ismael.inventory.common.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class ProductId extends ValueObject<ProductId> {

    private String id;

    public ProductId() {
        this.id = UUID.randomUUID().toString();
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

    public String id() {
        return id;
    }
}
