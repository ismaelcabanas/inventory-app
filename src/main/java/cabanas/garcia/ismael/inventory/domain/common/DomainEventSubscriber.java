package cabanas.garcia.ismael.inventory.domain.common;

public interface DomainEventSubscriber {
    boolean isSubscribedTo(DomainEvent domainEvent);

    void handle(DomainEvent domainEvent);
}
