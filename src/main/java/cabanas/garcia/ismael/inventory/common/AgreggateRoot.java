package cabanas.garcia.ismael.inventory.common;

public abstract class AgreggateRoot<ID> extends Entity<ID> {

    protected AgreggateRoot(ID id) {
        super(id);
    }

}
