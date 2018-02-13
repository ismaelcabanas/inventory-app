package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import cabanas.garcia.ismael.inventory.common.domain.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class ProductStockId extends ValueObject<ProductStockId> {

    private String id;

    public ProductStockId() {
        id = UUID.randomUUID().toString();
    }

    @Override
    protected int hashCodeCore() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    protected boolean equalsCore(ProductStockId other) {
        return new EqualsBuilder()
                .append(id, other.id)
                .isEquals();
    }

    public String id() {
        return id;
    }


}
