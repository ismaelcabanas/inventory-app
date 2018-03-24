package cabanas.garcia.ismael.inventory.domain.common.model;

import cabanas.garcia.ismael.inventory.domain.common.NumberStub;

public final class StockStub {

    private StockStub() { }


    public static Stock random() {
        return new Stock(NumberStub.randomPositive());
    }
}
