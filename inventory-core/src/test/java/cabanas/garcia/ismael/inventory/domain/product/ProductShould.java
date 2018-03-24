package cabanas.garcia.ismael.inventory.domain.product;

import cabanas.garcia.ismael.inventory.domain.common.TextStub;
import cabanas.garcia.ismael.inventory.domain.shared.DomainEvent;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductShould {

    private static final String SOME_PRODUCT_NAME = TextStub.random(20);
    private static final ProductId SOME_PRODUCT_ID = ProductIdStub.random();
    @Rule public ExpectedException exception = ExpectedException.none();

    @Test public void
    verify_integrity_of_product_when_create_an_instance() {
        Product product = Product.builder(SOME_PRODUCT_NAME).withId(SOME_PRODUCT_ID).build();

        assertThat(product.id()).isNotNull();
    }

    @Test public void
    register_event_when_product_is_created() {
        ProductId productId = ProductIdStub.random();

        Product product = Product.create(SOME_PRODUCT_NAME, productId);

        ProductRegisteredDomainEvent domainEvent = new ProductRegisteredDomainEvent(productId.value());

        assertProductRegisteredEventIsRegistered(product.pullDomainEvents(), domainEvent);
    }

    private void assertProductRegisteredEventIsRegistered(List<DomainEvent> domainEvents, ProductRegisteredDomainEvent domainEvent) {
        assertThat(domainEvents.size()).isEqualTo(1);
        assertThat(domainEvents.get(0)).isInstanceOf(ProductRegisteredDomainEvent.class);
        assertThat(((ProductRegisteredDomainEvent) domainEvents.get(0)).getProductId()).isEqualTo(domainEvent.getProductId());
    }

}
