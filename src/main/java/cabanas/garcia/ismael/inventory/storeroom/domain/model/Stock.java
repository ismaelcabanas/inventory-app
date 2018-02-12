package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import cabanas.garcia.ismael.inventory.common.ValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Stock extends ValueObject<Stock> {
    public static final Stock NONE = new Stock(0);

    private final int amount;

    public Stock(int amount) {
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
        return "Stock{" +
                "amount=" + amount +
                '}';
    }

    public Stock increase(int stock) {
        return new Stock(amount + stock);
    }

    /*
    private final Storeroom storeroom;
    private final Product product;
    private int quantity;
    */

    /*
    public Stock(Storeroom storeroom, Product product, int quantity) {
        this.storeroom = storeroom;
        this.product = product;
        this.quantity = quantity;
    }


    public Product product() {
        return product;
    }

    public void add(int quantity) {
        this.quantity += quantity;
    }

    public int quantity() {
        return quantity;
    }

    public void remove(int quantity) {
        this.quantity -= quantity;
    }
    */
}
