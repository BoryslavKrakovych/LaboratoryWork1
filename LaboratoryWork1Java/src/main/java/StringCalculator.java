
public class StringCalculator {

    public int add(String number) {

        if (number == null || number.isEmpty()) return 0;
        if (number.toLowerCase().contains(",\n") || number.toLowerCase().contains("\n,")) {
            throw new RuntimeException("Incorrect Syntax Format!");}
        if (number.matches("(.*)-[1-9](.*)")) {
            throw new RuntimeException("Negatives are not allowed:" + getNegatives(number));}
        if (number.charAt(0) == '/')
        {
            String Delimiter=addSplit(number);
            return returnSum(Delimiter);
        }
        else {
            return returnSum(number);}
    }

    private static String addSplit(String text) {
        StringBuilder split = new StringBuilder();
        //text = text.replaceAll(" ", "");
        text = text.substring(2);
        if (text.charAt(0) == '[') {
            for (int j = 1; text.charAt(j) != '\n'; j++) {
                if (text.charAt(0) == '[') {
                    if (text.charAt(1) == ']') {
                        text = text.substring(2);
                        j = 0;
                        continue;
                    }
                    split.append(text.charAt(j));
                    if (text.charAt(j + 1) == ']') {
                        text = text.replace(split.toString(), ",");
                        split = new StringBuilder();
                        text = text.substring(3);
                        j = 0;
                    }

                } else {
                    break;
                }
            }
        }
        else {
            split.append(text.charAt(0));
            text = text.replace(split.toString(), ",");
        }
        for (int i = 0; i < text.length(); i++) {
            if ((!Character.isDigit(text.charAt(i)))&& text.charAt(i) != '\n' && text.charAt(i) != ' ' && text.charAt(i) != ','){
                throw new RuntimeException("Wrong Delimiter Error!");
            }
        }
         return text;
    }

    private static String getNegatives(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '-') {
                if (!(sb.toString().equals(""))) {
                    sb.append(',');
                }
                sb.append('-');
                sb.append(text.charAt(i + 1));
            }
        }
        return sb.toString();
    }
    private static int returnSum(String arr) {
        arr = arr.replaceAll("\\s+", ",");
        String[] str = arr.split(",");
        int sum = 0;
        int num;
        for (String s : str) {
            if (!s.isEmpty()) {
                try{
                    num = Integer.parseInt(s);}
                catch(NumberFormatException e){
                    throw new RuntimeException("Incorrect syntax Format!");}
                if (num > 1000) continue;
                sum += num;
            }

            }
        return sum;
    }

}
