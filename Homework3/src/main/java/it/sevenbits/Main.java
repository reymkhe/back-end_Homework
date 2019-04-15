package it.sevenbits;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Main application entry point
 */
public class Main {
    /**
     * Main function for app
     * @param args - console arguments
     */
    public static void main(final String[] args) throws IOException {
        Reader reader = new FileReader(new File("MainTest"));
        OneWordGrep oneWordGrep = new OneWordGrep("world");
        System.out.println(oneWordGrep.doGrep(reader));

//        OrGrep orGrep = new OrGrep("all", "world");
//        System.out.println(orGrep.doGrep(reader));
//
//        AndGrep andGrep = new AndGrep("world", "all");
//        System.out.println(andGrep.doGrep(reader));
    }
}
