package cabanas.garcia.ismael.inventory.product.stubs;

import cabanas.garcia.ismael.inventory.product.domain.model.Product;
import cabanas.garcia.ismael.inventory.product.domain.repository.ProductRepository;
import org.assertj.core.api.Assertions;
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
