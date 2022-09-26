import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {
    StringCalculator Calculator=new StringCalculator();
    @Test
    public void test1() {
        assertEquals(0,Calculator.add(null));
        assertEquals(0,Calculator.add(""));
        assertEquals(1,Calculator.add("1"));
        assertEquals(3,Calculator.add("1,2"));

    }

    @Test
    public void test2(){
        assertEquals(6, Calculator.add("1,2,3"));
        assertEquals(4, Calculator.add("1,1,1,1"));
        assertEquals(3, Calculator.add("1,2"));
        assertEquals(66, Calculator.add("11,22,33"));
    }

    @Test
    public void test3(){
        assertEquals(6, Calculator.add("1\n2,3"));
        assertEquals(15, Calculator.add("4\n5\n6"));
        try{
            Calculator.add("4,5,6,\n");
        }
        catch(RuntimeException e){
            assertEquals("Incorrect Syntax Format!", e.getMessage());
        }
    }

    @Test
    public void test4() {
        assertEquals(1, Calculator.add("1,1001"));
        assertEquals(2, Calculator.add("1002\n2"));
        assertEquals(1001, Calculator.add("1,1000"));
        assertEquals(2000, Calculator.add("1000,1000"));
        assertEquals(0, Calculator.add("1001,1001"));
    }

    @Test
    public void test5(){
        assertEquals(3, Calculator.add("//;\n1;2"));
        assertEquals(5, Calculator.add("//*\n2,3"));
        assertEquals(7, Calculator.add("//#\n3#4"));
        try{
            Calculator.add("//;\n1#2");
        }
        catch(RuntimeException e){
            assertEquals("Wrong Delimiter Error!", e.getMessage());
        }
    }

    @Test
    public void test6(){
        assertEquals(6, Calculator.add("//[***]\n1***2***3"));
        assertEquals(20, Calculator.add("//[xy]\n3xy4xy5xy8"));
    }

    @Test
    public void test7(){
        assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
        assertEquals(8, Calculator.add("//[&&][|||]\n3|||2&&3"));
    }



    @Test
    public void test8(){
        try{
            Calculator.add("1,-1");
        }
        catch(RuntimeException e){
            assertEquals("Negatives are not allowed:-1", e.getMessage());
        }
        try{
            Calculator.add("-1");
        }
        catch(RuntimeException e){
            assertEquals("Negatives are not allowed:-1", e.getMessage());
        }
        try{
            Calculator.add("-1,-2");
        }
        catch(RuntimeException e){
            assertEquals("Negatives are not allowed:-1,-2", e.getMessage());
        }
        try{
            Calculator.add("-1,1\n-1");
        }
        catch(RuntimeException e){
            assertEquals("Negatives are not allowed:-1", e.getMessage());
        }
    }

    @Test
    public void test9() {
        assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
        assertEquals(8, Calculator.add("//[&&][|||]\n3|||2&&3"));
        assertEquals(7, Calculator.add("//[//]\n 1//2//4"));
        assertEquals(1998, Calculator.add("999,999"));
        assertEquals(3, Calculator.add("3,1001"));
        assertEquals(6, Calculator.add("//[*][%][]\n1*2%3"));
    }

}