package cabanas.garcia.ismael.inventory.application.storeroom;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Stock;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;
import cabanas.garcia.ismael.inventory.stubs.StoreroomSuccessRepositoryStub;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomUtil.anStoreroomWithProductAndStock;

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

    private void verifySaveProductInStoreroomWithAmount(StoreroomId storeroomId, ProductId productId, Stock stock) {
        storeroomSuccessRepositoryStub.verifySaveProductInStoreroomWithStock(storeroomId, productId, stock);
    }
}
