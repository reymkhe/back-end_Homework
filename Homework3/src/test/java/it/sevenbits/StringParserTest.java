package it.sevenbits;

import it.sevenbits.Parser.StringParser;
import it.sevenbits.Parser.exceptions.parser.ParserException;
import org.junit.Assert;
import org.junit.Test;


public class StringParserTest {
    StringParser stringParser = new StringParser();

    @Test
    public void simplePositiveTest() throws ParserException {
        Assert.assertArrayEquals(new String[] {"ydfsuyfg", "gvfgg", "fvdv", "fdvhfd"}, stringParser.parse("0", "ydfsuyfg0gvfgg0fvdv0fdvhfd0"));
    }

    @Test
    public void arrayShouldHaveOneElement() throws ParserException {
        Assert.assertArrayEquals(new String[] {"abc"}, stringParser.parse("//", "abc//"));
    }

    @Test
    public void stringHasNoDelimiter() throws ParserException {
        Assert.assertArrayEquals(new String[] {"abc def g"}, stringParser.parse("//", "abc def g"));
    }

    @Test (expected = ParserException.class)
    public void sourceIsNull() throws ParserException {
      stringParser.parse("0", null);
    }
}
