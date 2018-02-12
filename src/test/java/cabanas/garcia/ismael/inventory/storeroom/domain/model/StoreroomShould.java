package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreroomShould {

    private static final ProductId SOME_PRODUCT_ID = new ProductId();
    private static final ProductId SOME_WRONG_PRODUCT_ID = new ProductId();
    private static final String STOREROOM_NAME = "TEST Storeroom";
    private static final Stock STOCK_OF_FIVE = new Stock(5);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Storeroom storeroom;

    @Before public void
    setUp() {
        storeroom = new Storeroom(new StoreroomId(), STOREROOM_NAME);
        ProductStock productStock = new ProductStock(SOME_PRODUCT_ID, 20);
        storeroom.load(productStock);
    }

    @Test public void
    fill_with_new_amount_of_given_product() {

        storeroom.fill(SOME_PRODUCT_ID, STOCK_OF_FIVE);

        assertThat(storeroom.stockOf(SOME_PRODUCT_ID)).isEqualTo(new Stock(25));
    }

    @Test public void
    fill_throw_exception_when_product_not_in_storeroom() {
        exception.expect(ProductNotFoundException.class);

        storeroom.fill(SOME_WRONG_PRODUCT_ID, STOCK_OF_FIVE);
    }

    @Test public void
    get_stock_of_given_product() {

        Stock stock = storeroom.stockOf(SOME_PRODUCT_ID);

        assertThat(stock).isEqualTo(new Stock(20));
    }

    @Test public void
    throw_exception_when_get_stock_from_product_not_in_storeroom() {
        exception.expect(ProductNotFoundException.class);

        storeroom.stockOf(SOME_WRONG_PRODUCT_ID);
    }
}
