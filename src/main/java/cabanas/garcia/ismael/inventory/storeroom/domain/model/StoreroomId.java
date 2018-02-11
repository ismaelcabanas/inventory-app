package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import cabanas.garcia.ismael.inventory.common.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public final class StoreroomId extends ValueObject<StoreroomId> {

    private String id;

    public StoreroomId() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    protected int hashCodeCore() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(id)
                .toHashCode();
    }

    @Override
    protected boolean equalsCore(StoreroomId other) {
        return new EqualsBuilder()
                .append(id, other.id)
                .isEquals();
    }

    public String id() {
        return id;
    }
}
