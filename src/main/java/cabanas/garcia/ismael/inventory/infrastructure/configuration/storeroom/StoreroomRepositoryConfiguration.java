package cabanas.garcia.ismael.inventory.infrastructure.configuration.storeroom;

import cabanas.garcia.ismael.inventory.infrastructure.repository.storeroom.StoreroomRecordMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreroomRepositoryConfiguration {

    @Bean
    public StoreroomRecordMapper storeroomRecordMapper() {
        return new StoreroomRecordMapper();
    }
}
