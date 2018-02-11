package cabanas.garcia.ismael.inventory.storeroom.domain.repository;

import cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom.Storeroom;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom.StoreroomId;

import java.util.Optional;

public interface StoreroomRepository {
    void save(Storeroom storeroom);

    Optional<Storeroom> findById(StoreroomId storeroomId);
}
