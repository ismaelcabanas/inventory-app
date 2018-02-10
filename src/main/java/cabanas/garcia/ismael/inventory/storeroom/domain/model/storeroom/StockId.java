package cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom;

import cabanas.garcia.ismael.inventory.common.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class StockId extends ValueObject<StockId>{

    private String id;

    public StockId() {
        id = UUID.randomUUID().toString();
    }

    @Override
    protected int hashCodeCore() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(id)
                .toHashCode();
    }

    @Override
    protected boolean equalsCore(StockId other) {
        return new EqualsBuilder()
                .append(id, other.id)
                .isEquals();
    }

    public String id() {
        return id;
    }


}
