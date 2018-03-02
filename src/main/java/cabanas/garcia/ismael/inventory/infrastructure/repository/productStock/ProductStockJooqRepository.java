package cabanas.garcia.ismael.inventory.infrastructure.repository.productStock;

import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.productStock.model.StoreroomId;
import cabanas.garcia.ismael.inventory.domain.productStock.repository.ProductStockRepository;
import org.jooq.DSLContext;

import java.util.Objects;

import static cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.Tables.PRODUCT_STOCK;

public class ProductStockJooqRepository implements ProductStockRepository {
    private final DSLContext dslContext;

    public ProductStockJooqRepository(DSLContext dslContext) {
        Objects.requireNonNull(dslContext, "DSLContext is mandatory");

        this.dslContext = dslContext;
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
    public ProductStock findBy(StoreroomId storeroomId, ProductId productId) {
        return null;
    }
}
