package utils;

/***
 * The class is used to give us more equals to assertions
 */
public class EqualsUtil {

    /***
     * Asserts that the given element contains the desired value
     * @param expected text
     * @param contains information what we need
     * @return expected result
     */
    public static boolean equalContains(String expected, String contains) {
        return expected.contains(contains);
    }
}
