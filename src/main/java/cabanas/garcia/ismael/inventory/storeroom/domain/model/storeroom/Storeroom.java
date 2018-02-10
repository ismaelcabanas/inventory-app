package cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom;

import cabanas.garcia.ismael.inventory.common.Entity;

import java.util.Optional;

public class Storeroom extends Entity<StoreroomId> {

    private final StoreroomId storeroomId;
    private final String name;
    private final Stocks stocks;

    public Storeroom(StoreroomId storeroomId, String name) {
        super(storeroomId);
        this.storeroomId = storeroomId;
        this.name = name;
        this.stocks = new Stocks();
    }

    public void addNewProduct(Product product) {
        // TODO only register new products if it is not in stock
        Stock stock = new Stock(new StockId(), this, product, 0);
        stocks.add(stock);
    }

    public void addStock(Product product, int quantity) {
        stocks.addStock(product, quantity);
    }


    public int stock(Product product) {
        Optional<Stock> stockOfProduct = stocks.findStockBy(product);
        return (stockOfProduct.isPresent() ? stockOfProduct.get().quantity() : -1);
    }

    public void consumeStock(Product product, int quantity) {
        stocks.removeStock(product, quantity);
    }
}
