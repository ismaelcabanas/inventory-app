package cabanas.garcia.ismael.inventory.domain.productStock.repository;

import cabanas.garcia.ismael.inventory.domain.product.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.productStock.model.StoreroomId;

import java.util.Optional;

public interface ProductStockRepository {
    void save(ProductStock productStock);

    Optional<ProductStock> findBy(StoreroomId storeroomId, ProductId productId);
}
