package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductStockShould {

    private static final Stock ACTUAL_STOCK = new Stock(5);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test public void
    add_stock() {
        ProductId productId = new ProductId();
        ProductStock productStock = new ProductStock(productId, ACTUAL_STOCK);

        productStock.addStock(new Stock(5));

        assertThat(productStock.stock()).isEqualTo(new Stock(10));
    }

    @Test public void
    throw_exception_if_product_not_present_when_create_instance() {
        expectedException.expect(NullPointerException.class);

        new ProductStock(null, ACTUAL_STOCK);
    }

}
