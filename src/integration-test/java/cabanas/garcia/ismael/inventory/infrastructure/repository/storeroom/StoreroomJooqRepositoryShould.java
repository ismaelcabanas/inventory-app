package cabanas.garcia.ismael.inventory.infrastructure.repository.storeroom;

import cabanas.garcia.ismael.inventory.Application;
import cabanas.garcia.ismael.inventory.IntegrationTest;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Stock;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;
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
public class StoreroomJooqRepositoryShould {
    private static final String SOME_NAME = "TEST";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DSLContext dslContext;


    @Transactional
    @Test
    public void create_storeroom() {
        StoreroomRepository storeroomRepository = new StoreroomJooqRepository(dslContext);
        Storeroom storeroom = new Storeroom(SOME_NAME);

        storeroomRepository.create(storeroom);

        assertThat(DataBaseTestUtils.numberOfInsertedInStoreroomTable(jdbcTemplate)).isEqualTo(1);
    }

    @Transactional
    @Test
    public void save_product_stock_in_storeroom() {
        StoreroomRepository storeroomRepository = new StoreroomJooqRepository(dslContext);
        Storeroom storeroom = new Storeroom(SOME_NAME);
        storeroomRepository.save(storeroom);
        ProductStock productStock = new ProductStock(storeroom, new ProductId(), new Stock(20));

        storeroomRepository.saveProductStock(productStock);

        assertThat(DataBaseTestUtils.numberOfInsertedProductStockInStoreroomTable(jdbcTemplate)).isEqualTo(1);
    }
}
