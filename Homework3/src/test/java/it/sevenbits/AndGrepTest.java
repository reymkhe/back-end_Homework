package it.sevenbits;


import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

/**
 * Tests for class AndGrep
 */
public class AndGrepTest {

    private Reader mockReader = mock(Reader.class);

    /**
     * Simple positive test for AndGrep function, grep filters are words.
     * @throws IOException when reader is not exist
     */
    @Test
    public void simplePositiveAndGrepTest() throws IOException {
        AndGrep andGrep = new AndGrep ("my", "life");
        when(mockReader.read()).thenReturn(109,121,32,119,111,114,108,100,10,109,121,32,108,105,102,101,10,72,101,108,108,111,-1);
        List<String> expectedSource = new ArrayList<String>() {{
            add("my life");
        }};
        Assert.assertArrayEquals(expectedSource.toArray(), andGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(23)).read();
    }

    /**
     * Grep filters are the same words.
     * @throws IOException when reader is not exist
     */
    @Test
    public void filtersAreEquals() throws IOException {
        AndGrep andGrep = new AndGrep ("my", "my");
        when(mockReader.read()).thenReturn(109,121,32,119,111,114,108,100,10,109,121,32,108,105,102,101,10,72,101,108,108,111,-1);
        List<String> expectedSource = new ArrayList<String>() {{
            add("my world");
            add("my life");
        }};
        Assert.assertArrayEquals(expectedSource.toArray(), andGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(23)).read();
    }

    /**
     * AndGrep filters and text consist of numbers and special symbols.
     * @throws IOException when reader is not exist
     */
    @Test
    public void testForNumbersAndSymbols() throws IOException {
        AndGrep andGrep = new AndGrep ("-1", "<");
        when(mockReader.read()).thenReturn(48,32,62,32,45,49,10,50,32,61,32,50,10,45,49,32,60,32,51,-1);
        List<String> expectedSource = new ArrayList<String>() {{
            add("-1 < 3");
        }};
        Assert.assertArrayEquals(expectedSource.toArray(), andGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(20)).read();
    }

    /**
     * Negative test for AndGrep function. Source contains only one filter.
     * @throws IOException when reader is not exist
     */
    @Test
    public void sourceHaveOneFilter() throws IOException {
        AndGrep andGrep = new AndGrep ("my", "wife");
        when(mockReader.read()).thenReturn(109,121,32,119,111,114,108,100,10,109,121,32,108,105,102,101,10,72,101,108,108,111,-1);
        List<String> expectedSource = new ArrayList<String>() {{}};
        Assert.assertArrayEquals(expectedSource.toArray(), andGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(23)).read();
    }

    /**
     * Source doesn`t contain a text, reader is empty.
     * @throws IOException when reader is not exist
     */
    @Test
    public void readerIsEmpty() throws IOException {
        AndGrep andGrep = new AndGrep ("my", "wife");
        when(mockReader.read()).thenReturn(-1);
        List<String> expectedSource = new ArrayList<String>() {{}};
        Assert.assertArrayEquals(expectedSource.toArray(), andGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(1)).read();
    }

    /**
     * IOException test for AndGrep function
     * @throws IOException when reader is not exist
     */
    @Test(expected = IOException.class)
    public void andGrepExceptionTest() throws IOException {
        AndGrep andGrep = new AndGrep ("my", "wife");
        doThrow(IOException.class).when(mockReader).read();
        andGrep.doGrep(mockReader);
    }
}

