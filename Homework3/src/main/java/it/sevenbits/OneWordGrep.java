package it.sevenbits;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OneWordGrep implements IGrep {
    private String filter;

    public OneWordGrep (final String filter) {
        this.filter = filter;
    }

    public List doGrep(final Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        List<String> grepedSource = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains(filter)) {
                grepedSource.add(line);
            }
        }
        return grepedSource;
    }
}
