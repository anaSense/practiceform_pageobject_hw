package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import utils.RandomUtils;

public class TextBoxTests {

    private final TextBoxPage textBoxPage = new TextBoxPage();
    private final RandomUtils randomUtils = new RandomUtils();

    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

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
