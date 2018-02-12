package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreroomShould {

    private static final ProductId SOME_PRODUCT_ID = new ProductId();
    private static final ProductId SOME_WRONG_PRODUCT_ID = new ProductId();
    private static final String STOREROOM_NAME = "TEST Storeroom";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test public void
    fill_with_new_amount_of_given_product() {
        Storeroom storeroom = new Storeroom(new StoreroomId(), STOREROOM_NAME);
        ProductStock productStock = new ProductStock(SOME_PRODUCT_ID, 20);
        storeroom.load(productStock);

        storeroom.fill(SOME_PRODUCT_ID, 5);

        assertThat(storeroom.stockOf(SOME_PRODUCT_ID)).isEqualTo(new Stock(25));
    }

    @Test public void
    fill_throw_exception_when_product_not_in_storeroom() {
        Storeroom storeroom = new Storeroom(new StoreroomId(), STOREROOM_NAME);
        ProductStock productStock = new ProductStock(SOME_PRODUCT_ID, 20);
        storeroom.load(productStock);
        exception.expect(ProductNotFoundException.class);

        storeroom.fill(SOME_WRONG_PRODUCT_ID, 5);
    }
/*
    private static final int ZERO = 0;
    private static final int FIVE = 5;
    private static final int TWO = 2;
    private static final int SEVEN = 7;
    private Storeroom storeroom;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before public void
    setUp() {
        StoreroomId storeroomId = new StoreroomId();
        String someName = "SomeName";
        storeroom = new Storeroom(storeroomId, someName);

    }

    @Test public void
    add_new_products_to_storeroom() {
        Product apple = new Product("2", "Apple");

        storeroom.fill(apple);

        assertThat(storeroom.stock(apple)).isEqualTo(ZERO);
    }

    @Test public void
    add_stock_to_storeroom() {
        Product apple = new Product("2", "Apple");
        storeroom.fill(apple);

        storeroom.addStock(apple, FIVE);
        storeroom.addStock(apple, TWO);

        assertThat(storeroom.stock(apple)).isEqualTo(SEVEN);
    }

    @Test public void
    consume_stock_from_storeroom() {
        Product apple = new Product("2", "Apple");
        storeroom.fill(apple);
        storeroom.addStock(apple, SEVEN);

        storeroom.consumeStock(apple, FIVE);

        assertThat(storeroom.stock(apple)).isEqualTo(TWO);
    }

    @Test public void
    out_of_stock_when_consume_all_products() {
        Product apple = new Product("2", "Apple");
        storeroom.fill(apple);
        storeroom.addStock(apple, TWO);
        exception.expect(OutOfStockException.class);

        storeroom.consumeStock(apple, 3);

    }
*/
}
