package it.sevenbits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class OrGrep implements IGrep {
    private String filter1;
    private String filter2;

    public OrGrep(final String filter1, final String filter2) {
        this.filter1 = filter1;
        this.filter2 = filter2;
    }

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
