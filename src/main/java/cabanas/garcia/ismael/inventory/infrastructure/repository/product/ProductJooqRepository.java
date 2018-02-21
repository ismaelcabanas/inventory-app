package cabanas.garcia.ismael.inventory.infrastructure.repository.product;

import cabanas.garcia.ismael.inventory.domain.product.model.Product;
import cabanas.garcia.ismael.inventory.domain.product.repository.ProductRepository;
import org.jooq.DSLContext;

import java.util.Objects;

import static cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.tables.Product.PRODUCT;

public class ProductJooqRepository implements ProductRepository {
    private final DSLContext dslContext;

    public ProductJooqRepository(DSLContext dslContext) {
        Objects.requireNonNull(dslContext, "DSLContext is mandatory");

        this.dslContext = dslContext;
    }

    @Override
    public void save(Product product) {
        dslContext.insertInto(PRODUCT)
                .columns(PRODUCT.P_ID,
                        PRODUCT.P_NAME)
                .values(product.id().value(),
                        product.name())
                .execute();
    }
}
