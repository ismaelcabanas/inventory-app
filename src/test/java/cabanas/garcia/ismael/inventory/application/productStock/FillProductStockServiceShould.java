package cabanas.garcia.ismael.inventory.application.productStock;

import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.productStock.model.StoreroomId;
import cabanas.garcia.ismael.inventory.domain.productStock.repository.ProductStockRepository;
import cabanas.garcia.ismael.inventory.stubs.ProductStockSuccessRepositoryStub;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class FillProductStockServiceShould {
    private static final int FIVE_UNITS = 5;
    private static final int TEN_UNITS = 10;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private ProductStockRepository productStockRepositoryMock;

    private ProductStockSuccessRepositoryStub productStockSuccessRepositoryStub;

    @Test public void
    fill_stock_of_product_in_storeroom() {
        ProductId productId = new ProductId();
        StoreroomId storeroomId = new StoreroomId();
        Stock initialStock = new Stock(FIVE_UNITS);
        ProductStock productStock = new ProductStock(storeroomId, productId, initialStock);
        productStockSuccessRepositoryStub = new ProductStockSuccessRepositoryStub(productStockRepositoryMock, productStock);
        FillProductStockService fillProductStockService = new FillProductStockService(productStockSuccessRepositoryStub);

        fillProductStockService.fill(storeroomId, productId, FIVE_UNITS);

        verifyProductWithStockIsSavedInStoreroom(new Stock(TEN_UNITS));
    }

    private void verifyProductWithStockIsSavedInStoreroom(Stock stock) {
        productStockSuccessRepositoryStub.verifyProductWithStockIsSavedInStoreroom(stock);
    }
}
