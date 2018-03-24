package cabanas.garcia.ismael.inventory.domain.stepdefinitions;

import cabanas.garcia.ismael.inventory.domain.product.ProductId;
import cabanas.garcia.ismael.inventory.domain.productStock.model.ProductStock;
import cabanas.garcia.ismael.inventory.domain.common.model.Stock;
import cabanas.garcia.ismael.inventory.domain.common.exception.NotEnoughStockException;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.StoreroomId;
import cucumber.api.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductStockSteps implements En {

    @SuppressWarnings("PMD.SingularField")
    private ProductStock productStock;

    @SuppressWarnings("PMD.SingularField")
    private boolean notEnoughStockException = false;

    public ProductStockSteps() {
        Given("^a product with (\\d+) items in the storeroom$", (Integer itemsAmount) -> {
            productStock = new ProductStock(new StoreroomId(), new ProductId(), new Stock(itemsAmount));
        });
        When("^I consume (\\d+) items of product", (Integer amountConsumed) -> {
            try {
                productStock.consume(new Stock(amountConsumed));
            } catch (NotEnoughStockException ex) {
                notEnoughStockException = true;
            }
        });
        Then("^the stock of product is (\\d+)$", (Integer amountExpected) -> {
            assertThat(productStock.stock()).isEqualTo(new Stock(amountExpected));
        });
        Then("^should advice me that not exist enough stock of product$", () -> {
            assertThat(notEnoughStockException).isTrue();
            notEnoughStockException = false;
        });
        When("^I refill the product with (\\d+) items$", (Integer itemAmount) -> {
            productStock.fill(new Stock(itemAmount));
        });

    }
}
