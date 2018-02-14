package cabanas.garcia.ismael.inventory.product.domain.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductShould {

    @Rule public ExpectedException exception = ExpectedException.none();

    @Test public void
    throw_exception_if_name_not_present_when_create_instance() {
        exception.expect(RuntimeException.class);

        new Product(null);
    }

    @Test public void
    verify_integrity_of_product_when_create_an_instance() {
        Product product = new Product("PRODUCT A");

        assertThat(product.id()).isNotNull();
    }
}
