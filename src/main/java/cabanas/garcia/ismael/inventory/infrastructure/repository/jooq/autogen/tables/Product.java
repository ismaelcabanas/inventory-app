/*
 * This file is generated by jOOQ.
*/
package cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.tables;


import cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.Inventory;
import cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.Keys;
import cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.tables.records.ProductRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3",
        "schema version:inventory_2018.02.20.1"
    },
    date = "2018-02-20T12:40:27.692Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Product extends TableImpl<ProductRecord> {

    private static final long serialVersionUID = -2001941522;

    /**
     * The reference instance of <code>inventory.product</code>
     */
    public static final Product PRODUCT = new Product();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductRecord> getRecordType() {
        return ProductRecord.class;
    }

    /**
     * The column <code>inventory.product.p_id</code>.
     */
    public final TableField<ProductRecord, String> P_ID = createField("p_id", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>inventory.product.p_name</code>.
     */
    public final TableField<ProductRecord, String> P_NAME = createField("p_name", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "");

    /**
     * Create a <code>inventory.product</code> table reference
     */
    public Product() {
        this("product", null);
    }

    /**
     * Create an aliased <code>inventory.product</code> table reference
     */
    public Product(String alias) {
        this(alias, PRODUCT);
    }

    private Product(String alias, Table<ProductRecord> aliased) {
        this(alias, aliased, null);
    }

    private Product(String alias, Table<ProductRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Inventory.INVENTORY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ProductRecord> getPrimaryKey() {
        return Keys.PK_PRODUCT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ProductRecord>> getKeys() {
        return Arrays.<UniqueKey<ProductRecord>>asList(Keys.PK_PRODUCT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product as(String alias) {
        return new Product(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Product rename(String name) {
        return new Product(name, null);
    }
}