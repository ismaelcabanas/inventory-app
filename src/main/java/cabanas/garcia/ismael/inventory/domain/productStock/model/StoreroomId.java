package cabanas.garcia.ismael.inventory.domain.productStock.model;

import cabanas.garcia.ismael.inventory.domain.common.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

public class StoreroomId extends ValueObject<StoreroomId> {
    private String id;

    public StoreroomId() {
        this.id = UUID.randomUUID().toString();
    }

    private StoreroomId(Builder builder) {
        this.id = builder.id;
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

    public String value() {
        return id;
    }

    public static Builder builder(String psStoreroomId) {
        return new Builder(psStoreroomId);
    }

    public static class Builder {
        private final String id;

        public Builder(String psStoreroomId) {
            this.id = psStoreroomId;
        }

        public StoreroomId build() {
            return new StoreroomId(this);
        }
    }
}
