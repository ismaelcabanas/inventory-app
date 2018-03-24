package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.model.Stock;
import cabanas.garcia.ismael.inventory.domain.common.model.StockStub;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductStockShould {

    private static final Stock ACTUAL_STOCK = StockStub.random();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test public void
    throw_exception_if_product_not_present_when_create_instance() {
        expectedException.expect(NullPointerException.class);

        new ProductStock(null, ACTUAL_STOCK);
    }

    @Test public void
    throw_exception_if_stock_not_present_when_create_instance() {
        expectedException.expect(NullPointerException.class);

        new ProductStock(new ProductId(), null);
    }
}
