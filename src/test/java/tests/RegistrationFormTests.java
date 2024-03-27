package tests;

import com.codeborne.selenide.Selenide;
import helpers.Attach;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;

@Tag("registration")
public class RegistrationFormTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RandomUtils randomUtils = new RandomUtils();

    @AfterEach
    void addAttachment() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        Selenide.closeWindow();
    }

    @Test
    @Feature("Registration form in demoqa")
    @Story("Check registration")
    @Owner("egorovaa")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check successfully registration")
    void successfullyRegistrationTest() {
        String firstName = randomUtils.getFirstName();
        String lastName = randomUtils.getLastName();
        String gender = randomUtils.getGender();
        String email = randomUtils.getEmail();
        String phone = randomUtils.getPhoneNumber(10);
        String address = randomUtils.getAddress();
        String year = randomUtils.getYear();
        String month = randomUtils.getMonth();
        String day = randomUtils.getDay();
        String subject = randomUtils.getSubject();
        String hobby = randomUtils.getHobby();
        String filename = randomUtils.getPicture();
        String state = randomUtils.getState();
        String city = randomUtils.getCity(state);

        step("Open registration form", () -> {
            registrationPage.openPage();
        });

        step("Fill the fields", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(gender)
                    .setEmail(email)
                    .setPhoneNumber(phone)
                    .setCurrentAddress(address)
                    .setBirthDate(year,month, day)
                    .setSubject(subject)
                    .setHobby(hobby)
                    .setPicture(filename)
                    .setState(state)
                    .setCity(city);
        });

        step("Click Submit button", () -> {
            registrationPage.clickSubmitButton();
        });

        step("Check data in the table", () -> {
            registrationPage.checkTable("Student Name", firstName + " "+ lastName)
                    .checkTable("Student Email", email)
                    .checkTable("Gender", gender)
                    .checkTable("Mobile", phone)
                    .checkTable("Date of Birth", day + " " + month + "," + year)
                    .checkTable("Subjects", subject)
                    .checkTable("Hobbies", hobby)
                    .checkTable("Picture", filename)
                    .checkTable("Address", address)
                    .checkTable("State and City", state + " " + city);
        });
    }

    @Test
    @Feature("Registration form in demoqa")
    @Story("Check registration")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check only requested fields in registration")
    void onlyRequestedFieldsSuccessfullyRegistrationTest() {
        String firstName = randomUtils.getFirstName();
        String lastName = randomUtils.getLastName();
        String gender = randomUtils.getGender();
        String year = randomUtils.getYear();
        String month = randomUtils.getMonth();
        String day = randomUtils.getDay();
        String phone = randomUtils.getPhoneNumber(10);

        step("Open registration form", () -> {
            registrationPage.openPage();
        });

        step("Fill the fields", () -> {
            registrationPage.setFirstName(firstName)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(gender)
                    .setBirthDate(year,month, day)
                    .setPhoneNumber(phone);
        });

        step("Click Submit button", () -> {
            registrationPage.clickSubmitButton();
        });

        step("Check filled data in the table", () -> {
            registrationPage.checkTable("Student Name", firstName + " "+ lastName)
                    .checkEmptyTable("Student Email")
                    .checkTable("Gender", gender)
                    .checkTable("Mobile", phone)
                    .checkTable("Date of Birth", day + " " + month + "," + year);
        });

        step("Check empty data in the table", () -> {
            registrationPage.checkEmptyTable("Subjects")
                    .checkEmptyTable("Hobbies")
                    .checkEmptyTable("Picture")
                    .checkEmptyTable("Address")
                    .checkEmptyTable("State and City");
        });
    }

    @Test
    @Feature("Registration form in demoqa")
    @Story("Check registration")
    @Owner("egorovaa")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check entering incorrect phone number")
    void incorrectPhoneNumberTest() {
        String firstName = randomUtils.getFirstName();
        String lastName = randomUtils.getLastName();
        String gender = randomUtils.getGender();
        String phone = randomUtils.getPhoneNumber(5);

        step("Open registration form", () -> {
            registrationPage.openPage();
        });

        step("Fill the fields", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(gender)
                    .setPhoneNumber(phone);
        });

        step("Click Submit button", () -> {
            registrationPage.clickSubmitButton();
        });

        step("Check table is not opened", () -> {
            registrationPage.checkTableIsNotOpen();
        });
    }
}
