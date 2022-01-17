package by.onliner.core.utils;

import com.github.javafaker.Faker;

/***
 * Random generator of strings
 */
public class RandomSymbolUtil {

    private static final Faker faker = new Faker();

    /***
     * Generates random string
     * @return random login string
     */
    public static String getRandomLogin() {
        return faker.internet().emailAddress();
    }

}
