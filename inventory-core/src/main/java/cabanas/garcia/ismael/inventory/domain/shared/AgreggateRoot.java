package cabanas.garcia.ismael.inventory.domain.shared;

import java.util.ArrayList;
import java.util.List;

public abstract class AgreggateRoot<ID> extends Entity<ID> {

    private List<DomainEvent> domainEvents = new ArrayList<>();

    public final List<DomainEvent> pullDomainEvents() {
        // TODO Clear domainEvents list making a copy of its elements
        return domainEvents;
    }

    public final void register(DomainEvent domainEvent) {
        this.domainEvents.add(domainEvent);
    }
}
