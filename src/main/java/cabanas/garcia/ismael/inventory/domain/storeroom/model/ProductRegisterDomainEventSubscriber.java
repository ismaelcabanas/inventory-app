package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.DomainEvent;
import cabanas.garcia.ismael.inventory.domain.common.DomainEventSubscriber;
import cabanas.garcia.ismael.inventory.domain.product.event.ProductRegisteredEvent;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;

import java.util.List;

public class ProductRegisterDomainEventSubscriber implements DomainEventSubscriber {
    private final StoreroomRepository storeroomRepository;

    public ProductRegisterDomainEventSubscriber(StoreroomRepository storeroomRepository) {
        this.storeroomRepository = storeroomRepository;
    }

    @Override
    public boolean isSubscribedTo(DomainEvent domainEvent) {
        return false;
    }

    @Override
    public void handle(DomainEvent domainEvent) {
        List<Storeroom> storerooms = storeroomRepository.findAll();

        storerooms.forEach(storeroom -> {
            ProductRegisteredEvent event = (ProductRegisteredEvent) domainEvent;
            ProductStock productStock = new ProductStock(ProductId.builder(event.getProductId()).build());
            storeroom.load(productStock);
            storeroomRepository.save(storeroom);
        });
    }
}
