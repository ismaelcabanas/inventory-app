package cabanas.garcia.ismael.inventory.stepdefinitions;

import cabanas.garcia.ismael.inventory.domain.storeroom.model.Storeroom;
import cucumber.api.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("PMD.UnusedLocalVariable")
public class SignUpStoreroomSteps implements En {

    private String storeroomName;
    private Storeroom storeroom;

    public SignUpStoreroomSteps() {
        Given("^(.+) wants to become a new storeroom$", (String name) -> {
            this.storeroomName = name;
        });
        When("^I signup it into the platform$", () -> {
            storeroom = new Storeroom(storeroomName);
        });
        Then("^the storeroom has not products$", () -> {
            assertThat(storeroom.products()).isEmpty();
        });

    }
}
