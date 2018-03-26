package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.shared.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public final class StoreroomId extends ValueObject<StoreroomId> {

    private String id;

    public StoreroomId() {
        this.id = UUID.randomUUID().toString();
    }

    public StoreroomId(String id) {
        this.id = id;
    }

    private StoreroomId(Builder builder) {
        this.id = builder.storeroomId;
    }

    @Override
    protected int hashCodeCore() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    protected boolean equalsCore(StoreroomId other) {
        return new EqualsBuilder()
                .append(id, other.id)
                .isEquals();
    }

    @Override
    public String toString() {
        return "StoreroomId{"
                + "id='" + id + '\''
                + '}';
    }

    public String value() {
        return id;
    }

    public static Builder builder(String id) {
        return new Builder(id);
    }

    public static class Builder {
        private final String storeroomId;

        public Builder(String id) {
            this.storeroomId = id;
        }

        public StoreroomId build() {
            return new StoreroomId(this);
        }
    }
}
