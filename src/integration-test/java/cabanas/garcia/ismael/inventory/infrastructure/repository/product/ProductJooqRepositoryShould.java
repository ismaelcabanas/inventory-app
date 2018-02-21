package cabanas.garcia.ismael.inventory.infrastructure.repository.product;

import cabanas.garcia.ismael.inventory.Application;
import cabanas.garcia.ismael.inventory.IntegrationTest;
import cabanas.garcia.ismael.inventory.domain.product.model.Product;
import cabanas.garcia.ismael.inventory.domain.product.repository.ProductRepository;
import cabanas.garcia.ismael.inventory.infrastructure.repository.util.DataBaseTestUtils;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Category(IntegrationTest.class)
@ActiveProfiles("integration-test")
public class ProductJooqRepositoryShould {

    private static final String SOME_PRODUCT_NAME = "Apple";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DSLContext dslContext;


    @Transactional
    @Test public void
    save_product() {
        ProductRepository productRepository = new ProductJooqRepository(dslContext);
        Product product = new Product(SOME_PRODUCT_NAME);

        productRepository.save(product);

        assertThat(DataBaseTestUtils.numberOfInsertedInProductTable(jdbcTemplate)).isEqualTo(1);
    }
}
