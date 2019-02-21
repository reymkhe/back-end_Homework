package it.sevenbits;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Interface with grep
 */
public interface IGrep {
    /**
     * DoGrep function filters a text source and
     * @param reader - reader for source
     * @return
     */
    List doGrep(final Reader reader) throws IOException;
}
