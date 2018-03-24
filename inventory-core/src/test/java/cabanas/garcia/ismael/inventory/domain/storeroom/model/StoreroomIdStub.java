package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.UUIDStub;

public final class StoreroomIdStub {

    private StoreroomIdStub() { }


    public static StoreroomId random() {
        return StoreroomId.builder(UUIDStub.random())
                .build();
    }
}
