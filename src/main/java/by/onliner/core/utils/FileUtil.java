package by.onliner.core.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/***
 * The class is used to give functionality of interaction with files.
 */
public class FileUtil {

    /***
     * Clear text file .
     */
    public static void clearTextFile(String path) {
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
