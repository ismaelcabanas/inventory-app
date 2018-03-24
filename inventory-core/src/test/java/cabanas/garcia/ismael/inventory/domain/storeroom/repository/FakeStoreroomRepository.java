package cabanas.garcia.ismael.inventory.domain.storeroom.repository;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FakeStoreroomRepository implements StoreroomRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(FakeStoreroomRepository.class.getName());

    private Set<Storeroom> storerooms = new HashSet<>();

    @Override
    public List<Storeroom> findAll() {
        return storerooms.stream().collect(Collectors.toList());
    }

    @Override
    public void create(Storeroom storeroom) {
        storerooms.add(storeroom);
        LOGGER.debug("Storeroom {} created", storeroom);

    }
}
