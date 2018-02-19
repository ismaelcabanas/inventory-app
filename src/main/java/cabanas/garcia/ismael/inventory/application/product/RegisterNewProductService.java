package cabanas.garcia.ismael.inventory.application.product;

import cabanas.garcia.ismael.inventory.domain.product.model.Product;
import cabanas.garcia.ismael.inventory.domain.product.repository.ProductRepository;

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
