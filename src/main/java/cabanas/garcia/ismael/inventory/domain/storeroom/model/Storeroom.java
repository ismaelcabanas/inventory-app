package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.product.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.shared.AgreggateRoot;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Storeroom extends AgreggateRoot<StoreroomId> {

    private final String name;
    private final List<ProductStockItem> productStockItems;

    public Storeroom(String name) {
        Objects.requireNonNull(name, "The name is required");
        this.name = name;
        this.productStockItems = new ArrayList<>();
        setId(new StoreroomId());
    }

    private Storeroom(Builder builder) {
        this.name = builder.theName;
        this.productStockItems = builder.theProductStockItems;
        setId(builder.theStoreroomId);
    }

    void load(ProductId productId, Stock stock) {
        this.productStockItems.add(new ProductStockItem(this.id(), productId, stock));
    }
    public Stock stockOf(ProductId productId) {
        return productStockItems.stream()
                .filter(ps -> ps.productId().equals(productId))
                .map(ProductStockItem::stock)
                .findFirst().orElseThrow(() -> new ProductNotFoundException(productId));
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public String name() {
        return this.name;
    }

    public List<ProductStockItem> products() {
        return productStockItems;
    }

    @Override
    public String toString() {
        return "Storeroom{"
                + "id='" + id()
                + ", name='" + name + '\''
                + ", productStockItems=" + productStockItems
                + '}';
    }

    public static final class Builder {

        private StoreroomId theStoreroomId;
        public final String theName;
        private List<ProductStockItem> theProductStockItems = new ArrayList<>();

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

        public Builder withProductStocks(List<ProductStockItem> productStockItems) {
            this.theProductStockItems = productStockItems;
            return this;
        }
    }
}
