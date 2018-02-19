package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.product.event.ProductRegisteredEvent;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;
import cabanas.garcia.ismael.inventory.stubs.StoreroomSuccessRepositoryStub;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.UUID;

public class ProductRegisterDomainEventSubscriberShould {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock private StoreroomRepository storeroomRepository;

    private StoreroomSuccessRepositoryStub storeroomSuccessRepositoryStub;

    @Test public void
    persist_a_new_product_with_stock_0_in_storeroom_when_handle_a_product_registered_event() {
        Storeroom storeroom = new Storeroom("Test");
        storeroomSuccessRepositoryStub = new StoreroomSuccessRepositoryStub(storeroomRepository, storeroom);
        ProductRegisterDomainEventSubscriber subscriber =
                new ProductRegisterDomainEventSubscriber(storeroomSuccessRepositoryStub);
        String productId = UUID.randomUUID().toString();
        ProductRegisteredEvent productRegisteredEvent = new ProductRegisteredEvent(productId);

        subscriber.handle(productRegisteredEvent);

        verifySaveProductInStoreroomWithStockZero(storeroom.id(), productId);
    }

    private void verifySaveProductInStoreroomWithStockZero(StoreroomId storeroomId, String productId) {
        storeroomSuccessRepositoryStub.verifySaveProductInStoreroomWithStock(storeroomId,
                ProductId.builder(productId).build(), Stock.NONE);
    }
}
