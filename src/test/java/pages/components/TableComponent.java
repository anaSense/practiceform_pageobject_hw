package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {

    public void checkTableIsNotOpen() {
        $(".table").shouldNotBe(visible);
    }

    public void checkNotEmptyValueInTable(String key, String value) {
        $(".table").$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkEmptyValueInTable(String key) {
        $(".table").$(byText(key)).sibling(0).shouldBe(empty);
    }
}
