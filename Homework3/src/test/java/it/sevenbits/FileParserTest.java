package it.sevenbits;

import it.sevenbits.Parser.FileParser;
import it.sevenbits.Parser.exceptions.parser.ParserException;
import org.junit.Assert;
import org.junit.Test;

public class FileParserTest {
    FileParser fileParser = new FileParser();

    @Test
    public void simplePositiveTest() throws ParserException {
        Assert.assertArrayEquals(new String[] {"urur", "ghe6cf", "cwsx"}, fileParser.parse("7", "Test file"));
    }

    @Test
    public void arrayShouldHaveOneElement() throws ParserException {
        Assert.assertArrayEquals(new String[] {"abc"}, fileParser.parse("0", "Test file 2"));
    }

    @Test (expected = ParserException.class)
    public void fileNotFound() throws ParserException {
        fileParser.parse("0", "Hello");
    }
}
