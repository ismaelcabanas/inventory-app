package cabanas.garcia.ismael.inventory.application.productStock;

import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.productStock.model.Stock;
import cabanas.garcia.ismael.inventory.domain.productStock.model.StoreroomId;
import cabanas.garcia.ismael.inventory.domain.productStock.repository.ProductStockRepository;

public class FillProductStockService {
    private final ProductStockRepository productStockRepository;

    public FillProductStockService(ProductStockRepository productStockRepository) {
        this.productStockRepository = productStockRepository;
    }

    public void fill(StoreroomId storeroomId, ProductId productId, int amount) {
        ProductStock productStock = productStockRepository.findBy(storeroomId, productId);
        productStock.fill(new Stock(amount));
        productStockRepository.save(productStock);
    }
}