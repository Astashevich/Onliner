package by.onliner.util;

import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

/***
 * The class is used to help us to get element from list
 */
public class ListUtil {

    /***
     * Get random web element from list of web elements.
     * @param list with web elements.
     * @return web element.
     */
    public static WebElement getRandomWebElementFromList(List<WebElement> list, int maxListSize) {
        Random rand = new Random();
        for (WebElement selectedElement : list) {
            selectedElement = list.get(rand.nextInt(maxListSize));
            return selectedElement;
        }
        return null;
    }
}
