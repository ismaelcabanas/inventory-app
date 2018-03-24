package cabanas.garcia.ismael.inventory.domain.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DefaultDomainEventPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultDomainEventPublisher.class.getName());

    private final List<DomainEventSubscriber> subscribers;

    private DefaultDomainEventPublisher() {
        subscribers = new ArrayList<>();
    }

    private static class LazyHolder {
        static final DefaultDomainEventPublisher INSTANCE = new DefaultDomainEventPublisher();
    }

    public static DefaultDomainEventPublisher getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void subscribe(DomainEventSubscriber subscriber) {
        subscribers.add(subscriber);
        LOGGER.debug("Subscriber {} subscribed", subscriber);
    }

    public void publish(DomainEvent domainEvent) {
        subscribers.stream()
                .filter(subscriber -> subscriber.isSubscribedTo(domainEvent))
                .forEach(subscriber -> subscriber.handle(domainEvent));
        LOGGER.debug("Domain event {} published", domainEvent);
    }

    public void unsubscribe(DomainEventSubscriber subscriber) {
        subscribers.remove(subscriber);
        LOGGER.debug("Subscriber {} unsubscribd", subscriber);
    }
}
