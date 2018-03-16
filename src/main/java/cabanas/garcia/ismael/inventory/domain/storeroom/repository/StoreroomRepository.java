package cabanas.garcia.ismael.inventory.domain.storeroom.repository;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductStockItem;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;

import java.util.List;
import java.util.Optional;

public interface StoreroomRepository {
    void save(Storeroom storeroom);

    void saveProductStock(ProductStockItem productStockItem);

    Optional<Storeroom> findById(StoreroomId storeroomId);

    List<Storeroom> findAll();

    void create(Storeroom storeroom);
}
