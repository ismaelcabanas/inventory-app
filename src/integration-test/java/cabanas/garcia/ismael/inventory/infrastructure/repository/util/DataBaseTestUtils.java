package cabanas.garcia.ismael.inventory.infrastructure.repository.util;

import org.springframework.jdbc.core.JdbcTemplate;

import static org.springframework.test.jdbc.JdbcTestUtils.countRowsInTable;

public final class DataBaseTestUtils {
    private static final String PRODUCT_TABLE_NAME = "PRODUCT";

    private DataBaseTestUtils() {
    }

    public static int numberOfInsertedInProductTable(JdbcTemplate jdbcTemplate) {
        return countRowsInTable(jdbcTemplate, PRODUCT_TABLE_NAME);
    }
}
