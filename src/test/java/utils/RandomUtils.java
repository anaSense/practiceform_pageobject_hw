package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class RandomUtils {

    Faker faker = new Faker();

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getGender() {
        String[] genders  = {"Male", "Female", "Other"};
        int index = faker.random().nextInt(0, genders.length - 1);
        return genders[index];
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getPhoneNumber(int length) {
        StringBuilder number = new StringBuilder();
        for(int i = 0; i <= length - 1; i++) {
            number.append(String.valueOf(faker.random().nextInt(0,9)));
        }
        return number.toString();
    }

    public String getAddress() {
        return String.format("%s, %s, %s",
                faker.address().streetAddressNumber(),
                faker.address().city(),
                faker.address().country());
    }

    public String getMonth() {
        String[] months  = {"January", "February",
                "March", "April", "May",
                "June", "July", "August",
                "September", "October", "November",
                "December"};
        int index = faker.random().nextInt(0, months.length - 1);
        return months[index];
    }

    public String getYear() {
        return String.valueOf(faker.random().nextInt(1924, 2024));
    }

    public String getDay() {
        int day = faker.random().nextInt(1, 28);
        if(day <= 9) {
            return "0" + String.valueOf(day);
        }
        return String.valueOf(day);
    }

    public String getSubject() {
        String[] subjects  = {"English", "Chemistry",
                "Computer Science", "Commerce", "Economics",
                "Social Studies", "Arts", "History",
                "Maths", "Accounting", "Physics",
                "Biology", "Hindi", "Civics"};
        int index = faker.random().nextInt(0, subjects.length - 1);
        return subjects[index];
    }

    public String getHobby() {
        String[] hobbies  = {"Sports", "Reading",
                "Music"};
        int index = faker.random().nextInt(0, hobbies.length - 1);
        return hobbies[index];
    }

    public String getPicture() {
        String[] pictures  = {"cat.jpg", "dog.jpg",
                "kakadu.jpg"};
        int index = faker.random().nextInt(0, pictures.length - 1);
        return pictures[index];
    }

    public String getState() {
        String[] states  = {"NCR", "Uttar Pradesh",
                "Haryana", "Rajasthan"};
        int index = faker.random().nextInt(0, states.length - 1);
        return states[index];
    }

    public String getCity(String state) {
        Map<String, String[]> towns = new HashMap<String, String[]>();
        towns.put("NCR",new String[] {"Delhi", "Gurgaon", "Noida"});
        towns.put("Uttar Pradesh", new String[] {"Agra", "Lucknow", "Merrut"});
        towns.put("Haryana", new String[] {"Karnal", "Panipat"});
        towns.put("Rajasthan", new String[] {"Jaipur", "Jaiselmer"});

        String[] choosenTowns = towns.get(state);
        int cityIndex = faker.random().nextInt(0, choosenTowns.length - 1);
        return choosenTowns[cityIndex];
    }
}
