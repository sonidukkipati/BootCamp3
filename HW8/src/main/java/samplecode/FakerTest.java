package samplecode;

import com.github.javafaker.Faker;

/**
 * Created by sc on 2/10/2017.
 */
public class FakerTest {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.address().city());
        System.out.println(faker.book().genre());
        System.out.println(faker.address().country());
        System.out.println(faker.company().name());



    }
}
