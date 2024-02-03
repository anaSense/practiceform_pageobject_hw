package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String year, String month, String day) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        if(Integer.parseInt(day) <= 9) {
            $(".react-datepicker__day--00" + day).click();
        } else {
            $(".react-datepicker__day--0" + day).click();
        }
    }
}
