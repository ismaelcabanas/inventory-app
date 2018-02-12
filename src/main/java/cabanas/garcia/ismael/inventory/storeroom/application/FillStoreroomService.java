package cabanas.garcia.ismael.inventory.storeroom.application;

import cabanas.garcia.ismael.inventory.storeroom.domain.model.*;
import cabanas.garcia.ismael.inventory.storeroom.domain.repository.StoreroomRepository;

public class FillStoreroomService {
    private final StoreroomRepository storeroomRepository;

    public FillStoreroomService(StoreroomRepository storeroomRepository) {
        this.storeroomRepository = storeroomRepository;
    }

    public void fill(StoreroomId storeroomId, ProductId productId, int amount) {
        Storeroom storeroom =
                storeroomRepository.findById(storeroomId).orElseThrow(() -> new StoreroomNotFoundException(storeroomId));

        storeroom.fill(productId, new Stock(amount));

        storeroomRepository.save(storeroom);
    }
}
