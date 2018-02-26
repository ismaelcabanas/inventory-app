package cabanas.garcia.ismael.inventory.infrastructure.repository.storeroom;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.StoreroomRepository;
import org.jooq.DSLContext;

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

    }

    @Override
    public void save(Storeroom storeroom) {
        dslContext.insertInto(STORE_ROOM)
                .columns(STORE_ROOM.SR_ID, STORE_ROOM.SR_NAME)
                .values(storeroom.id().value(), storeroom.name())
                .execute();
    }

    @Override
    public void saveProductStock(ProductStock productStock) {
        dslContext.insertInto(PRODUCT_STOCK)
                .columns(PRODUCT_STOCK.PS_ID, PRODUCT_STOCK.PS_PRODUCT_ID, PRODUCT_STOCK.PS_STOCK)
                .values(productStock.id().value(), productStock.productId().value(), productStock.stock().value())
                .execute();
    }

    @Override
    public Optional<Storeroom> findById(StoreroomId storeroomId) {
        return null;
    }

    @Override
    public List<Storeroom> findAll() {
        return null;
    }
}
