import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
/**
 *
 * @author yash agarwal
 *
 */

public class WebContent {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
    Scanner urlScanner;
    try {
        urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
    } catch (IOException e) {
        return "";
    }
    String contents = urlScanner.useDelimiter("\\A").next();
    urlScanner.close();
    return contents;
}
    /**
     * Retrieve contents from a file and return the number of words.
     *
     * @param wordCount counts number of words in the file.
     * @param s is input string.
     * @return the contents from the url as a string, or an empty string on error
     */
    public static int countWords(final String s) {

        int wordCount = 0;
        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            // if the char is a letter, word = true.
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
                // if char isn't a letter and there have been letters before,
                // counter goes up.
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
                // last word of String; if it doesn't end with a non letter, it
                // wouldn't count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }
    /**
     * Main method in the class, binds the program together.
     * returns url as a string
     * @param args is standard argument
     */
    public static void main(final String[] args) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("the URL is " + urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println("---------------------------------------------------------------");
        System.out.println("Words:" + countWords(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println("---------------------------------------------------------------");
    }
}
