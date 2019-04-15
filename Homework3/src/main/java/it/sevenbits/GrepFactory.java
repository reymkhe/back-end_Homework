package it.sevenbits;

/**
 * Factory for grep
 */
public class GrepFactory {

    /**
     * Function creates OneWordGrep
     * @param filter - filter for source, one world
     * @return OneWordGrep
     */
    public OneWordGrep getOneWordGrep(final String filter) {
        return new OneWordGrep(filter);
    }

    /**
     * Function creates OrGrep
     * @param filter1 - filter for source, first world
     * @param filter2 - filter for source, second world
     * @return OrGrep
     */
    public OrGrep getOrGrep(final String filter1, final String filter2) {
        return new OrGrep(filter1, filter2);
    }

    /**
     * Function creates AndGrep
     * @param filter1 - filter for source, first world
     * @param filter2 - filter for source, second world
     * @return AndGrep
     */
    public AndGrep getAndGrep(final String filter1, final String filter2) {
        return new AndGrep(filter1, filter2);
    }

}
