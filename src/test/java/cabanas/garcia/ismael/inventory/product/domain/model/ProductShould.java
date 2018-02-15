package cabanas.garcia.ismael.inventory.product.domain.model;

import cabanas.garcia.ismael.inventory.common.domain.DomainEvent;
import cabanas.garcia.ismael.inventory.common.domain.DomainEventPublisher;
import cabanas.garcia.ismael.inventory.common.domain.DomainEventSubscriber;
import cabanas.garcia.ismael.inventory.product.domain.event.ProductRegisteredEvent;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductShould {

    public static final String SOME_PRODUCT_NAME = "PRODUCT A";
    @Rule public ExpectedException exception = ExpectedException.none();

    @Test public void
    throw_exception_if_name_not_present_when_create_instance() {
        exception.expect(RuntimeException.class);

        new Product(null);
    }

    @Test public void
    verify_integrity_of_product_when_create_an_instance() {
        Product product = new Product(SOME_PRODUCT_NAME);

        assertThat(product.id()).isNotNull();
    }

    @Test public void
    publish_event_when_product_is_registered() {
        SpySubscriber spySubscriber = new SpySubscriber();
        DomainEventPublisher.getInstance().subscribe(spySubscriber);

        Product product = new Product(SOME_PRODUCT_NAME);

        assertProductRegisteredEventPublished(spySubscriber, product.id());
        
        DomainEventPublisher.getInstance().unsubscribe(spySubscriber);
    }

    private void assertProductRegisteredEventPublished(SpySubscriber subscriber, ProductId productId) {
        assertThat(subscriber.getDomainEventHandled()).isInstanceOf(ProductRegisteredEvent.class);
        assertThat(((ProductRegisteredEvent) subscriber.getDomainEventHandled()).getProductId()).isEqualTo(productId);
    }

    private class SpySubscriber implements DomainEventSubscriber {
        private DomainEvent domainEventHandled;

        @Override
        public boolean isSubscribedTo(DomainEvent domainEvent) {
            return true;
        }

        @Override
        public void handle(DomainEvent domainEvent) {
            this.domainEventHandled = domainEvent;
        }

        public DomainEvent getDomainEventHandled() {
            return domainEventHandled;
        }
    }
}
