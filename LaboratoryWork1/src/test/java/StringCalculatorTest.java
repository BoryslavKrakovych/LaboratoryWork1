import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Test
public class StringCalculatorTest {
    private StringCalculator Calculate;

    @org.testng.annotations.BeforeMethod
    public void setUp() {
        System.out.println("Starting Test....");
        Calculate = new StringCalculator();
    }

    public void emptyString(){
        assertEquals(Calculate.add(""), 0);
    }
    public void oneNumber(){
        assertEquals(Calculate.add("10"), 10);
    }
    public void twoNumbers(){
        assertEquals(Calculate.add("10,20"), 30);
    }
    public void FourNumbers(){
        assertEquals(Calculate.add("10,50,90,100"), 250);
    }
    public void handleNewLines(){
        assertEquals(Calculate.add("10,20\n30"), 60);
    }
    public void handleNewLinesWithDelimiterOnTheEnd(){
           try{
               Calculate.add("10,20,30,\n");
           }
           catch (ValuesAfter.Values e){
               assertEquals(e.getMessage(),"Incorrect syntax!");
           }
    }
    public void customDelimiter(){
        assertEquals(Calculate.add("//;\n1;2"), 3);
    }
    public void checkNegative() {
        try {
            Calculate.add("-17,-18,10");
        } catch (NegativeValues.NegativesNotAllowed e) {
            assertEquals(e.getMessage(), "Negatives not allowed. Negative numbers are: -17 -18 ");
        }
    }
    public void checkNegativeInCustomDelimiter() {
        try {
            Calculate.add("//%\n1%-8%-1%-12%26");
        } catch (NegativeValues.NegativesNotAllowed e) {
            assertEquals(e.getMessage(), "Negatives not allowed. Negative numbers are: -8 -1 -12 ");
        }
    }
    public void greaterThan1000(){
        assertEquals(Calculate.add("1000,999,1001"), 1999);
    }
    public void longLengthDelimiterWithoutBraces(){
        assertEquals(Calculate.add("//%%%\n1%%%3"), 4);
    }
    public void longLengthDelimiterWithBraces(){
        assertEquals(Calculate.add("//[^^]\n1^^2^^3"), 6);
    }
    public void longLengthMultipleDelimiters(){
        assertEquals(Calculate.add("//[**][%%%][^^]\n1**2%%%3^^6"), 12);
    }
    @org.testng.annotations.AfterMethod
    public void tearDown() {
        System.out.println("Completed!!!!");
    }
}