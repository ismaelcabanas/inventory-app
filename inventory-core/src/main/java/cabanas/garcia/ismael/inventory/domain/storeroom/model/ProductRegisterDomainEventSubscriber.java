package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.model.Stock;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import cabanas.garcia.ismael.inventory.domain.product.ProductRegisteredDomainEvent;
import cabanas.garcia.ismael.inventory.domain.shared.DomainEvent;
import cabanas.garcia.ismael.inventory.domain.shared.DomainEventSubscriber;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.ProductStockRepository;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductRegisterDomainEventSubscriber implements DomainEventSubscriber {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRegisterDomainEventSubscriber.class.getName());

    private final StoreroomRepository storeroomRepository;
    private final ProductStockRepository productStockRepository;

    public ProductRegisterDomainEventSubscriber(StoreroomRepository storeroomRepository,
                                                ProductStockRepository productStockRepository) {
        this.storeroomRepository = storeroomRepository;
        this.productStockRepository = productStockRepository;
    }

    @Override
    public boolean isSubscribedTo(DomainEvent domainEvent) {
        return domainEvent instanceof ProductRegisteredDomainEvent;
    }

    @Override
    public void handle(DomainEvent domainEvent) {
        LOGGER.debug("Handle event {}", domainEvent);
        List<Storeroom> storerooms = storeroomRepository.findAll();

        storerooms.forEach(storeroom -> {
            ProductRegisteredDomainEvent event = (ProductRegisteredDomainEvent) domainEvent;
            productStockRepository.save(storeroom.id(), new ProductStock(ProductId.builder(event.getProductId()).build(),
                    Stock.NONE));
        });
    }
}
