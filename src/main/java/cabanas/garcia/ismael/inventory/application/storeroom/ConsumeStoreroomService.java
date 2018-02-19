package cabanas.garcia.ismael.inventory.application.storeroom;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.Stock;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.exceptions.StoreroomNotFoundException;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;

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
