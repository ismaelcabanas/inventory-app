package cabanas.garcia.ismael.inventory.domain.storeroom.model;

import cabanas.garcia.ismael.inventory.domain.common.TextStub;

public final class StoreroomStub {

    private StoreroomStub() { }

    public static Storeroom random() {
        return Storeroom.builder(TextStub.random(20))
                .withId(StoreroomIdStub.random())
                .build();
    }
}
