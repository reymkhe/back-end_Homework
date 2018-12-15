package it.sevenbits;

import it.sevenbits.exceptions.ParserException;

/**
 * StringParser is implementation of Parser, it parses string
 */
public class StringParser implements Parser {
    /**
     * Parse function converts string to string array using separator
     * @param delimiter - separator defining how the line is divided
     * @param source - string for parse
     * @return array of strings
     * @throws ParserException when source is null
     */
    public String[] parse(final String delimiter, final String source) throws ParserException {
        if (source == null)
            throw new ParserException();
        return source.split(delimiter);
    }
}
