package cabanas.garcia.ismael.inventory.domain.storeroom;

import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductStockShould {

    private static final Stock ACTUAL_STOCK = new Stock(5);
    private static final String SOME_STOREROOM_NAME = "TEST STOREROOM";
    private static final Storeroom SOME_STOREROOM = Storeroom.builder(SOME_STOREROOM_NAME).build();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test public void
    throw_exception_if_product_not_present_when_create_instance() {
        expectedException.expect(NullPointerException.class);

        new ProductStockItem(SOME_STOREROOM.id(), null, ACTUAL_STOCK);
    }

    @Test public void
    throw_exception_if_stock_not_present_when_create_instance() {
        expectedException.expect(NullPointerException.class);

        new ProductStockItem(SOME_STOREROOM.id(), new ProductId(), null);
    }

    @Test public void
    throw_exception_if_storeroom_not_present_when_create_instance() {
        expectedException.expect(NullPointerException.class);

        new ProductStockItem(null, new ProductId(), ACTUAL_STOCK);
    }

}
