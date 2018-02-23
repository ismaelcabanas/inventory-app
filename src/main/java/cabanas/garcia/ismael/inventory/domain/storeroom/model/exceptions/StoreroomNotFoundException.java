package cabanas.garcia.ismael.inventory.domain.storeroom.model.exceptions;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;

import java.text.MessageFormat;

public class StoreroomNotFoundException extends RuntimeException {
    public StoreroomNotFoundException(StoreroomId storeroomId) {
        super(MessageFormat.format("The Storeroom %s not found.", storeroomId.value()));
    }
}
