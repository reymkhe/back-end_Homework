package it.sevenbits;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Grep with one word filter
 */
public class OneWordGrep implements IGrep {
    private String filter;

    /**
     * OneWordGrep constructor
     * @param filter - filter for source, one world
     */
    public OneWordGrep(final String filter) {
        this.filter = filter;
    }

    /**
     * doGrep function filters a text source and shows strings that have a filter
     * @param reader - reader for source
     * @return List containing strings that have a filter
     * @throws IOException when filter or reader is not exist
     */
    public List doGrep(final Reader reader) throws IOException {
        List<String> grepedSource = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            char readChar = (char) c;
            sb.append(readChar);
        }
        String result = new String(sb);
        String[] lineArray = result.split("\n");
        for (String line:lineArray) {
            if (line.contains(filter)) {
                grepedSource.add(line);
            }
        } return grepedSource;
    }
}

