package cabanas.garcia.ismael.inventory.infrastructure.configuration.storeroom;

import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;
import cabanas.garcia.ismael.inventory.infrastructure.repository.storeroom.StoreroomJooqRepository;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreroomRepositoryConfiguration {

    @Bean
    public StoreroomRepository storeroomRepository(DSLContext dslContext) {
        return new StoreroomJooqRepository(dslContext);
    }
}
