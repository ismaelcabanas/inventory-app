package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.model.Stock;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import cabanas.garcia.ismael.inventory.domain.shared.AgreggateRoot;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Storeroom extends AgreggateRoot<StoreroomId> {

    private final String name;
    private final List<ProductStock> products;

    public Storeroom(String name) {
        Objects.requireNonNull(name, "The name is required");
        this.name = name;
        this.products = new ArrayList<>();
        setId(new StoreroomId());
    }

    private Storeroom(Builder builder) {
        this.name = builder.theName;
        this.products = builder.theProducts;
        setId(builder.theStoreroomId);
    }

    void load(ProductId productId, Stock stock) {
        this.products.add(new ProductStock(productId, stock));
    }
    public Stock stockOf(ProductId productId) {
        return products.stream()
                .filter(ps -> ps.productId().equals(productId))
                .map(ProductStock::stock)
                .findFirst().orElseThrow(() -> new ProductNotFoundException(productId));
    }

    public String name() {
        return this.name;
    }

    public List<ProductStock> products() {
        return products;
    }

    public void add(ProductStock productStock) {
        this.products.add(productStock);
    }

    public void take(ProductId productId, Stock stock) {
        ProductStock product = findProduct(productId);
        ProductStock productWithUpdatedStock = product.consume(stock);
        replace(product, productWithUpdatedStock);
    }

    public void refill(ProductId productId, Stock stock) {
        ProductStock product = findProduct(productId);
        ProductStock productWithUpdatedStock = product.refill(stock);
        replace(product, productWithUpdatedStock);
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    @Override
    public String toString() {
        return "Storeroom{"
                + "id='" + id()
                + ", name='" + name + '\''
                + ", products=" + products
                + '}';
    }

    private ProductStock findProduct(ProductId productId) {
        return products.stream()
                .filter(ps -> ps.productId().equals(productId))
                .findFirst().orElseThrow(() -> new ProductNotFoundException(productId));
    }

    private void replace(ProductStock product, ProductStock productWithUpdatedStock) {
        products.remove(product);
        products.add(productWithUpdatedStock);
    }

    public static final class Builder {

        private StoreroomId theStoreroomId;
        private final String theName;
        private List<ProductStock> theProducts;

        public Builder(String name) {
            this.theName = name;
            this.theProducts = new ArrayList<>();
        }

        public Storeroom build() {
            return new Storeroom(this);
        }

        public Builder withId(StoreroomId storeroomId) {
            this.theStoreroomId = storeroomId;
            return this;
        }

    }
}
