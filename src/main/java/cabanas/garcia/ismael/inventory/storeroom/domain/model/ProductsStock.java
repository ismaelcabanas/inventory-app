package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ProductsStock {

    private final List<ProductStock> productsStock;

    public ProductsStock() {
        this.productsStock = new ArrayList<>();
    }

    /*
    public void add(Stock stock) {
        productsStock.add(stock);
    }

    public void addStock(Product product, int quantity) {
        productsStock.stream()
                .filter(stock -> stock.product().equals(product))
                .findFirst()
                .ifPresent(stock -> stock.add(quantity));
    }

    public void removeStock(Product product, int quantity) {
        productsStock.stream()
                .filter(stock -> stock.product().equals(product))
                .findFirst()
                .ifPresent(stock -> stock.remove(quantity));
    }

    public Optional<Stock> findStockBy(Product product) {
        return productsStock.stream()
                .filter(stock -> stock.product().equals(product))
                .findFirst();
    }
*/
    public void newProductWithStock(ProductId productId, int stock) {

    }
}
