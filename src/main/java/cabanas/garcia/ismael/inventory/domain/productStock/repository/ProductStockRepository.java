package cabanas.garcia.ismael.inventory.domain.productStock.repository;

import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.productStock.model.StoreroomId;

public interface ProductStockRepository {
    void save(ProductStock productStock);

    ProductStock findBy(StoreroomId storeroomId, ProductId productId);
}
