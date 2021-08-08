/**
 * 
 */
package com.jimi.numberToText;

import java.text.DecimalFormat;


/**
 * @author James Adjei
 *
 */
public final class Jayclass {
	/**
     * The {@code Choose} method selects and returns a value from a list of
     * arguments.
     * <p>
     * Example:<blockquote>
     * 
     * <pre>
     * 
     * Choose(2,"One","Two","Three") returns "Two"
     * </blockquote>
     * </pre>
     * 
     * @param index
     * @param choice
     * @return {@code Object}
     */
    public static Object Choose(int index, Object... choice) {

        if (index < 1 || index > choice.length) {
            return " ";
        } else {
            return choice[--index];
        }

    }

    /**
     * Returns a string that contains a specified number of characters starting from
     * a specified position in a string. {@code start:} Required. Integer
     * expression. Starting position of the characters to return. If Start is
     * greater than the number of characters in str, the Mid function returns a
     * zero-length string (""). Start is one based.
     * <p>
     * {@code Length:} Optional. expression. Number of characters to return. If
     * omitted or if there are fewer than Length characters in the text (including
     * the character at position Start), all characters from the start position to
     * the end of the string are returned.
     * 
     * @param input
     * @param start
     * @param length
     * @return {@literal String}
     */
    public static String Mid(String input, int start, int length) {
        String temp;
        int beginIndex = start - 1;
        int endIndex = start + length - 1;
        if (start < 0 || length < 0) {
            return "";
        }

        temp = input.substring(beginIndex, endIndex);
        return temp;
    }

    /**
     * Returns a string that contains all the characters starting from a specified
     * position in a string.
     * 
     * @param input
     * @param length
     * @return {@literal String}
     */
    public static String Mid(String input, int length) {

        String temp = input.substring(length);
        return temp;
    }

    /**
     * Returns a string containing a specified number of characters from the left
     * side of a string.
     * 
     * @param input
     * @param length
     * @return {@literal String}
     */
    public static String Left(String input, int length) {
        int beginIndex = 0;
        int endIndex = length;
        String temp;
        if (endIndex < 0) {
            return "";
        }
        if (endIndex > input.length()) {
            temp = input.substring(beginIndex, input.length());
            return temp;
        }

        temp = input.substring(beginIndex, endIndex);
        return temp;
    }

    /**
     * Returns a string containing a specified number of characters from the right
     * side of a string.
     * 
     * @param input
     * @param length
     * @return {@value String}
     */
    public static String Right(String input, int length) {
        int beginIndex = input.length() - length;
        int endIndex = input.length();
        String temp;
        if (beginIndex < 0 || endIndex < 0) {
            return "";
        }
        if (beginIndex > endIndex) {
            temp = input.substring(0, endIndex);
            return temp;
        }
        temp = input.substring(beginIndex, endIndex);
        return temp;
    }

    public static String checkCurrency(Long input,String Results, String value) {
        var Res1="";
        switch (value.toLowerCase()) {
            case "pwr":
            Res1 =Results +" kilo-Watts hour, (" + Jayclass.Format(input, "#,###.00") + " kWh)";
                break;
            case "-pwr":
            case "negpwr":
            case "neg_pwr":
            case "neg pwr":
            Res1 = "Negative " + Results + " kilo-Watts hour, (" + Jayclass.Format(input, "-#,###.00")+ " kWh)";
                break;
            case "ghc":
            Res1 = Results + " Ghana Cedis, (Gh¢ "+ Jayclass.Format(input, "#,###.00") + ")";
                break;
            case "usd":
            case "$":
            case "us$":
            Res1 = Results + " US Dollars, (US$ " + Jayclass.Format(input, "#,###.00") + ")";
                break;
            default:
                break;
        }

        return Res1;
    }


    /**
     * Returns a string formatted according to instructions contained in a format
     * String expression.
     * 
     * @param Exprs Object to be formatted.
     * @param style Format style.
     * @return {@value Formatted String}
     */
    public static String Format(Object Exprs, String style) {
        DecimalFormat df = new DecimalFormat(style);

        String temp = df.format(Exprs);
        return temp;
    }


}
