package it.sevenbits;

import java.io.*;
import java.util.List;

/**
 * Main application entry point
 */
public class Main {
    /**
     * Main function for app
     *
     * @param args - console arguments
     */
    public static void main(final String[] args) throws IOException {

        Reader reader = null;
        switch (args[0]) {
            case "-f":
                String filePath = args[1];
                File file = new File(filePath);
                reader = new FileReader(file);
                break;
            case "-s":
                String string = args[1];
                reader = new StringReader(string);
                break;
            default:
                System.out.println("enter -s or -f");
        }

        String spliter;
        switch (args.length) {
            case 6:
                if (args[4].equals("-d")) {
                    spliter = args[5];
                } else {
                    spliter = " ";
                }
                break;
            case 4:
            case 5:
            default:
                spliter = " ";
        }

        IGrep grep = null;
        String[] filter;
        switch (args[2]) {
            case "-and":
                filter = args[3].split(spliter, 2);
                grep = GrepFactory.getAndGrep(filter[0], filter[1]);
                break;
            case "-or":
                filter = args[3].split(spliter, 2);
                grep = GrepFactory.getOrGrep(filter[0], filter[1]);
                break;
            case "-one":
                grep = GrepFactory.getOneWordGrep(args[3]);
                break;
            default:
                System.out.println("enter -and or -or or -one ");
        }

        List grepedSource = grep.doGrep(reader);
        System.out.println(grepedSource);
    }
}
