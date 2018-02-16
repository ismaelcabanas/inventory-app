package cabanas.garcia.ismael.inventory.product.domain.event;

import cabanas.garcia.ismael.inventory.common.domain.DomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductRegisteredEvent implements DomainEvent {
    private final String productId;
    private final UUID id;

    public ProductRegisteredEvent(String productId) {
        this.productId = productId;
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID eventId() {
        return id;
    }

    @Override
    public LocalDateTime ocurredOn() {
        return LocalDateTime.now();
    }

    public String getProductId() {
        return productId;
    }
}
