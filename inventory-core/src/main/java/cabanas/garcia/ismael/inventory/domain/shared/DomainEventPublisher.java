package cabanas.garcia.ismael.inventory.domain.shared;

public interface DomainEventPublisher {

    /**
     * Subscribes a subscriber to handle a event.
     *
     * @param subscriber
     */
    void subscribe(DomainEventSubscriber subscriber);

    /**
     * Publish a domain event.
     *
     * @param domainEvent
     */
    void publish(DomainEvent domainEvent);
}
