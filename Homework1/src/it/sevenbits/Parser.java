package it.sevenbits;

public class Parser {
    public static String[] parse (final String strInput){
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < strInput.length(); i++) {
            if (strInput.charAt(i) == ' ') {
                count++;
            }
        }
        String[] strings = new String[count+1];
        for (int i=0, j=0; i < strInput.length(); i++){
            if (strInput.charAt(i)!= ' '){
                sb=sb.append(strInput.charAt(i));
            }
            if (strInput.charAt(i)== ' ' || i==strInput.length()-1) {
                strings[j]=sb.toString();
                j++;
                sb.setLength(0);
            }
        }
        return strings;
    }
}
