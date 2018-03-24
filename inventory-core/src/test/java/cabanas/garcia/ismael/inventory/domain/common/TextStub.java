package cabanas.garcia.ismael.inventory.domain.common;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public final class TextStub {

    private static final Random RANDOM = new Random();

    private TextStub() { }

    public static String random(int maxNumberOfCharacters) {
        return RandomStringUtils.random(maxNumberOfCharacters);
    }

    public static String random() {
        return random(RANDOM.nextInt());
    }
}
