package cabanas.garcia.ismael.inventory.application.storeroom;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;

public class RegisterStoreroomService {
    private final StoreroomRepository storeroomRepository;

    public RegisterStoreroomService(StoreroomRepository storeroomRepository) {
        this.storeroomRepository = storeroomRepository;
    }

    public void register(Storeroom storeroom) {
        storeroomRepository.create(storeroom);
    }
}
