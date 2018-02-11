package cabanas.garcia.ismael.inventory.storeroom.application;

import cabanas.garcia.ismael.inventory.storeroom.domain.model.ProductId;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom.Stock;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom.Storeroom;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom.StoreroomId;
import cabanas.garcia.ismael.inventory.storeroom.domain.repository.StoreroomRepository;
import cabanas.garcia.ismael.inventory.storeroom.stubs.StoreroomSuccessRepositoryStub;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class FillStoreroomServiceShould {

    private static final int FIVE_UNITS = 5;
    private static final int TEN_UNITS = 10;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock private StoreroomRepository storeroomRepository;

    private StoreroomSuccessRepositoryStub storeroomSuccessRepositoryStub;

    @Test public void
    fill_storeroom_with_some_number_of_given_existent_product() {
        ProductId productId = new ProductId();
        StoreroomId storeroomId = new StoreroomId();
        Stock initialStock = new Stock(FIVE_UNITS);
        Storeroom storeroom = anStoreroomWithProductAndStock(storeroomId, productId, initialStock);
        storeroomSuccessRepositoryStub = new StoreroomSuccessRepositoryStub(storeroomRepository, storeroom);
        FillStoreroomService fillStoreroomService = new FillStoreroomService(storeroomSuccessRepositoryStub);

        fillStoreroomService.fill(storeroomId, productId, FIVE_UNITS);

        verifySaveProductInStoreroomWithAmount(storeroomId, productId, new Stock(TEN_UNITS));
    }

    private Storeroom anStoreroomWithProductAndStock(StoreroomId storeroomId, ProductId productId, Stock stock) {
        Storeroom storeroom = Storeroom.builder(storeroomId)
                .withName("Test Storeroom")
                .build();
        storeroom.addNewProduct(productId, stock.value());
        return storeroom;
    }

    private void verifySaveProductInStoreroomWithAmount(StoreroomId storeroomId, ProductId productId, Stock stock) {
        storeroomSuccessRepositoryStub.verifySaveProductInStoreroomWithStock(storeroomId, productId, stock);
    }
}
