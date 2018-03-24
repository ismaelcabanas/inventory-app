package cabanas.garcia.ismael.inventory.domain.common;

import java.util.UUID;

public final class UUIDStub {

    private UUIDStub() {

    }

    public static String random() {
        return UUID.randomUUID().toString();
    }
}
