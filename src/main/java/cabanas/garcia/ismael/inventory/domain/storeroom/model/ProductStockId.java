package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class ProductStockId extends ValueObject<ProductStockId> {

    private String value;

    public ProductStockId() {
        value = UUID.randomUUID().toString();
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


}
