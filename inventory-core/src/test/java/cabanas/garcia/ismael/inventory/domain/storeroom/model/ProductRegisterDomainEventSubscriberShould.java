package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.model.Stock;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import cabanas.garcia.ismael.inventory.domain.product.ProductRegisteredDomainEvent;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.FakeProductStockRepository;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.FakeStoreroomRepository;
import org.junit.Test;

import java.util.UUID;

public class ProductRegisterDomainEventSubscriberShould {

    private FakeProductStockRepository fakeProductStockRepository;

    @Test public void
    persist_a_new_product_with_stock_0_in_storeroom_when_handle_a_product_registered_event() {
        Storeroom storeroom = StoreroomStub.random();
        FakeStoreroomRepository fakeStoreroomRepository = new FakeStoreroomRepository();
        fakeStoreroomRepository.create(storeroom);
        fakeProductStockRepository = new FakeProductStockRepository();
        ProductRegisterDomainEventSubscriber subscriber =
                new ProductRegisterDomainEventSubscriber(fakeStoreroomRepository, fakeProductStockRepository);
        String productId = UUID.randomUUID().toString();
        ProductRegisteredDomainEvent productRegisteredDomainEvent = new ProductRegisteredDomainEvent(productId);

        subscriber.handle(productRegisteredDomainEvent);

        verifyProductInStoreroomWithStockZeroWasSaved(storeroom, productId);
    }

    private void verifyProductInStoreroomWithStockZeroWasSaved(Storeroom storeroom, String productId) {
        fakeProductStockRepository.verifyProductStockWasSavedInStoreroom(storeroom,
                ProductId.builder(productId).build(), Stock.NONE);
    }
}
