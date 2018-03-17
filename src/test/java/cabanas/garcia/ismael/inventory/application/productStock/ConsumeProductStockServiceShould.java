package cabanas.garcia.ismael.inventory.application.productStock;

import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.product.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.productStock.repository.ProductStockRepository;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;
import cabanas.garcia.ismael.inventory.stubs.ProductStockSuccessRepositoryStub;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


public class ConsumeProductStockServiceShould {
    private static final int FIVE_UNITS = 5;
    private static final int TWO_UNITS = 2;
    private static final int THREE_UNITS = 3;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private ProductStockRepository productStockRepository;

    private ProductStockSuccessRepositoryStub productStockSuccessRepositoryStub;

    @Test public void
    consume_product_from_storeroom() {
        ProductId productId = new ProductId();
        StoreroomId storeroomId = new StoreroomId();
        Stock initialStock = new Stock(FIVE_UNITS);
        ProductStock productStock = new ProductStock(storeroomId, productId, initialStock);
        productStockSuccessRepositoryStub = new ProductStockSuccessRepositoryStub(productStockRepository, productStock);
        ConsumeProductStockService consumeStoreroomService = new ConsumeProductStockService(productStockSuccessRepositoryStub);

        consumeStoreroomService.consume(storeroomId, productId, TWO_UNITS);

        verifyProductWithStockIsSavedInStoreroom(new Stock(THREE_UNITS));
    }

    private void verifyProductWithStockIsSavedInStoreroom(Stock stock) {
        productStockSuccessRepositoryStub.verifyProductWithStockIsSavedInStoreroom(stock);
    }
}
