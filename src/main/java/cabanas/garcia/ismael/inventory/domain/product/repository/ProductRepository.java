package cabanas.garcia.ismael.inventory.domain.product.repository;

import cabanas.garcia.ismael.inventory.domain.product.model.Product;

public interface ProductRepository {
    void save(Product product);
}
