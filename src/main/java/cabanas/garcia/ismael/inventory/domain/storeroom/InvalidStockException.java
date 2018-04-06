package cabanas.garcia.ismael.inventory.domain.storeroom;

public class InvalidStockException extends RuntimeException {
    public InvalidStockException(String message) {
        super(message);
    }
}
