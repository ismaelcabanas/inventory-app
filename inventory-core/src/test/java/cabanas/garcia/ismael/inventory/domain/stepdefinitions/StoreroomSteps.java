package cabanas.garcia.ismael.inventory.domain.stepdefinitions;

import cabanas.garcia.ismael.inventory.domain.common.model.Stock;
import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import cabanas.garcia.ismael.inventory.domain.product.ProductIdStub;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cucumber.api.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreroomSteps implements En {

    private static final String SOME_STOREROOM_NAME = "fakeStoreroomName";
    private final ProductId productId = ProductIdStub.random();

    @SuppressWarnings("PMD.SingularField")
    private String storeroomName;
    @SuppressWarnings("PMD.SingularField")
    private Storeroom storeroom;

    public StoreroomSteps() {
        Given("^(.+) wants to become a new storeroom$", (String name) -> {
            this.storeroomName = name;
        });
        When("^I signup it into the platform$", () -> {
            storeroom = new Storeroom(storeroomName);
        });
        Then("^the storeroom has not products$", () -> {
            assertThat(storeroom.products()).isEmpty();
        });
        Given("^a storeroom$", () -> {
            storeroom = Storeroom.builder(SOME_STOREROOM_NAME).build();
        });
        And("^a product with (\\d+) units in the storeroom$", (Integer stockActual) -> {
            storeroom.add(new ProductStock(productId, new Stock(stockActual)));
        });
        When("^I take (\\d+) units of product$", (Integer stockConsumed) -> {
            storeroom.take(productId, new Stock(stockConsumed));
        });
        Then("^the product's stock in storeroom is (\\d+)$", (Integer stockLeft) -> {
            assertThat(storeroom.stockOf(productId)).isEqualTo(new Stock(stockLeft));
        });
        When("^I refill with (\\d+) units of product$", (Integer stockAdded) -> {
            storeroom.refill(productId, new Stock(stockAdded));
        });

    }
}
