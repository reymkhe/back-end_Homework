package it.sevenbits;

public class Parser {
    public static String[] parse(final String strInput) {
        String trimedString = strInput.trim();
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < trimedString.length(); i++) {
            if (trimedString.charAt(i) != ' ') {
                stringBuilder.append(trimedString.charAt(i));
            }
            if (trimedString.charAt(i) == ' ') {
                if (trimedString.charAt(i - 1) != ' ') {
                    stringBuilder.append(trimedString.charAt(i));
                    count++;
                }
            }
        }

        trimedString = stringBuilder.toString();
        StringBuilder sb = new StringBuilder();
        String[] arrayOfStrings = new String[count + 1];
        for (int i = 0, j = 0; i < trimedString.length(); i++) {
            if (trimedString.charAt(i) != ' ') {
                sb.append(trimedString.charAt(i));
            }
            if (trimedString.charAt(i) == ' ' || i == trimedString.length() - 1) {
                arrayOfStrings[j] = sb.toString();
                j++;
                sb.setLength(0);
            }
        }
        return arrayOfStrings;
    }
}
