package cabanas.garcia.ismael.inventory.common.domain;

import java.util.ArrayList;
import java.util.List;

public class DomainEventPublisher {
    private static DomainEventPublisher instance = null;

    private final List<DomainEventSubscriber> subscribers;

    private DomainEventPublisher() {
        subscribers = new ArrayList<>();
    }

    public static DomainEventPublisher getInstance() {
        if (instance == null) {
            instance = new DomainEventPublisher();
        }

        return instance;
    }

    public void subscribe(DomainEventSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void publish(DomainEvent domainEvent) {
        subscribers.stream()
                .filter(subscriber -> subscriber.isSubscribedTo(domainEvent))
                .forEach(subscriber -> subscriber.handle(domainEvent));
    }

    public void unsubscribe(DomainEventSubscriber subscriber) {
        subscribers.remove(subscriber);
    }
}
