package cabanas.garcia.ismael.inventory.infrastructure.repository.util;

import org.springframework.jdbc.core.JdbcTemplate;

import static org.springframework.test.jdbc.JdbcTestUtils.countRowsInTable;

public final class DataBaseTestUtils {
    private static final String PRODUCT_TABLE_NAME = "PRODUCT";
    private static final String STORE_ROOM_TABLE_NAME = "STORE_ROOM";
    private static final String PRODUCT_STOCK_TABLE_NAME = "PRODUCT_STOCK";

    private DataBaseTestUtils() {
    }

    public static int numberOfInsertedInProductTable(JdbcTemplate jdbcTemplate) {
        return countRowsInTable(jdbcTemplate, PRODUCT_TABLE_NAME);
    }

    public static int numberOfInsertedInStoreroomTable(JdbcTemplate jdbcTemplate) {
        return countRowsInTable(jdbcTemplate, STORE_ROOM_TABLE_NAME);
    }

    public static int numberOfInsertedProductStockInTable(JdbcTemplate jdbcTemplate) {
        return countRowsInTable(jdbcTemplate, PRODUCT_STOCK_TABLE_NAME);
    }

}
