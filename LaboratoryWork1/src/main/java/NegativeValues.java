public class NegativeValues {
    public static class NegativesNotAllowed extends RuntimeException {
        public NegativesNotAllowed(String s) {
            super(s);
        }
    }

    public static void throwExceptionIfNegativeExists(String negative_numbers_str) {
        if (negative_numbers_str != "") {
            throw new NegativesNotAllowed("Negatives not allowed. Negative numbers are: " + negative_numbers_str);
        }
    }

}