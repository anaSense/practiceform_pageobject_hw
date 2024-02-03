package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setName("Alex")
                .setEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .clickSubmitButton()
                .checkOutput("Alex")
                .checkOutput("alex@egorov.com")
                .checkOutput("Some street 1")
                .checkOutput("Another street 1");
    }
}
