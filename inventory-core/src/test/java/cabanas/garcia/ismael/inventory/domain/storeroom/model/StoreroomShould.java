package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.TextStub;
import cabanas.garcia.ismael.inventory.domain.common.model.Stock;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import cabanas.garcia.ismael.inventory.domain.product.ProductIdStub;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.exceptions.ProductNotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreroomShould {

    private static final ProductId SOME_PRODUCT_ID = ProductIdStub.random();
    private static final ProductId SOME_WRONG_PRODUCT_ID = ProductIdStub.random();
    private static final String STOREROOM_NAME = TextStub.random(20);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private Storeroom storeroom;

    @Before public void
    setUp() {
        storeroom = new Storeroom(STOREROOM_NAME);
        storeroom.load(SOME_PRODUCT_ID, new Stock(20));
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
