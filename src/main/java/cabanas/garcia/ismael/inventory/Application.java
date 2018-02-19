package cabanas.garcia.ismael.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "cabanas.garcia.ismael.inventory.infrastructure"
})
@SuppressWarnings("PMD.UseUtilityClass")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}