package cabanas.garcia.ismael.inventory.infrastructure.repository.storeroom;

import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.product.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductStockItem;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;
import org.apache.commons.lang3.NotImplementedException;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import static cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.tables.StoreRoom.STORE_ROOM;
import static cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.tables.ProductStock.PRODUCT_STOCK;

public class StoreroomJooqRepository implements StoreroomRepository {

    private final DSLContext dslContext;

    public StoreroomJooqRepository(DSLContext dslContext) {
        Objects.requireNonNull(dslContext, "DSLContext is mandatory");

        this.dslContext = dslContext;
    }

    @Override
    public void create(Storeroom storeroom) {
        dslContext.insertInto(STORE_ROOM)
                .columns(STORE_ROOM.SR_ID, STORE_ROOM.SR_NAME)
                .values(storeroom.id().value(), storeroom.name())
                .execute();
    }

    @Override
    public void save(Storeroom storeroom) {

    }

    @Override
    public void saveProductStock(ProductStockItem productStockItem) {
        dslContext.insertInto(PRODUCT_STOCK)
                .columns(PRODUCT_STOCK.PS_ID, PRODUCT_STOCK.PS_PRODUCT_ID, PRODUCT_STOCK.PS_STOCK,
                        PRODUCT_STOCK.PS_STOREROOM_ID)
                .values(productStockItem.id().value(), productStockItem.productId().value(), productStockItem.stock().value(),
                        productStockItem.storeroomId().value())
                .execute();
    }

    @Override
    public Optional<Storeroom> findById(StoreroomId storeroomId) {
        List<Record> result = dslContext.select()
                .from(STORE_ROOM.join(PRODUCT_STOCK)
                        .on(STORE_ROOM.SR_ID.eq(PRODUCT_STOCK.PS_STOREROOM_ID)))
                .where(STORE_ROOM.SR_ID.eq(storeroomId.value()))
                .fetch();

        return Optional.ofNullable(mapStoreroom(result));
    }

    @Override
    public List<Storeroom> findAll() {
        throw new NotImplementedException("Not implemented yet");
    }

    private Storeroom mapStoreroom(List<Record> result) {
        Storeroom storeroom = null;
        if (result != null && result.size() > 0) {
            storeroom = Storeroom.builder(result.get(0).getValue(STORE_ROOM.SR_NAME))
                    .withId(new StoreroomId(result.get(0).getValue(STORE_ROOM.SR_ID)))
                    .withProductStocks(mapProductStocks(result))
                    .build();
        }
        return storeroom;
    }

    private List<ProductStockItem> mapProductStocks(List<Record> result) {
        List<ProductStockItem> productStockItems = new ArrayList<>();
        result.forEach(rs -> productStockItems.add(
                new ProductStockItem(
                        StoreroomId.builder(rs.getValue(STORE_ROOM.SR_ID)).build(),
                        ProductId.builder(rs.getValue(PRODUCT_STOCK.PS_PRODUCT_ID)).build(),
                        new Stock(rs.getValue(PRODUCT_STOCK.PS_STOCK))
                )
        ));
        return productStockItems;
    }
}
