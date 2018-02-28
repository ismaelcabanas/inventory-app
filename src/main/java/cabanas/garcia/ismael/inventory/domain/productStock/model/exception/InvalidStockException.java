package cabanas.garcia.ismael.inventory.domain.productStock.model.exception;

public class InvalidStockException extends RuntimeException {
    public InvalidStockException(String message) {
        super(message);
    }
}
