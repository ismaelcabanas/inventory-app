package cabanas.garcia.ismael.inventory.infrastructure.repository.productStock;

import cabanas.garcia.ismael.inventory.domain.product.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.productStock.repository.ProductStockRepository;
import cabanas.garcia.ismael.inventory.domain.storeroom.StoreroomId;
import org.jooq.DSLContext;

import java.util.Objects;
import java.util.Optional;

import static cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.Tables.PRODUCT_STOCK;

public class ProductStockJooqRepository implements ProductStockRepository {
    private final DSLContext dslContext;
    private final ProductStockRecordMapper productStockRecordMapper;

    public ProductStockJooqRepository(DSLContext dslContext, ProductStockRecordMapper productStockRecordMapper) {
        Objects.requireNonNull(dslContext, "DSLContext is mandatory");
        Objects.requireNonNull(productStockRecordMapper, "ProductStockRecordMapper is mandatory");

        this.dslContext = dslContext;
        this.productStockRecordMapper = productStockRecordMapper;
    }

    @Override
    public void save(ProductStock productStock) {
        dslContext.insertInto(PRODUCT_STOCK)
                .columns(PRODUCT_STOCK.PS_ID,
                        PRODUCT_STOCK.PS_STOREROOM_ID,
                        PRODUCT_STOCK.PS_PRODUCT_ID,
                        PRODUCT_STOCK.PS_STOCK)
                .values(productStock.id().value(),
                        productStock.storeroom().value(),
                        productStock.product().value(),
                        productStock.stock().value())
                .execute();
    }

    @Override
    public Optional<ProductStock> findBy(StoreroomId storeroomId, ProductId productId) {
        ProductStock productStock = dslContext.selectFrom(PRODUCT_STOCK)
            .where(PRODUCT_STOCK.PS_STOREROOM_ID.eq(storeroomId.value()))
            .and(PRODUCT_STOCK.PS_PRODUCT_ID.eq(productId.value()))
            .fetchOne(productStockRecordMapper);

        return Optional.ofNullable(productStock);
    }
}
