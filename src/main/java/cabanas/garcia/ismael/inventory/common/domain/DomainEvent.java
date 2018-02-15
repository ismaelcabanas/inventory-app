package cabanas.garcia.ismael.inventory.common.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DomainEvent {
    UUID eventId();
    LocalDateTime ocurredOn();
}
