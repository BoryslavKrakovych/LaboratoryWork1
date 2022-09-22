public class StringCalculator {


    public static int add(String text){
        try {
            if (text.isEmpty()) {
                return 0;
            } else if (text.matches("(.*)-[1-9](.*)")) {
                throw new RuntimeException("Negatives are not allowed:" + getNegatives(text));
            } else if (text.startsWith("//")) {
                String delimeter = getDelimeter(text);
                return returnSum(splitString(text, delimeter));
            } else if (text.toLowerCase().contains(",\n") || text.toLowerCase().contains("\n,")) {
                    throw new RuntimeException("Incorrect syntax!");
            }else if (text.contains(",") | text.contains("\\n")) {
                String[] str = text.split("[\\W]");
                return returnSum(str);
            } else {
                return Integer.parseInt(text);
            }
        }
        catch(NumberFormatException e){
            throw new RuntimeException("Incorrect syntax!");
        }
    }

    private static int returnSum(String[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i].equals(""))continue;
            if(Integer.parseInt(arr[i]) <= 1000){
                sum += Integer.parseInt(arr[i]);
            }
        }

        return sum;
    }

    private static String getNegatives(String text){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == '-'){
                if(!(sb.toString().equals(""))){
                    sb.append(',');
                }
                sb.append('-');
                sb.append(text.charAt(i +1));
            }
        }
        return sb.toString();
    }
    private static String getDelimeter(String text){
        StringBuilder sb = new StringBuilder();

        for(int i = 2; text.charAt(i) != '\n'; i++){
            sb.append(text.charAt(i));
            if(text.charAt(i) == ']' && text.charAt(i+1) != '\n'){
                sb.append("|");
            }
        }

        return sb.toString();
    }

    private static String[] splitString(String text, String del){
        int i = 0;
        while(text.charAt(i) != '\n'){i++;}
        String newString = text.substring(i + 1);
        return newString.split(del);
    }
}
