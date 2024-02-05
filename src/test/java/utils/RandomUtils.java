package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomUtils {

    static Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getGender() {
        String[] genders  = {"Male", "Female", "Other"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getPhoneNumber(int length) {
        StringBuilder number = new StringBuilder();
        for(int i = 0; i <= length - 1; i++) {
            number.append(String.valueOf(getRandomInt(0,9)));
        }
        return number.toString();
    }

    public static String getAddress() {
        return String.format("%s, %s, %s",
                faker.address().streetAddressNumber(),
                faker.address().city(),
                faker.address().country());
    }

    public static String getMonth() {
        String[] months  = {"January", "February",
                "March", "April", "May",
                "June", "July", "August",
                "September", "October", "November",
                "December"};
        int index = getRandomInt(0, months.length - 1);
        return months[index];
    }

    public static String getDay() {
        int day = getRandomInt(1, 28);
        if(day <= 9) {
            return "0" + String.valueOf(day);
        }
        return String.valueOf(day);
    }

    public static String getSubject() {
        String[] subjects  = {"English", "Chemistry",
                "Computer Science", "Commerce", "Economics",
                "Social Studies", "Arts", "History",
                "Maths", "Accounting", "Physics",
                "Biology", "Hindi", "Civics"};
        int index = getRandomInt(0, subjects.length - 1);
        return subjects[index];
    }

    public static String getHobby() {
        String[] hobbies  = {"Sports", "Reading",
                "Music"};
        int index = getRandomInt(0, hobbies.length - 1);
        return hobbies[index];
    }

    public static String getPicture() {
        String[] pictures  = {"cat.jpg", "dog.jpg",
                "kakadu.jpg"};
        int index = getRandomInt(0, pictures.length - 1);
        return pictures[index];
    }

    public static String getState() {
        String[] states  = {"NCR", "Uttar Pradesh",
                "Haryana", "Rajasthan"};
        int index = getRandomInt(0, states.length - 1);
        return states[index];
    }

    public static String getCity(String state) {
        Map<String, String[]> towns = new HashMap<String, String[]>();
        towns.put("NCR",new String[] {"Delhi", "Gurgaon", "Noida"});
        towns.put("Uttar Pradesh", new String[] {"Agra", "Lucknow", "Merrut"});
        towns.put("Haryana", new String[] {"Karnal", "Panipat"});
        towns.put("Rajasthan", new String[] {"Jaipur", "Jaiselmer"});

        String[] choosenTowns = towns.get(state);
        int cityIndex = getRandomInt(0, choosenTowns.length - 1);
        return choosenTowns[cityIndex];
    }

    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
