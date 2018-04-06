package cabanas.garcia.ismael.inventory.infrastructure.repository.product;

import cabanas.garcia.ismael.inventory.domain.product.Product;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.tables.records.ProductRecord;
import org.jooq.RecordMapper;

public class ProductRecordMapper implements RecordMapper<ProductRecord, Product> {
    @Override
    public Product map(ProductRecord record) {
        return Product.builder()
                .withName(record.getPName())
                .withId(ProductId.builder(record.getPId()).build())
                .build();
    }
}
