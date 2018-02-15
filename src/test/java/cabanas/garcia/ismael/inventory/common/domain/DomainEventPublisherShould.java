package cabanas.garcia.ismael.inventory.common.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainEventPublisherShould {

    @Test public void
    notify_to_subscribers_when_publish_event() {
        SpySubscriber spySubscriber = new SpySubscriber("test-event");
        FakeDomainEvent fakeDomainEvent = new FakeDomainEvent("test-event");
        subscribe(spySubscriber);

        publish(fakeDomainEvent);

        assertEventHandled(spySubscriber, fakeDomainEvent);
    }

    @Test public void
    not_notify_to_subscribers_not_subscribed() {
        SpySubscriber spySubscriber = new SpySubscriber("test-event");
        FakeDomainEvent fakeDomainEvent = new FakeDomainEvent("other-test-event");
        subscribe(spySubscriber);

        publish(fakeDomainEvent);

        assertEventNotHandled(spySubscriber, fakeDomainEvent);
    }

    @Test public void
    unsubscribe_subscriber_subscribed() {
        SpySubscriber spySubscriber = new SpySubscriber("test-event");
        FakeDomainEvent fakeDomainEvent = new FakeDomainEvent("test-event");
        subscribe(spySubscriber);
        unsubscribe(spySubscriber);

        publish(fakeDomainEvent);

        assertEventNotHandled(spySubscriber, fakeDomainEvent);
    }

    private void subscribe(DomainEventSubscriber subscriber) {
        DomainEventPublisher.getInstance().subscribe(subscriber);
    }

    private void publish(DomainEvent domainEvent) {
        DomainEventPublisher.getInstance().publish(domainEvent);
    }

    private void unsubscribe(DomainEventSubscriber subscriber) {
        DomainEventPublisher.getInstance().unsubscribe(subscriber);
    }

    private void assertEventNotHandled(SpySubscriber subscriber, DomainEvent domainEvent) {
        assertThat(subscriber.isHandled()).isFalse();
        assertThat(subscriber.hasHandled(domainEvent)).isFalse();
    }


    private void assertEventHandled(SpySubscriber subscriber, DomainEvent domainEvent) {
        assertThat(subscriber.isHandled()).isTrue();
        assertThat(subscriber.hasHandled(domainEvent)).isTrue();
    }

    private class SpySubscriber implements DomainEventSubscriber {
        private final String eventName;
        private Optional<DomainEvent> domainEventHandled = Optional.empty();
        private boolean isHandle;

        public SpySubscriber(String eventName) {
            this.eventName = eventName;
            this.isHandle = false;
        }

        @Override
        public boolean isSubscribedTo(DomainEvent domainEvent) {
            FakeDomainEvent fakeDomainEvent = (FakeDomainEvent) domainEvent;
            return eventName.equals(fakeDomainEvent.eventName);
        }

        @Override
        public void handle(DomainEvent domainEvent) {
            this.domainEventHandled = Optional.of(domainEvent);
            this.isHandle = true;
        }


        public boolean hasHandled(DomainEvent domainEvent) {
            if(domainEventHandled.isPresent()) {
                return domainEventHandled.get().equals(domainEvent);
            }
            return false;
        }

        public boolean isHandled() {
            return isHandle;
        }
    }

    private class FakeDomainEvent implements DomainEvent {

        private final String eventName;
        private final UUID uuid;

        public FakeDomainEvent(String eventName) {
            this.eventName = eventName;
            this.uuid = UUID.randomUUID();
        }

        @Override
        public UUID eventId() {
            return uuid;
        }

        @Override
        public LocalDateTime ocurredOn() {
            return LocalDateTime.now();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            FakeDomainEvent that = (FakeDomainEvent) o;

            return new EqualsBuilder()
                    .append(uuid, that.uuid)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(uuid)
                    .toHashCode();
        }
    }
}
