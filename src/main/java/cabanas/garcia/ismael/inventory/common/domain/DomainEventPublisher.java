package cabanas.garcia.ismael.inventory.common.domain;

import java.util.ArrayList;
import java.util.List;

public class DomainEventPublisher {

    private final List<DomainEventSubscriber> subscribers;

    private DomainEventPublisher() {
        subscribers = new ArrayList<>();
    }

    private static class LazyHolder {
        static final DomainEventPublisher INSTANCE = new DomainEventPublisher();
    }

    public static DomainEventPublisher getInstance() {
        return LazyHolder.INSTANCE;
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
