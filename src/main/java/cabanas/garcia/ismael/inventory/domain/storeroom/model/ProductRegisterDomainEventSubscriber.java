package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.DomainEvent;
import cabanas.garcia.ismael.inventory.domain.common.DomainEventSubscriber;
import cabanas.garcia.ismael.inventory.domain.product.event.ProductRegisteredEvent;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductRegisterDomainEventSubscriber implements DomainEventSubscriber {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRegisterDomainEventSubscriber.class.getName());

    private final StoreroomRepository storeroomRepository;

    public ProductRegisterDomainEventSubscriber(StoreroomRepository storeroomRepository) {
        this.storeroomRepository = storeroomRepository;
    }

    @Override
    public boolean isSubscribedTo(DomainEvent domainEvent) {
        return domainEvent instanceof ProductRegisteredEvent;
    }

    @Override
    public void handle(DomainEvent domainEvent) {
        LOGGER.debug("Handle event {}", domainEvent);
        List<Storeroom> storerooms = storeroomRepository.findAll();

        storerooms.forEach(storeroom -> {
            ProductRegisteredEvent event = (ProductRegisteredEvent) domainEvent;
            ProductStock productStock = new ProductStock(storeroom, ProductId.builder(event.getProductId()).build());
            storeroomRepository.saveProductStock(productStock);
        });
    }
}
