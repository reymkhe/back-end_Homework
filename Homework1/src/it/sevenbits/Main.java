package it.sevenbits;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String [] strings = Parser.parse(" ada   oj  gj ");
        System.out.println(Arrays.toString(strings));
    }
}
