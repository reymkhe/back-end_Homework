package it.sevenbits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Grep with two word filter using first or second world
 */
public class OrGrep implements IGrep {
    private String filter1;
    private String filter2;

    /**
     * OrGrep constructor
     * @param filter1 - first world
     * @param filter2 - second world
     */
    public OrGrep(final String filter1, final String filter2) {
        this.filter1 = filter1;
        this.filter2 = filter2;
    }

    /**
     * doGrep function filters a text source and shows strings that have a filter
     * @param reader - reader for source
     * @return List containing strings that have a filter
     * @throws IOException when filter or reader is not exist
     */
    public List doGrep(final Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        List<String> grepedSource = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains(filter1)) {
                grepedSource.add(line);
            } else {
                if (line.contains(filter2)) {
                    grepedSource.add(line);
                }
            }

        }
        return grepedSource;
    }
}
