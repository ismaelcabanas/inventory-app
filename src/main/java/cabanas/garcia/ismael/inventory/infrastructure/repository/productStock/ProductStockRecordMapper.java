package cabanas.garcia.ismael.inventory.infrastructure.repository.productStock;

import cabanas.garcia.ismael.inventory.domain.product.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStockId;
import cabanas.garcia.ismael.inventory.domain.common.Stock;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;
import cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.tables.records.ProductStockRecord;
import org.jooq.RecordMapper;

public class ProductStockRecordMapper implements RecordMapper<ProductStockRecord, ProductStock> {
    @Override
    public ProductStock map(ProductStockRecord record) {
        return ProductStock.builder()
          .withId(ProductStockId.builder(record.getPsId()).build())
          .withStoreroomId(StoreroomId.builder(record.getPsStoreroomId()).build())
          .withProductId(ProductId.builder(record.getPsProductId()).build())
          .withStock(new Stock(record.getPsStock()))
          .build();
    }
}
