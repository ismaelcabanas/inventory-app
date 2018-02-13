package cabanas.garcia.ismael.inventory.storeroom.application;

import cabanas.garcia.ismael.inventory.storeroom.domain.model.*;
import cabanas.garcia.ismael.inventory.storeroom.domain.repository.StoreroomRepository;

public class ConsumeStoreroomService {
    private final StoreroomRepository storeroomRepository;

    public ConsumeStoreroomService(StoreroomRepository storeroomRepository) {
        this.storeroomRepository = storeroomRepository;
    }

    public void consume(StoreroomId storeroomId, ProductId productId, int amountStock) {
        Storeroom storeroom =
                storeroomRepository.findById(storeroomId).orElseThrow(() -> new StoreroomNotFoundException(storeroomId));

        storeroom.consume(productId, new Stock(amountStock));

        storeroomRepository.save(storeroom);
    }
}
