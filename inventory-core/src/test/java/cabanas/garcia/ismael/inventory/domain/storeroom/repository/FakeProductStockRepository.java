package cabanas.garcia.ismael.inventory.domain.storeroom.repository;

import cabanas.garcia.ismael.inventory.domain.common.model.Stock;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FakeProductStockRepository implements ProductStockRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(FakeProductStockRepository.class.getName());

    private Map<StoreroomId, List<ProductStock>> productStocks = new HashMap<>();
    @Override
    public void save(StoreroomId storeroomId, ProductStock productStock) {
        if (productStocks.get(storeroomId) == null) {
            productStocks.put(storeroomId, Arrays.asList(productStock));
            LOGGER.debug("Product {} saved", productStock);
        } else {
            List<ProductStock> productStockItemList = productStocks.get(storeroomId);
            productStockItemList.add(productStock);
        }
    }

    public void verifyProductStockWasSavedInStoreroom(Storeroom storeroom, ProductId productId, Stock stock) {
        assertThat(productStocks.get(storeroom.id())).isNotEmpty();
        productStocks.get(storeroom.id()).stream()
                .filter(productStockItem -> productStockItem.productId().equals(productId))
                .forEach(productStockItem -> {
                    assertThat(productStockItem.stock()).isEqualTo(stock);
                });
    }
}
