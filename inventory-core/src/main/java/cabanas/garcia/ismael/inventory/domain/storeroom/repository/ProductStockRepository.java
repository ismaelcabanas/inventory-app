package cabanas.garcia.ismael.inventory.domain.storeroom.repository;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;

public interface ProductStockRepository {
    void save(StoreroomId storeroomId, ProductStock productStock);
}
