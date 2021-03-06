/*
 * This file is generated by jOOQ.
*/
package cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.tables;


import cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.Inventory;
import cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.Keys;
import cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.tables.records.StoreRoomRecord;

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
        "schema version:inventory_2018.02.27.0"
    },
    date = "2018-02-27T09:22:15.375Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class StoreRoom extends TableImpl<StoreRoomRecord> {

    private static final long serialVersionUID = -1555122358;

    /**
     * The reference instance of <code>inventory.store_room</code>
     */
    public static final StoreRoom STORE_ROOM = new StoreRoom();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StoreRoomRecord> getRecordType() {
        return StoreRoomRecord.class;
    }

    /**
     * The column <code>inventory.store_room.sr_id</code>.
     */
    public final TableField<StoreRoomRecord, String> SR_ID = createField("sr_id", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>inventory.store_room.sr_name</code>.
     */
    public final TableField<StoreRoomRecord, String> SR_NAME = createField("sr_name", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "");

    /**
     * Create a <code>inventory.store_room</code> table reference
     */
    public StoreRoom() {
        this("store_room", null);
    }

    /**
     * Create an aliased <code>inventory.store_room</code> table reference
     */
    public StoreRoom(String alias) {
        this(alias, STORE_ROOM);
    }

    private StoreRoom(String alias, Table<StoreRoomRecord> aliased) {
        this(alias, aliased, null);
    }

    private StoreRoom(String alias, Table<StoreRoomRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<StoreRoomRecord> getPrimaryKey() {
        return Keys.PK_STORE_ROOM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StoreRoomRecord>> getKeys() {
        return Arrays.<UniqueKey<StoreRoomRecord>>asList(Keys.PK_STORE_ROOM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoreRoom as(String alias) {
        return new StoreRoom(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public StoreRoom rename(String name) {
        return new StoreRoom(name, null);
    }
}
