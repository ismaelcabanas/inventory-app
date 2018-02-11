package cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom;

import cabanas.garcia.ismael.inventory.common.Entity;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.ProductId;

public class Storeroom extends Entity<StoreroomId> {

    private final String name;
    private final ProductsStock productsStock;

    public Storeroom(StoreroomId storeroomId, String name) {
        super(storeroomId);
        this.name = name;
        this.productsStock = new ProductsStock();
    }

    private Storeroom(Builder builder) {
        super(builder.theStoreroomId);
        this.name = builder.theName;
        this.productsStock = new ProductsStock();
    }

    /*
    public void addNewProduct(Product product) {
        // TODO only register new products if it is not in stock
        Stock stock = new Stock(new ProductStockId(), this, product, 0);
        productsStock.add(stock);
    }

    public void addStock(Product product, int quantity) {
        productsStock.addStock(product, quantity);
    }


    public int stock(Product product) {
        Optional<Stock> stockOfProduct = productsStock.findStockBy(product);
        return (stockOfProduct.isPresent() ? stockOfProduct.get().quantity() : -1);
    }

    public void consumeStock(Product product, int quantity) {
        productsStock.removeStock(product, quantity);
    }
    */

    public void addNewProduct(ProductId productId, int amount) {
        productsStock.newProductWithStock(productId, amount);
    }

    public Stock stockOf(ProductId productId) {
        return Stock.NONE;
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
