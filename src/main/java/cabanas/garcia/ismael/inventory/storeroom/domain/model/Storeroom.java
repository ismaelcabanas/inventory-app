package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import cabanas.garcia.ismael.inventory.common.AgreggateRoot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Storeroom extends AgreggateRoot<StoreroomId> {

    private final String name;
    private final List<ProductStock> productStocks;

    public Storeroom(StoreroomId storeroomId, String name) {
        super(storeroomId);
        this.name = name;
        this.productStocks = new ArrayList<>();
    }

    private Storeroom(Builder builder) {
        super(builder.theStoreroomId);
        this.name = builder.theName;
        this.productStocks = new ArrayList<>();
    }

    void load(ProductStock... productStocks) {
        this.productStocks.addAll(Arrays.asList(productStocks));
    }

    public void fill(ProductId productId, int amount) {
        ProductStock productStock = productStocks.stream()
                .filter(ps -> ps.product().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(productId));
        productStock.addStock(amount);
    }

    public Stock stockOf(ProductId productId) {
        return productStocks.stream()
                .filter(ps -> ps.product().equals(productId))
                .map(ProductStock::stock)
                .findFirst().orElseThrow(() -> new ProductNotFoundException(productId));
    }

    public static Builder builder(StoreroomId storeroomId) {
        return new Builder(storeroomId);
    }

    public static final class Builder {

        private final StoreroomId theStoreroomId;
        public String theName;

        public Builder(StoreroomId storeroomId) {
            this.theStoreroomId = storeroomId;
        }

        public Storeroom build() {
            return new Storeroom(this);
        }

        public Builder withName(String name) {
            this.theName = name;
            return this;
        }
    }
}
