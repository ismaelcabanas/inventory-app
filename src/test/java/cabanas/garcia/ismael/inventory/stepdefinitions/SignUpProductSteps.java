package cabanas.garcia.ismael.inventory.stepdefinitions;

import cabanas.garcia.ismael.inventory.domain.common.DomainEventPublisher;
import cabanas.garcia.ismael.inventory.domain.product.model.Product;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductId;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.ProductRegisterDomainEventSubscriber;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Stock;
import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cabanas.garcia.ismael.inventory.domain.storeroom.repository.FakeStoreroomRepository;
import cucumber.api.java8.En;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class SignUpProductSteps implements En {

    @SuppressWarnings("PMD.SingularField")
    private Product product;
    @SuppressWarnings("PMD.SingularField")
    private String productName;
    @SuppressWarnings("PMD.SingularField")
    private Storeroom storeroom;

    private FakeStoreroomRepository fakeStoreroomRepository = new FakeStoreroomRepository();
    private ProductRegisterDomainEventSubscriber subscriber =
            new ProductRegisterDomainEventSubscriber(fakeStoreroomRepository);

    public SignUpProductSteps() {
        Given("^(.+) wants to become a new product in storeroom$", (String name) -> {
            this.productName = name;
        });
        Given("^a storeroom called (.+)$", (String storeroomName) -> {
            DomainEventPublisher.getInstance().subscribe(subscriber);
            storeroom = new Storeroom(storeroomName);
            fakeStoreroomRepository.create(storeroom);
        });
        When("^I signup the product into the platform$", () -> {
            product = new Product(this.productName);
        });
        Then("^the storeroom has the (.+)", (String name) -> {
            Optional<Storeroom> theStoreroom = fakeStoreroomRepository.findById(storeroom.id());
            assertThat(theStoreroom).isNotEmpty();
            theStoreroom.ifPresent(str -> {
                assertThat(str.products().get(0).productId()).isEqualTo(ProductId.builder(product.id().value()).build());
            });
        });
        And("^the stock of (.+) in (.+) is (\\d)$", (String name, String storeroomName, Integer stock) -> {
            Optional<Storeroom> theStoreroom = fakeStoreroomRepository.findById(storeroom.id());
            assertThat(theStoreroom).isNotEmpty();
            theStoreroom.ifPresent(str -> {
                assertThat(str.stockOf(ProductId.builder(product.id().value()).build())).isEqualTo(new Stock(stock));
            });
            DomainEventPublisher.getInstance().unsubscribe(subscriber);
        });


    }
}
