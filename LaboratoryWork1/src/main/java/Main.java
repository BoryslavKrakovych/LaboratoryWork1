public class Main {
    public static void main (String[]Args)
    {
        var calc = new StringCalculator();
        System.out.println(calc.add(""));
        System.out.println(calc.add("10"));
        System.out.println(calc.add("10,50,90,100"));
        System.out.println(calc.add("10,20\n30"));
        System.out.println(calc.add("10,20,30,\n"));
        System.out.println(calc.add("//;\n1;2"));
        System.out.println(calc.add("//%%%\n1%%%3"));
        System.out.println(calc.add("//[^^]\n1^^2^^3"));
        System.out.println(calc.add("//[**][%%%][^^]\n1**2%%%3^^6"));
        System.out.println(calc.add("-17,-18,10"));
    }
}
