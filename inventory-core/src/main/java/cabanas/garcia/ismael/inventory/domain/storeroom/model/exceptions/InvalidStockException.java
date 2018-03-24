package cabanas.garcia.ismael.inventory.domain.storeroom.model.exceptions;

public class InvalidStockException extends RuntimeException {
    public InvalidStockException(String message) {
        super(message);
    }
}
