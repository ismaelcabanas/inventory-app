package cabanas.garcia.ismael.inventory.product.application;

import cabanas.garcia.ismael.inventory.product.domain.model.Product;
import cabanas.garcia.ismael.inventory.product.domain.repository.ProductRepository;

public class RegisterNewProductService {
    private final ProductRepository productRepository;

    public RegisterNewProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void register(String name) {
        Product product = new Product(name);
        productRepository.save(product);
    }
}
