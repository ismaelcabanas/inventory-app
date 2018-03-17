package cabanas.garcia.ismael.inventory.domain.storeroom.repository;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductStockItem;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class FakeStoreroomRepository implements StoreroomRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(FakeStoreroomRepository.class.getName());

    private Set<Storeroom> storerooms = new HashSet<>();
    private Map<StoreroomId, List<ProductStockItem>> productStocks = new HashMap<>();

    @Override
    public void save(Storeroom storeroom) {

    }

    @Override
    public void saveProductStock(ProductStockItem productStockItem) {
        if (productStocks.get(productStockItem.storeroomId()) == null) {
            productStocks.put(productStockItem.storeroomId(), Arrays.asList(productStockItem));
            LOGGER.debug("Product {} saved", productStockItem);
        } else {
            List<ProductStockItem> productStockItemList = productStocks.get(productStockItem.storeroomId());
            productStockItemList.add(productStockItem);
        }
    }

    @Override
    public Optional<Storeroom> findById(StoreroomId storeroomId) {
        Storeroom storeroom = null;
        LOGGER.debug("Storerooms persisted: {}", storerooms);
        Optional<Storeroom> theStoreRoom = storerooms.stream()
                .filter((sr -> sr.id().equals(storeroomId))).findFirst();

        if (theStoreRoom.isPresent()) {
            storeroom = Storeroom.builder(theStoreRoom.get().name())
                    .withId(theStoreRoom.get().id())
                    .withProductStocks(productStocks.get(theStoreRoom.get().id()))
                    .build();
            LOGGER.debug("Storeroom found by id: {}", storeroom);
        }

        return Optional.ofNullable(storeroom);
    }

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
