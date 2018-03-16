package cabanas.garcia.ismael.inventory.domain.shared;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DomainEvent {
    UUID eventId();
    LocalDateTime ocurredOn();
}
