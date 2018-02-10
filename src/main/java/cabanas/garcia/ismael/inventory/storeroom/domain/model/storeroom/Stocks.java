package cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stocks {

    private final List<Stock> stocks;

    public Stocks() {
        this.stocks = new ArrayList<>();
    }

    public void add(Stock stock) {
        stocks.add(stock);
    }

    public void addStock(Product product, int quantity) {
        stocks.stream()
                .filter(stock -> stock.product().equals(product))
                .findFirst()
                .ifPresent(stock -> stock.add(quantity));
    }

    public void removeStock(Product product, int quantity) {
        stocks.stream()
                .filter(stock -> stock.product().equals(product))
                .findFirst()
                .ifPresent(stock -> stock.remove(quantity));
    }

    public Optional<Stock> findStockBy(Product product) {
        return stocks.stream()
                .filter(stock -> stock.product().equals(product))
                .findFirst();
    }
}
