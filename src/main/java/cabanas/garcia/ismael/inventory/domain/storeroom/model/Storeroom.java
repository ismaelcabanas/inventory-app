package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.AgreggateRoot;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Storeroom extends AgreggateRoot<StoreroomId> {

    private final String name;
    private final List<ProductStock> productStocks;

    public Storeroom(String name) {
        Objects.requireNonNull(name, "The name is required");
        this.name = name;
        this.productStocks = new ArrayList<>();
        setId(new StoreroomId());
    }

    private Storeroom(Builder builder) {
        this.name = builder.theName;
        this.productStocks = builder.theProductStocks;
        setId(builder.theStoreroomId);
    }

    void load(ProductId productId, Stock stock) {
        this.productStocks.add(new ProductStock(this, productId, stock));
    }
    public Stock stockOf(ProductId productId) {
        return productStocks.stream()
                .filter(ps -> ps.productId().equals(productId))
                .map(ProductStock::stock)
                .findFirst().orElseThrow(() -> new ProductNotFoundException(productId));
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public String name() {
        return this.name;
    }

    public List<ProductStock> products() {
        return productStocks;
    }

    @Override
    public String toString() {
        return "Storeroom{"
                + "id='" + id()
                + ", name='" + name + '\''
                + ", productStocks=" + productStocks
                + '}';
    }

    public static final class Builder {

        private StoreroomId theStoreroomId;
        public final String theName;
        private List<ProductStock> theProductStocks = new ArrayList<>();

        public Builder(String name) {
            this.theName = name;
        }

        public Storeroom build() {
            return new Storeroom(this);
        }

        public Builder withId(StoreroomId storeroomId) {
            this.theStoreroomId = storeroomId;
            return this;
        }

        public Builder withProductStocks(List<ProductStock> productStocks) {
            this.theProductStocks = productStocks;
            return this;
        }
    }
}
