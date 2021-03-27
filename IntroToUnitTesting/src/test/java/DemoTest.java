
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */
public class DemoTest {


    @Test
    public void test_is_triangle_1() {
        assertTrue(Demo.isTriangle(3,4,5));
    }

    @Test
    public void test_is_triangle_2() {
        assertTrue(Demo.isTriangle(6,12,15));
    }

    @Test
    public void test_is_triangle_3() {
        assertTrue(Demo.isTriangle(8,6,12));;
    }

    @Test
    public void test_is_NOT_triangle_1() {
        assertFalse(Demo.isTriangle(-3,45,34));
    }

    @Test
    public void test_is_NOT_triangle_2() {
        assertFalse(Demo.isTriangle(0,7,12));
    }

    @Test
    public void test_MAIN_program() {
        ByteArrayInputStream in = new ByteArrayInputStream("5\n12\n13\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String consoleOutput = "Enter side 1:\n";
        consoleOutput += "Enter side 2:\n";
        consoleOutput += "Enter side 3:\n";
        consoleOutput += "This is a triangle.\n";

        assertEquals(consoleOutput,out.toString());
    }


}
