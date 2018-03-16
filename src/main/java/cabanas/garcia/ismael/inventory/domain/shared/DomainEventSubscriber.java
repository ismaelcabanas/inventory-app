package cabanas.garcia.ismael.inventory.domain.shared;

public interface DomainEventSubscriber {
    boolean isSubscribedTo(DomainEvent domainEvent);

    void handle(DomainEvent domainEvent);
}
