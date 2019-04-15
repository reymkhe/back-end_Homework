package it.sevenbits;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

/**
 * Tests for class OneWordGrep
 */
public class OneWordGrepTest {

    private Reader mockReader = mock(Reader.class);
    private BufferedReader mockBufferedReader = mock(BufferedReader.class);

    /**
     *Simple positive test for OneWordGrep function
     * @throws Exception when reader is not exist
     */
    @Test
    public void oneWordGrepSimplePositiveTest() throws Exception {
        OneWordGrep oneWordGrep = new OneWordGrep("world");
        PowerMockito.whenNew(BufferedReader.class).
                withArguments(mockReader).
                thenReturn(mockBufferedReader);
        when(mockBufferedReader.readLine()).thenReturn("Hello world", "You are beautiful", "World is beautiful");
        List<String> expectedSource = new ArrayList<String>() {{
            add(new String("Hello world"));
            add(new String("World is beautiful"));
        }};
        Assert.assertArrayEquals(expectedSource.toArray(), oneWordGrep.doGrep(mockReader).toArray());
        verify(mockBufferedReader, times(3)).readLine();
    }
}
