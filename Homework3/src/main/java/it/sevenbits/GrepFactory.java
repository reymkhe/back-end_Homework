package it.sevenbits;

import java.util.List;

public class GrepFactory {

    public OneWordGrep getOneWordGrep (String filter) {
        return new OneWordGrep(filter);
    }

    public OrGrep getOrGrep (final String filter1, final String filter2) {
        return new OrGrep(filter1, filter2);
    }

    public AndGrep getAndGrep (final String filter1, final String filter2) {
        return new AndGrep(filter1, filter2);
    }

    public List <IGrep> getGrep (String...filterArray) {

        switch (filterArray.length) {
            case 1:
                getOneWordGrep(filterArray[0]);
                break;
            case 2:
                // выбор или / и

            default:
                System.out.println("Grep is not exist");
                break;
        }



    }

}
