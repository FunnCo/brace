
import org.junit.Before;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.Assert.*;


public class MainTests {
    Main main;
    @Before
    public void prepare(){
        main = new Main();
    }

    @Test
    public void getStringTest() throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileInputStream(main.getFilepath()));
        String stringExpected = "";
        while (scanner.hasNext()){
            stringExpected = stringExpected + scanner.next();
        }
        String stringActual = main.getString();
        assertEquals(stringExpected,stringActual);
    }

    @Test
    public void validationTest(){

        String string = "(())";
        char[] chars = string.toCharArray();
        boolean expected = true;
        boolean actual = main.validation(chars);
        assertEquals(expected,actual);
    }

    @Test
    public void validationNegativeTest() throws FileNotFoundException {

        String string = "((())";
        char[] chars = string.toCharArray();
        boolean expected = true;
        boolean actual = main.validation(chars);
        assertNotEquals(expected,actual);
    }
}
