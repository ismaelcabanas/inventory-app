package cabanas.garcia.ismael.inventory.domain.storeroom.repository;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;

import java.util.List;

public interface StoreroomRepository {
    List<Storeroom> findAll();
    void create(Storeroom storeroom);
}
