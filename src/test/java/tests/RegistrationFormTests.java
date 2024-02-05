package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;

public class RegistrationFormTests extends TestBase {

    private RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfullyRegistrationTest() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String gender = getGender();
        String email = getEmail();
        String phone = getPhoneNumber(10);
        String address = getAddress();
        String year = String.valueOf(getRandomInt(1924, 2024));
        String month = getMonth();
        String day = getDay();
        String subject = getSubject();
        String hobby = getHobby();
        String filename = getPicture();
        String state = getState();
        String city = getCity(state);

        registrationPage.openPage()
                .setFirstName(firstName)
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
                .setCity(city)
                .clickSubmitButton()
                .checkTable("Student Name", firstName + " "+ lastName)
                .checkTable("Student Email", email)
                .checkTable("Gender", gender)
                .checkTable("Mobile", phone)
                .checkTable("Date of Birth", day + " " + month + "," + year)
                .checkTable("Subjects", subject)
                .checkTable("Hobbies", hobby)
                .checkTable("Picture", filename)
                .checkTable("Address", address)
                .checkTable("State and City", state + " " + city);
    }

    @Test
    void onlyRequestedFieldsSuccessfullyRegistrationTest() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String gender = getGender();
        String year = String.valueOf(getRandomInt(1924, 2024));
        String month = getMonth();
        String day = getDay();
        String phone = getPhoneNumber(10);
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setBirthDate(year,month, day)
                .setPhoneNumber(phone)
                .clickSubmitButton()
                .checkTable("Student Name", firstName + " "+ lastName)
                .checkEmptyTable("Student Email")
                .checkTable("Gender", gender)
                .checkTable("Mobile", phone)
                .checkTable("Date of Birth", day + " " + month + "," + year)
                .checkEmptyTable("Subjects")
                .checkEmptyTable("Hobbies")
                .checkEmptyTable("Picture")
                .checkEmptyTable("Address")
                .checkEmptyTable("State and City");
    }

    @Test
    void incorrectPhoneNumberTest() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String gender = getGender();
        String phone = getPhoneNumber(5);
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhoneNumber(phone)
                .clickSubmitButton()
                .checkTableIsNotOpen();
    }
}
