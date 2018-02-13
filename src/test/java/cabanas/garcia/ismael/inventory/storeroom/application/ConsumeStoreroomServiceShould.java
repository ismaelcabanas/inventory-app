package cabanas.garcia.ismael.inventory.storeroom.application;

import cabanas.garcia.ismael.inventory.storeroom.domain.model.ProductId;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.Stock;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.Storeroom;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.StoreroomId;
import cabanas.garcia.ismael.inventory.storeroom.domain.repository.StoreroomRepository;
import cabanas.garcia.ismael.inventory.storeroom.stubs.StoreroomSuccessRepositoryStub;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static cabanas.garcia.ismael.inventory.storeroom.domain.model.StoreroomUtil.anStoreroomWithProductAndStock;

public class ConsumeStoreroomServiceShould {

    private static final int FIVE_UNITS = 5;
    private static final int TWO_UNITS = 2;
    private static final int THREE_UNITS = 3;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock private StoreroomRepository storeroomRepository;

    private StoreroomSuccessRepositoryStub storeroomSuccessRepositoryStub;

    @Test public void
    consume_stock_from_an_existent_product() {
        ProductId productId = new ProductId();
        StoreroomId storeroomId = new StoreroomId();
        Stock initialStock = new Stock(FIVE_UNITS);
        Storeroom storeroom = anStoreroomWithProductAndStock(storeroomId, productId, initialStock);
        storeroomSuccessRepositoryStub = new StoreroomSuccessRepositoryStub(storeroomRepository, storeroom);
        ConsumeStoreroomService consumeStoreroomService = new ConsumeStoreroomService(storeroomSuccessRepositoryStub);

        consumeStoreroomService.consume(storeroomId, productId, TWO_UNITS);

        verifySaveProductInStoreroomWithStock(storeroomId, productId, new Stock(THREE_UNITS));
    }

    private void verifySaveProductInStoreroomWithStock(StoreroomId storeroomId, ProductId productId, Stock stock) {
        storeroomSuccessRepositoryStub.verifySaveProductInStoreroomWithStock(storeroomId, productId, stock);
    }
}
