package cabanas.garcia.ismael.inventory.domain.product;

import cabanas.garcia.ismael.inventory.domain.common.UUIDStub;

public final class ProductIdStub {

    private ProductIdStub() { }


    public static ProductId random() {
        return ProductId.builder(UUIDStub.random())
                .build();
    }
}
