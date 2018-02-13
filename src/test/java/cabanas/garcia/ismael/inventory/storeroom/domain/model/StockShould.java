package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class StockShould {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test public void
    throw_exception_when_stock_less_than_0() {
        expectedException.expect(InvalidStockException.class);

        new Stock(-5);
    }

    @Test public void
    increase_stock() {
        Stock stockOfFive = new Stock(5);

        Stock stock = stockOfFive.increase(new Stock(3));

        assertThat(stock).isEqualTo(new Stock(8));
    }
}
