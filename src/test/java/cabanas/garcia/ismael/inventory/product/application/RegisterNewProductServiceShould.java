package cabanas.garcia.ismael.inventory.product.application;

import cabanas.garcia.ismael.inventory.product.domain.model.Product;
import cabanas.garcia.ismael.inventory.product.domain.model.ProductId;
import cabanas.garcia.ismael.inventory.product.domain.model.ProductUtil;
import cabanas.garcia.ismael.inventory.product.domain.repository.ProductRepository;
import cabanas.garcia.ismael.inventory.product.stubs.SuccessProductRepositoryStub;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class RegisterNewProductServiceShould {

    private static final String SOME_PRODUCT = "Product A";

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock private ProductRepository productRepository;

    private SuccessProductRepositoryStub productRepositoryStub;

    @Test public void
    add_new_product() {
        ProductId productId = new ProductId();
        Product product = ProductUtil.someProductWithName(productId, SOME_PRODUCT);
        productRepositoryStub = new SuccessProductRepositoryStub(productRepository, product);
        RegisterNewProductService registerNewProductService = new RegisterNewProductService(productRepositoryStub);

        registerNewProductService.register(SOME_PRODUCT);

        verifySaveProduct(Product.builder().withId(productId).withName(SOME_PRODUCT).build());
    }

    private void verifySaveProduct(Product product) {
        productRepositoryStub.verifySaveProduct(product);
    }
}
