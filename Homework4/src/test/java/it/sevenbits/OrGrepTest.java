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
 * Tests for class OrGrep
 */
public class OrGrepTest {

    private Reader mockReader = mock(Reader.class);

    /**
     * Simple positive test for OrGrep function, grep filters are words.
     * @throws IOException when reader is not exist
     */
    @Test
    public void simplePositiveTest() throws IOException {
        OrGrep orGrep = new OrGrep ("my", "life");
        when(mockReader.read()).thenReturn(109,121,32,119,111,114,108,100,10,109,121,32,108,105,102,101,10,72,101,108,108,111,-1);
        List<String> expectedSource = new ArrayList<String>() {{
            add("my world");
            add("my life");
        }};
        Assert.assertArrayEquals(expectedSource.toArray(), orGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(23)).read();
    }

    /**
     * Grep filters are the same words.
     * @throws IOException when reader is not exist
     */
    @Test
    public void filtersAreEquals() throws IOException {
        OrGrep orGrep = new OrGrep ("my", "my");
        when(mockReader.read()).thenReturn(109,121,32,119,111,114,108,100,10,109,121,32,108,105,102,101,10,72,101,108,108,111,-1);
        List<String> expectedSource = new ArrayList<String>() {{
            add("my world");
            add("my life");
        }};
        Assert.assertArrayEquals(expectedSource.toArray(), orGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(23)).read();
    }

    /**
     * OrGrep filters and text consist of numbers and special symbols.
     * @throws IOException when reader is not exist
     */
    @Test
    public void testForNumbersAndSymbols() throws IOException {
        OrGrep orGrep = new OrGrep ("-1", "=");
        when(mockReader.read()).thenReturn(48,32,62,32,45,49,10,50,32,61,32,50,10,45,49,32,60,32,51,-1);
        List<String> expectedSource = new ArrayList<String>() {{
            add("0 > -1");
            add("2 = 2");
            add("-1 < 3");
        }};
        Assert.assertArrayEquals(expectedSource.toArray(), orGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(20)).read();
    }

    /**
     * Simple negative test for OrGrep function. Text source doesn`t contain filters.
     * @throws IOException when reader is not exist
     */
    @Test
    public void textNotHaveFilters() throws IOException {
        OrGrep orGrep = new OrGrep("omg", "gg");
        when(mockReader.read()).thenReturn(72,101,108,108,111,32,119,111,114,108,100,10,109,121,32,108,105,102,101,-1);
        List<String> expectedSource = new ArrayList<String>() {{}};
        Assert.assertArrayEquals(expectedSource.toArray(), orGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(20)).read();
    }

    /**
     * Negative test for OrGrep function. Source doesn`t contain a text, reader is empty.
     * @throws IOException when reader is not exist
     */
    @Test
    public void readerIsEmpty() throws IOException {
        OrGrep orGrep = new OrGrep("omg", "gg");
        when(mockReader.read()).thenReturn(-1);
        List<String> expectedSource = new ArrayList<String>() {{}};
        Assert.assertArrayEquals(expectedSource.toArray(), orGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(1)).read();
    }

    /**
     * IOException test for OrGrep function
     * @throws IOException when reader is not exist
     */
    @Test(expected = IOException.class)
    public void orGrepExceptionTest() throws IOException {
        OrGrep orGrep = new OrGrep("omg", "gg");
        doThrow(IOException.class).when(mockReader).read();
        orGrep.doGrep(mockReader);
    }


    /**
     * Test for OrGrep function, grep with case-insensitive filters
     * @throws IOException when reader is not exist
     */
    @Test
    public void caseInsensitiveFilterOrGrep() throws IOException {
        OrGrep orGrep = new OrGrep ("mY", "liFe");
        when(mockReader.read()).thenReturn(109,121,32,119,79,82,108,100,10,109,121,32,76,105,102,101,10,72,101,108,108,111,-1);
        List<String> expectedSource = new ArrayList<String>() {{
            add("my wORld");
            add("my Life");
        }};
        Assert.assertArrayEquals(expectedSource.toArray(), orGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(23)).read();
    }
}

