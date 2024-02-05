package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            genderWrapper = $("#genterWrapper"),
            emailInput = $("#userEmail"),
            phoneNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyWrapper = $("#hobbiesWrapper"),
            uploadPictureControl = $("#uploadPicture"),
            cityComponent = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            stateComponent = $("#state"),
            submitButton = $("#submit");
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final TableComponent tableComponent = new TableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //close banners
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String year, String month, String day) {
        calendarInput.click();
        calendarComponent.setDate(year, month, day);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbyWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String filename) {
        uploadPictureControl.uploadFromClasspath(filename);

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityComponent.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setState(String value) {
        stateComponent.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkTable(String key, String value) {
        tableComponent.checkNotEmptyValueInTable(key, value);

        return this;
    }

    public RegistrationPage checkEmptyTable(String key) {
        tableComponent.checkEmptyValueInTable(key);

        return this;
    }

    public void  checkTableIsNotOpen() {
        tableComponent.checkTableIsNotOpen();
    }

}
