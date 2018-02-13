package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import cabanas.garcia.ismael.inventory.common.AgreggateRoot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Storeroom extends AgreggateRoot<StoreroomId> {

    @SuppressWarnings("PMD")
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
        this.productStocks = new ArrayList<>();
        setId(builder.theStoreroomId);
    }

    void load(ProductStock... theProductStocks) {
        this.productStocks.addAll(Arrays.asList(theProductStocks));
    }

    public void fill(ProductId productId, Stock stock) {
        ProductStock productStock = productStocks.stream()
                .filter(ps -> ps.product().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(productId));
        productStock.addStock(stock);
    }

    public void consume(ProductId productId, Stock stock) {
        ProductStock productStock = productStocks.stream()
                .filter(ps -> ps.product().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(productId));
        productStock.removeStock(stock);
    }

    public Stock stockOf(ProductId productId) {
        return productStocks.stream()
                .filter(ps -> ps.product().equals(productId))
                .map(ProductStock::stock)
                .findFirst().orElseThrow(() -> new ProductNotFoundException(productId));
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public static final class Builder {

        private StoreroomId theStoreroomId;
        public final String theName;

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
    }
}
