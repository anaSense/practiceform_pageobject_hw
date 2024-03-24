package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import utils.RandomUtils;

public class TextBoxTests extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();
    private final RandomUtils randomUtils = new RandomUtils();

    @Test
    void fillFormTest() {
        String firstName = randomUtils.getFirstName();
        String email = randomUtils.getEmail();
        String currentAddress = randomUtils.getAddress();
        String permanentAddress = randomUtils.getAddress();

        textBoxPage.openPage()
                .setName(firstName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmitButton()
                .checkOutput(firstName)
                .checkOutput(email)
                .checkOutput(currentAddress)
                .checkOutput(permanentAddress);
    }
}
