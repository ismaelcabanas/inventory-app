package cabanas.garcia.ismael.inventory.infrastructure.repository.storeroom;

import cabanas.garcia.ismael.inventory.Application;
import cabanas.garcia.ismael.inventory.IntegrationTest;
import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.product.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductStockItem;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;
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
public class StoreroomJooqRepositoryShould {
    private static final String SOME_NAME = "TEST";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StoreroomRepository storeroomRepository;

    @Transactional
    @Test
    public void create_storeroom() {
        Storeroom storeroom = new Storeroom(SOME_NAME);

        storeroomRepository.create(storeroom);

        assertThat(DataBaseTestUtils.numberOfInsertedInStoreroomTable(jdbcTemplate)).isEqualTo(1);
    }

    @Transactional
    @Test
    public void save_product_stock_in_storeroom() {
        Storeroom storeroom = new Storeroom(SOME_NAME);
        storeroomRepository.save(storeroom);
        ProductStockItem productStockItem = new ProductStockItem(storeroom.id(), new ProductId(), new Stock(20));

        storeroomRepository.saveProductStock(productStockItem);

        assertThat(DataBaseTestUtils.numberOfInsertedProductStockInTable(jdbcTemplate)).isEqualTo(1);
    }

    @Transactional
    @Test
    public void find_storeroom_by_id_with_products() {
        Storeroom storeroom = new Storeroom(SOME_NAME);
        storeroomRepository.create(storeroom);
        ProductStockItem productStockItem = new ProductStockItem(storeroom.id(), new ProductId(), new Stock(20));
        storeroomRepository.saveProductStock(productStockItem);

        Optional<Storeroom> storeroomActual = storeroomRepository.findById(storeroom.id());

        assertThat(storeroomActual.isPresent()).isTrue();
        assertThat(storeroomActual.get().name()).isEqualTo(SOME_NAME);
        assertThat(storeroomActual.get().stockOf(productStockItem.productId())).isEqualTo(productStockItem.stock());
    }
}
