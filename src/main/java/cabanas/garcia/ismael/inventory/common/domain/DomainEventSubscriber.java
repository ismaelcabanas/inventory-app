package cabanas.garcia.ismael.inventory.common.domain;

public interface DomainEventSubscriber {
    boolean isSubscribedTo(DomainEvent domainEvent);

    void handle(DomainEvent domainEvent);
}
