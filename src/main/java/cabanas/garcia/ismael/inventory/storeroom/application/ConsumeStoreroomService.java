package cabanas.garcia.ismael.inventory.storeroom.application;

import cabanas.garcia.ismael.inventory.storeroom.domain.model.Stock;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.StoreroomId;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.ProductId;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.Storeroom;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.exceptions.StoreroomNotFoundException;
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
