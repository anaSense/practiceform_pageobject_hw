package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("property")
    void systemPropertyTest() {
        System.out.println(System.getProperty("browser", "safary"));
    }
}
