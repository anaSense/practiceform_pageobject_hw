package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormTests extends TestBase {

    private RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfullyRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Teresa")
                .setLastName("Thompson")
                .setGender("Female")
                .setEmail("teresa.thompson@gmail.com")
                .setPhoneNumber("9134664355")
                .setCurrentAddress("71 Queen Street, WESTERN CENTRAL, LONDON, WC0 8ZU")
                .setBirthDate("2024","February", "29")
                .setSubject("Math")
                .setHobby("Reading")
                .setPicture("cat.jpg")
                .setState("Haryana")
                .setCity("Panipat")
                .clickSubmitButton()
                .checkTable("Student Name", "Teresa Thompson")
                .checkTable("Student Email", "teresa.thompson@gmail.com")
                .checkTable("Gender", "Female")
                .checkTable("Mobile", "9134664355")
                .checkTable("Date of Birth", "29 February,2024")
                .checkTable("Subjects", "Math")
                .checkTable("Hobbies", "Reading")
                .checkTable("Picture", "cat.jpg")
                .checkTable("Address", "71 Queen Street, WESTERN CENTRAL, LONDON, WC0 8ZU")
                .checkTable("State and City", "Haryana Panipat");
    }

    @Test
    void onlyRequestedFieldsSuccessfullyRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Robert")
                .setLastName("Cole")
                .setGender("Male")
                .setBirthDate("2000","July", "19")
                .setPhoneNumber("9995673467")
                .clickSubmitButton()
                .checkTable("Student Name", "Robert Cole")
                .checkEmptyTable("Student Email")
                .checkTable("Gender", "Male")
                .checkTable("Mobile", "9995673467")
                .checkTable("Date of Birth", "19 July,2000")
                .checkEmptyTable("Subjects")
                .checkEmptyTable("Hobbies")
                .checkEmptyTable("Picture")
                .checkEmptyTable("Address")
                .checkEmptyTable("State and City");
    }

    @Test
    void incorrectPhoneNumberTest() {
        registrationPage.openPage()
                .setFirstName("Teresa")
                .setLastName("Thompson")
                .setGender("Female")
                .setPhoneNumber("913466")
                .clickSubmitButton()
                .checkTableIsNotOpen();
    }
}
