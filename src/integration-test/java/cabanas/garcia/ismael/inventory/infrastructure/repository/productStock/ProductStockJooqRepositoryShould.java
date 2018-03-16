package cabanas.garcia.ismael.inventory.infrastructure.repository.productStock;

import cabanas.garcia.ismael.inventory.Application;
import cabanas.garcia.ismael.inventory.IntegrationTest;
import cabanas.garcia.ismael.inventory.domain.product.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.productStock.repository.ProductStockRepository;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;
import cabanas.garcia.ismael.inventory.infrastructure.repository.util.DataBaseTestUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Category(IntegrationTest.class)
@ActiveProfiles("integration-test")
public class ProductStockJooqRepositoryShould {
    private static final StoreroomId SOME_STOREROOM_ID = new StoreroomId();
    private static final ProductId SOME_PRODUCT_ID = new ProductId();
    private static final int SOME_AMOUNT = 5;
    private static final Stock SOME_STOCK = new Stock(SOME_AMOUNT);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductStockRepository productStockRepository;

    @Transactional
    @Test public void
    save_product() {
        ProductStock product = new ProductStock(SOME_STOREROOM_ID, SOME_PRODUCT_ID, SOME_STOCK);

        productStockRepository.save(product);

        assertThat(DataBaseTestUtils.numberOfInsertedProductStockInTable(jdbcTemplate)).isEqualTo(1);
    }

    @Transactional
    @Test
    public void find_product_stock_of_storeroom() {
        ProductStock productStock = new ProductStock(SOME_STOREROOM_ID, SOME_PRODUCT_ID, SOME_STOCK);
        productStockRepository.save(productStock);

        Optional<ProductStock> productStockActual = productStockRepository.findBy(SOME_STOREROOM_ID, SOME_PRODUCT_ID);

        assertThat(productStockActual.isPresent()).isTrue();
        assertThat(productStockActual.get().product()).isEqualTo(SOME_PRODUCT_ID);
        assertThat(productStockActual.get().storeroom()).isEqualTo(SOME_STOREROOM_ID);
        assertThat(productStockActual.get().stock()).isEqualTo(SOME_STOCK);
    }
}
