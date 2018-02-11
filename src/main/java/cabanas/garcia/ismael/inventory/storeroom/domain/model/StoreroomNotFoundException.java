package cabanas.garcia.ismael.inventory.storeroom.domain.model;

import cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom.StoreroomId;

import java.text.MessageFormat;

public class StoreroomNotFoundException extends RuntimeException {
    public StoreroomNotFoundException(StoreroomId storeroomId) {
        super(MessageFormat.format("The Storeroom %s not found.", storeroomId.id()));
    }
}
