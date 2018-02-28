package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.exceptions.ProductNotFoundException;
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
        storeroom = new Storeroom(STOREROOM_NAME);
        storeroom.load(SOME_PRODUCT_ID, new Stock(20));
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

    @Test public void
    throw_exception_if_name_not_present_when_create_instance() {
        exception.expect(NullPointerException.class);

        new Storeroom(null);
    }
}
