package cabanas.garcia.ismael.inventory.storeroom.domain.model.storeroom;

import cabanas.garcia.ismael.inventory.common.Entity;

public class Product extends Entity<String>{

    private final String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
