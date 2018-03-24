package cabanas.garcia.ismael.inventory.domain.common;

import java.util.Random;

public final class NumberStub {

    private static final Random RANDOM = new Random();

    private NumberStub() { }


    public static int random() {
        return RANDOM.nextInt();
    }

    public static int randomPositive() {
        return RANDOM.nextInt(Integer.MAX_VALUE);
    }
}
