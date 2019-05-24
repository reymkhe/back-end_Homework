package it.sevenbits;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Interface with grep
 */
public interface IGrep {
    /**
     * DoGrep function filters a text source and shows strings that have a filter
     * @param reader - reader for source
     * @return List with strings that have a filter
     * @throws IOException when filter or reader is not exist
     */
    List doGrep(Reader reader) throws IOException;
}
