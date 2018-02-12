package cabanas.garcia.ismael.inventory.storeroom.domain.model;

public class InvalidStockException extends RuntimeException {
    public InvalidStockException(String message) {
        super(message);
    }
}
