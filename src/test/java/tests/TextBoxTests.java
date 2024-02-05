package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static utils.RandomUtils.*;

public class TextBoxTests extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        String firstName = getFirstName();
        String email = getEmail();
        String currentAddress = getAddress();
        String permanentAddress = getAddress();

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
