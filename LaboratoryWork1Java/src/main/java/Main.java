public class Main{
    public static void main(String[]Args){
        var Calculator = new StringCalculator();
        try{
            System.out.println(Calculator.add("//[!]\n1!!!2!!!3"));
        }
        catch (Exception e ){
            e.printStackTrace(System.out);
        }
    }
}