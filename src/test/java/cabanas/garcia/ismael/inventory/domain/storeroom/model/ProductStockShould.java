package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductStockShould {

    private static final Stock ACTUAL_STOCK = new Stock(5);
    private static final String SOME_STOREROOM_NAME = "TEST STOREROOM";
    private static final Storeroom SOME_STOREROOM = Storeroom.builder(SOME_STOREROOM_NAME).build();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test public void
    add_stock() {
        ProductId productId = new ProductId();
        ProductStock productStock = new ProductStock(SOME_STOREROOM, productId, ACTUAL_STOCK);

        productStock.addStock(new Stock(5));

        assertThat(productStock.stock()).isEqualTo(new Stock(10));
    }

    @Test public void
    throw_exception_if_product_not_present_when_create_instance() {
        expectedException.expect(NullPointerException.class);

        new ProductStock(SOME_STOREROOM, null, ACTUAL_STOCK);
    }

    @Test public void
    throw_exception_if_stock_not_present_when_create_instance() {
        expectedException.expect(NullPointerException.class);

        new ProductStock(SOME_STOREROOM, new ProductId(), null);
    }

    @Test public void
    throw_exception_if_storeroom_not_present_when_create_instance() {
        expectedException.expect(NullPointerException.class);

        new ProductStock(null, new ProductId(), ACTUAL_STOCK);
    }

    @Test public void
    remove_stock() {
        ProductId productId = new ProductId();
        ProductStock productStock = new ProductStock(SOME_STOREROOM, productId, ACTUAL_STOCK);

        productStock.removeStock(new Stock(3));

        assertThat(productStock.stock()).isEqualTo(new Stock(2));
    }

}
