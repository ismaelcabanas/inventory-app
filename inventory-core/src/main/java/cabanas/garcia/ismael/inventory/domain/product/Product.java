package cabanas.garcia.ismael.inventory.domain.product;

import cabanas.garcia.ismael.inventory.domain.shared.AgreggateRoot;

public class Product extends AgreggateRoot<ProductId> {
    private final String name;

    public static Product create(String productName, ProductId productId) {
        Product product = Product.builder(productName).withId(productId).build();
        product.register(new ProductRegisteredDomainEvent(productId.value()));
        return product;
    }

    private Product(Builder builder) {
        this.name = builder.name;
        setId(builder.productId);
    }

    public static Builder builder(String productName) {
        return new Builder(productName);
    }

    public String name() {
        return name;
    }

    public static class Builder {

        private ProductId productId;
        private String name;

        public Builder(String productName) {
            this.name = productName;
        }

        public Builder withId(ProductId theProductId) {
            this.productId = theProductId;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

    }
}
