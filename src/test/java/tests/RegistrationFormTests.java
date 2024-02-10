package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class RegistrationFormTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final RandomUtils randomUtils = new RandomUtils();

    @Test
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
        String firstName = randomUtils.getFirstName();
        String lastName = randomUtils.getLastName();
        String gender = randomUtils.getGender();
        String year = randomUtils.getYear();
        String month = randomUtils.getMonth();
        String day = randomUtils.getDay();
        String phone = randomUtils.getPhoneNumber(10);
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
        String firstName = randomUtils.getFirstName();
        String lastName = randomUtils.getLastName();
        String gender = randomUtils.getGender();
        String phone = randomUtils.getPhoneNumber(5);
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPhoneNumber(phone)
                .clickSubmitButton()
                .checkTableIsNotOpen();
    }
}
