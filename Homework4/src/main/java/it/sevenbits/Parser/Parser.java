package it.sevenbits.Parser;

import it.sevenbits.Parser.exceptions.parser.ParserException;

/**
 * Interface with parser
 */
public interface Parser {
    /**
     * Parse function converts strings to string array using separator
     * @param delimiter - separator defining how string is divided
     * @param source - string or path to file
     * @return array of strings
     * @throws ParserException throws when source is null
     */
    String[] parse(String delimiter, String source) throws ParserException;
}
