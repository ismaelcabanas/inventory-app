package cabanas.garcia.ismael.inventory.product.domain.model;

import cabanas.garcia.ismael.inventory.common.domain.AgreggateRoot;
import cabanas.garcia.ismael.inventory.common.domain.DomainEventPublisher;
import cabanas.garcia.ismael.inventory.product.domain.event.ProductRegisteredEvent;

import java.util.Objects;

public class Product extends AgreggateRoot<ProductId> {
    private final String name;

    public Product(String name) {
        Objects.requireNonNull(name, "Name is required");
        this.name = name;
        setId(new ProductId());
        DomainEventPublisher.getInstance().publish(new ProductRegisteredEvent(id().value()));
    }

    private Product(Builder builder) {
        this.name = builder.name;
        setId(builder.productId);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String name() {
        return name;
    }

    public static class Builder {

        private ProductId productId;
        public String name;

        public Builder withId(ProductId theProductId) {
            this.productId = theProductId;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

        public Builder withName(String productName) {
            this.name = productName;
            return this;
        }
    }
}
