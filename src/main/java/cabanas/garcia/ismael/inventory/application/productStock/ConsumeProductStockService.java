package cabanas.garcia.ismael.inventory.application.productStock;

import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.productStock.model.Stock;
import cabanas.garcia.ismael.inventory.domain.productStock.model.StoreroomId;
import cabanas.garcia.ismael.inventory.domain.productStock.repository.ProductStockRepository;

public class ConsumeProductStockService {
    private final ProductStockRepository productStockRepository;

    public ConsumeProductStockService(ProductStockRepository productStockRepository) {
        this.productStockRepository = productStockRepository;
    }

    public void consume(StoreroomId storeroomId, ProductId productId, int amount) {
        ProductStock productStock = productStockRepository.findBy(storeroomId, productId);
        productStock.consume(new Stock(amount));
        productStockRepository.save(productStock);
    }
}
