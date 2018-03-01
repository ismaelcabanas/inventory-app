package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.ValueObject;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.exceptions.InvalidStockException;
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

}
