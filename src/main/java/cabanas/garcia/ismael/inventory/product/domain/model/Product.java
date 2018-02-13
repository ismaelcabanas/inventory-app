package cabanas.garcia.ismael.inventory.product.domain.model;

import cabanas.garcia.ismael.inventory.common.AgreggateRoot;

import java.util.Objects;

public class Product extends AgreggateRoot<ProductId> {
    private final String name;

    public Product(String name) {
        Objects.requireNonNull(name, "Name is required");
        this.name = name;
        setId(new ProductId());
    }

    private Product(Builder builder) {
        this.name = builder.name;
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

        public Builder withId(ProductId productId) {
            this.productId = productId;
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