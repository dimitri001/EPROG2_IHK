/*
 *   This program recibes the data from the serial wire(the simulator)
 *  and displays it on the screen
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bikeproject.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ibr
 */
public class Parser {

    /*This function returns
      true if the string "str" matches whit the regular expresion "REGEX"
      otherwise it returns false */
    private static boolean isValid(String REGEX, String str) {
        Pattern p = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * Parses the supplied string according to the regular expression supplied.
     * The parser interprets single characters [a..z] as deliminators and
     * returns the resulting tokens in a String array.
     * @param REGEX the regular expression eg. "p\\d+s\\d+g\\d+".
     * @param str the string to be parsed. The string should start with a character.
     * @return the tokens delimited by single characters.
     */
    public static String[] parseString(String REGEX, String str) {
        String[] tokens = null;
        String delimiter = ";";
        if (isValid(REGEX, str)) {
            String csv = str.replaceAll("\\D", delimiter);
            csv = csv.substring(1); //remove first delimiter
            tokens = csv.split(delimiter);
        }
        return tokens;
    }
}


