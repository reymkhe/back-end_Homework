package it.sevenbits;

import it.sevenbits.exceptions.ParserException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * FileParser is implementation of Parser, it parses from file
 */
public class FileParser implements Parser {
    /**
     * Parse function converts file contents to string array using separator
     * @param delimiter - separator defining how the file contents is divided
     * @param source - path to file
     * @return array of strings
     * @throws ParserException throws when file is not found
     */
    public String[] parse(final String delimiter, final String source) throws ParserException {

        File file = new File(source);
        Scanner scanner;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new ParserException();
        }

        String line = scanner.nextLine();
        String[] parsedString = line.split(delimiter);
        scanner.close();
        return parsedString;
    }
}
