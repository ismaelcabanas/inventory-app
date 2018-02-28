package cabanas.garcia.ismael.inventory.stubs;

import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.productStock.model.Stock;
import cabanas.garcia.ismael.inventory.domain.productStock.model.StoreroomId;
import cabanas.garcia.ismael.inventory.domain.productStock.repository.ProductStockRepository;
import org.assertj.core.api.Assertions;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ProductStockSuccessRepositoryStub implements ProductStockRepository {
    private final ProductStockRepository productStockRepositoryMock;
    private final ProductStock productStock;

    public ProductStockSuccessRepositoryStub(ProductStockRepository productStockRepositoryMock, ProductStock productStock) {
        this.productStockRepositoryMock = productStockRepositoryMock;
        this.productStock = productStock;
    }

    @Override
    public void save(ProductStock theProductStock) {
        productStockRepositoryMock.save(theProductStock);
    }

    @Override
    public ProductStock findBy(StoreroomId storeroomId, ProductId productId) {
        return productStock;
    }

    public void verifyProductWithStockIsSavedInStoreroom(Stock stock) {
        ArgumentCaptor<ProductStock> argumentCaptor = ArgumentCaptor.forClass(ProductStock.class);
        verify(productStockRepositoryMock, times(1)).save(argumentCaptor.capture());
        Assertions.assertThat(argumentCaptor.getValue().stock()).isEqualTo(stock);
    }
}
