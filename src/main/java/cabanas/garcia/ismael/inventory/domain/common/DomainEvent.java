package cabanas.garcia.ismael.inventory.domain.common;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DomainEvent {
    UUID eventId();
    LocalDateTime ocurredOn();
}
