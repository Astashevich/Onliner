package by.onliner.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/***
 * The class is used to give functional of clear text file
 */
public class ClearTextFileUtil {

    /***
     * Clear text file after attaching text file to report.
     */
    public static void clearFile(String path) {
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
