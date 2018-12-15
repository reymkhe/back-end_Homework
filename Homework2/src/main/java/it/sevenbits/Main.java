package it.sevenbits;

import it.sevenbits.exceptions.ParserException;

import java.util.Arrays;

/**
 * Main application entry point
 */
public class Main {
    /**
     * Main function for app
     * @param args - console arguments
     * @throws ParserException throws when source is null
     */
    public static void main(final String[] args) throws ParserException {
        String [] strings = SimpleParser.parse(" ada   oj  gj ");
        System.out.println(Arrays.toString(strings));

        String [] strings1 = new StringParser().parse("m", "hrfh0 dkj0fguf0");
        System.out.println(Arrays.toString(strings1));

        String [] strings2 = new FileParser().parse("у", "Test file");
        System.out.println(Arrays.toString(strings2));
    }
}
