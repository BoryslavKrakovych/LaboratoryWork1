public class ValuesAfter {
        public static class Values extends RuntimeException {
            public Values(String s) {
                super(s);
            }
        }

        public static void throwExceptionIfValue(String n) {
            if (n == "\n") {
                throw new Values("Error!");
            }
        }

}
