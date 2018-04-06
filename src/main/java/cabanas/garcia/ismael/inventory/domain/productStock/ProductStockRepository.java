package cabanas.garcia.ismael.inventory.domain.productStock;

import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import cabanas.garcia.ismael.inventory.domain.storeroom.StoreroomId;

import java.util.Optional;

public interface ProductStockRepository {
    void save(ProductStock productStock);

    Optional<ProductStock> findBy(StoreroomId storeroomId, ProductId productId);
}
