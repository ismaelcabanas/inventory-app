package cabanas.garcia.ismael.inventory.infrastructure.configuration.productStock;

import cabanas.garcia.ismael.inventory.domain.productStock.ProductStockRepository;
import cabanas.garcia.ismael.inventory.infrastructure.repository.productStock.ProductStockJooqRepository;
import cabanas.garcia.ismael.inventory.infrastructure.repository.productStock.ProductStockRecordMapper;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductStockRepositoryConfiguration {
    @Bean
    public ProductStockRecordMapper productStockRecordMapper() {
        return new ProductStockRecordMapper();
    }

    @Bean
    public ProductStockRepository productStockRepository(DSLContext dslContext,
                                                         ProductStockRecordMapper productStockRecordMapper) {
        return new ProductStockJooqRepository(dslContext, productStockRecordMapper);
    }
}
