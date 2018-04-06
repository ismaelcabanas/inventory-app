package cabanas.garcia.ismael.inventory.infrastructure.repository.storeroom;

import cabanas.garcia.ismael.inventory.domain.storeroom.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.StoreroomId;
import cabanas.garcia.ismael.inventory.infrastructure.repository.jooq.autogen.tables.records.StoreRoomRecord;
import org.jooq.RecordMapper;

public class StoreroomRecordMapper implements RecordMapper<StoreRoomRecord, Storeroom> {
    @Override
    public Storeroom map(StoreRoomRecord record) {
        return Storeroom.builder(record.getSrName())
                .withId(new StoreroomId(record.getSrId()))
                .build();
    }
}
