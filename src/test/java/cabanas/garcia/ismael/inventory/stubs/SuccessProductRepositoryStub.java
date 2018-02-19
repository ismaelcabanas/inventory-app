package cabanas.garcia.ismael.inventory.stubs;

import cabanas.garcia.ismael.inventory.domain.product.model.Product;
import cabanas.garcia.ismael.inventory.domain.product.repository.ProductRepository;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class SuccessProductRepositoryStub implements ProductRepository {
    private final ProductRepository productRepositoryMock;

    public SuccessProductRepositoryStub(ProductRepository productRepository) {
        this.productRepositoryMock = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepositoryMock.save(product);
    }

    public void verifySaveProduct(Product product) {
        ArgumentCaptor<Product> argCaptorProduct = ArgumentCaptor.forClass(Product.class);
        verify(productRepositoryMock, times(1)).save(argCaptorProduct.capture());

        assertThat(argCaptorProduct.getValue().name()).isEqualTo(product.name());
    }
}
