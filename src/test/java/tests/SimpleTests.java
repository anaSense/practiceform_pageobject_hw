package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class SimpleTests {

    @Test
    void somePositiveTest() {
        assertTrue(true);
    }

    @Test
    void someNegativeTest() {
        assertTrue(false);
    }
}
