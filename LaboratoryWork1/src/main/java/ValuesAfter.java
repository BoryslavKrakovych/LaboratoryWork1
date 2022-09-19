public class ValuesAfter {
        public static class Values extends RuntimeException {
            public Values(String s) {
                super(s);
            }
        }

        public static void throwExceptionIfValue(String numbers) {
            if (numbers.toLowerCase().contains(",\n") || numbers.toLowerCase().contains("\n,")) {
                {
                    throw new Values("Incorrect syntax!");
                }
            }

        }
}
