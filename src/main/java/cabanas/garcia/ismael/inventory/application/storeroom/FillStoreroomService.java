package cabanas.garcia.ismael.inventory.application.storeroom;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.Stock;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.exceptions.StoreroomNotFoundException;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;

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
