package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import cabanas.garcia.ismael.inventory.common.ValueObject;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.exceptions.InvalidStockException;
import cabanas.garcia.ismael.inventory.storeroom.domain.model.exceptions.NegativeStockException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Stock extends ValueObject<Stock> {
    public static final Stock NONE = new Stock(0);

    private final int amount;

    public Stock(int amount) {
        if (amount < 0) {
            throw new InvalidStockException("Invalid stock. It must be greater or equal than 0");
        }
        this.amount = amount;
    }

    public int value() {
        return amount;
    }

    @Override
    protected int hashCodeCore() {
        return new HashCodeBuilder(17, 37)
                .append(amount)
                .toHashCode();
    }

    @Override
    protected boolean equalsCore(Stock other) {
        return new EqualsBuilder()
                .append(amount, other.amount)
                .isEquals();
    }

    @Override
    public String toString() {
        return "Stock{"
                + "amount=" + amount
                + '}';
    }

    public Stock increase(Stock stock) {
        return new Stock(amount + stock.value());
    }

    public Stock decrease(Stock stock) {
        if (amount - stock.value() < 0) {
            throw new NegativeStockException();
        }
        return new Stock(amount - stock.value());
    }

}
