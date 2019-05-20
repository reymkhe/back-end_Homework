package it.sevenbits;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Tests for class OneWordGrep
 */
public class OneWordGrepTest {

        private Reader mockReader = mock(Reader.class);

    /**
     * Simple positive test for OneWordGrep function, grep filter is word.
     * @throws IOException when reader is not exist
     */
    @Test
    public void simplePositiveTest() throws IOException {
        OneWordGrep oneWordGrep = new OneWordGrep("world");
        when(mockReader.read()).thenReturn(72,101,108,108,111,32,119,111,114,108,100,10,109,121,32,108,105,102,101,-1);
        List<String> expectedSource = new ArrayList<String>() {{
            add("Hello world");
        }};
        Assert.assertArrayEquals(expectedSource.toArray(), oneWordGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(20)).read();
    }

    /**
     * Positive test for OneWordGrep function. Grep filter is the space.
     * @throws IOException when reader is not exist
     */
    @Test
    public void grepFilterIsSpace() throws IOException {
        OneWordGrep oneWordGrep = new OneWordGrep(" ");
        when(mockReader.read()).thenReturn(72,101,108,108,111,32,119,111,114,108,100,10,109,121,10,105,102,101,-1);
        List<String> expectedSource = new ArrayList<String>() {{
            add("Hello world");
        }};
        Assert.assertArrayEquals(expectedSource.toArray(), oneWordGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(19)).read();
    }

    /**
     * Positive test for OneWordGrep function. Grep filter and text include numbers and special symbols.
     * @throws IOException when reader is not exist
     */
    @Test
    public void testForNumbersAndSymbols() throws IOException {
        OneWordGrep oneWordGrep = new OneWordGrep("-1");
        when(mockReader.read()).thenReturn(48,32,62,32,45,49,10,50,32,61,32,50,10,45,49,32,60,32,51,-1);
        List<String> expectedSource = new ArrayList<String>() {{
            add("0 > -1");
            add("-1 < 3");
        }};
        Assert.assertArrayEquals(expectedSource.toArray(), oneWordGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(20)).read();
    }

    /**
     * Simple negative test for OneWordGrep function. Text source doesn`t contain a filter.
     * @throws IOException when reader is not exist
     */
    @Test
    public void textNotHaveFilter() throws IOException {
        OneWordGrep oneWordGrep = new OneWordGrep("omg");
        when(mockReader.read()).thenReturn(72,101,108,108,111,32,119,111,114,108,100,10,109,121,32,108,105,102,101,-1);
        List<String> expectedSource = new ArrayList<String>() {{}};
        Assert.assertArrayEquals(expectedSource.toArray(), oneWordGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(20)).read();
    }

    /**
     * Source doesn`t contain a text, reader is empty.
     * @throws IOException when reader is not exist
     */
    @Test
    public void readerIsEmpty() throws IOException {
        OneWordGrep oneWordGrep = new OneWordGrep("omg");
        when(mockReader.read()).thenReturn(-1);
        List<String> expectedSource = new ArrayList<String>() {{}};
        Assert.assertArrayEquals(expectedSource.toArray(), oneWordGrep.doGrep(mockReader).toArray());
        verify(mockReader, times(1)).read();
    }

    /**
     * IOException test for OneWordGrep function
     * @throws IOException when reader is not exist
     */
    @Test(expected = IOException.class)
    public void oneWordGrepExceptionTest() throws IOException {
        OneWordGrep oneWordGrep = new OneWordGrep("omg");
        doThrow(IOException.class).when(mockReader).read();
        oneWordGrep.doGrep(mockReader);
    }
}

