package cabanas.garcia.ismael.inventory.infrastructure.configuration.product;

import cabanas.garcia.ismael.inventory.domain.product.ProductRepository;
import cabanas.garcia.ismael.inventory.infrastructure.repository.product.ProductJooqRepository;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductRepositoryConfiguration {

    @Bean
    public ProductRepository productRepository(DSLContext dslContext) {
        return new ProductJooqRepository(dslContext);
    }
}
