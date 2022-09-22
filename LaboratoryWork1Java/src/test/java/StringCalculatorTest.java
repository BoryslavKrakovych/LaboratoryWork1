import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {
    StringCalculator Calculator=new StringCalculator();

    @Test
    public void testEmptyString() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testOneNumberInput(){
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void testTwoNumbersInput(){
        assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void testAnyNumbersInput(){
        assertEquals(13, Calculator.add("1,2,10"));
    }

    @Test
    public void testHandleNewLine(){
        assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testDifferentDelimeter(){
        assertEquals(3, Calculator.add("//-\n1-2"));
    }

    @Test
    public void testNegativeNumber(){
        try{
            Calculator.add("2,-4,3,-5");
        }
        catch(RuntimeException e){
            assertEquals("Negatives are not allowed:-4,-5", e.getMessage());
        }
    }

    @Test
    public void testIgnoreGreaterThenThousand(){
        assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testAnyLengthDelimeter(){
        assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testAllowMultipleParameters(){
        assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testAllowMultipleParametersOfAnyLength(){
        assertEquals(216, Calculator.add("//[***][%%]\n1***212%%3"));
    }
}