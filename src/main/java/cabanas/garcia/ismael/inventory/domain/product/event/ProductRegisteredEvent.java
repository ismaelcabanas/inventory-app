package cabanas.garcia.ismael.inventory.domain.product.event;

import cabanas.garcia.ismael.inventory.domain.common.DomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductRegisteredEvent implements DomainEvent {
    private final String productId;
    private final UUID id;
    private LocalDateTime ocurredOn;

    public ProductRegisteredEvent(String productId) {
        this.productId = productId;
        this.id = UUID.randomUUID();
        this.ocurredOn = LocalDateTime.now();
    }

    @Override
    public UUID eventId() {
        return id;
    }

    @Override
    public LocalDateTime ocurredOn() {
        return ocurredOn;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public String toString() {
        return "ProductRegisteredEvent{"
                + "productId='" + productId + '\''
                + ", id=" + id
                + ", ocurredOn=" + ocurredOn
                + '}';
    }
}
