package cabanas.garcia.ismael.inventory.product.domain.repository;

import cabanas.garcia.ismael.inventory.product.domain.model.Product;

public interface ProductRepository {
    void save(Product product);
}
