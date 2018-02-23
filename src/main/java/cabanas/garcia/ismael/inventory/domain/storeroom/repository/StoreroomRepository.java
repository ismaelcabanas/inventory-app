package cabanas.garcia.ismael.inventory.domain.storeroom.repository;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;

import java.util.List;
import java.util.Optional;

public interface StoreroomRepository {
    void save(Storeroom storeroom);

    void saveProductStock(ProductStock productStock);

    Optional<Storeroom> findById(StoreroomId storeroomId);

    List<Storeroom> findAll();

    void create(Storeroom storeroom);
}
