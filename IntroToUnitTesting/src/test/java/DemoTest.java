import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


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
        assertTrue(Demo.isTriangle(5,7,6));
    }

    @Test
    public void test_is_triangle_2() {
        assertTrue(Demo.isTriangle(5,7,7));
    }

    @Test
    public void test_is_triangle_3() {
        assertTrue(Demo.isTriangle(4.0,4,4));
    }

    @Test
    public void test_is_triangle_4() {
        assertTrue(Demo.isTriangle(4,4.0,4));
    }

    @Test
    public void test_is_triangle_5() {
        assertTrue(Demo.isTriangle(4,4,4.0));
    }

    @Test
    public void test_is_triangle_6() {
        assertTrue(Demo.isTriangle(5,6,8));
    }

    @Test
    public void test_is_triangle_7() {
        assertTrue(Demo.isTriangle(5,6,5));
    }

    @Test
    public void test_is_triangle_8() {
        assertTrue(Demo.isTriangle(3,7,7));
    }

    @Test
    public void test_is_triangle_9() {
        assertTrue(Demo.isTriangle(6,6,4));
    }

    @Test
    public void test_is_triangle_10() {
        assertTrue(Demo.isTriangle(25,34,14.0));
    }

    @Test
    public void test_is_triangle_11() {
        assertTrue(Demo.isTriangle(33,23.0,54));
    }

    @Test
    public void test_is_triangle_12() {
        assertTrue(Demo.isTriangle(14.0,33,30));
    }



    @Test
    public void test_is_NOT_triangle_2() {
        assertFalse(Demo.isTriangle(0,2,12));
    }

    @Test
    public void test_is_NOT_triangle_3() {
        assertFalse(Demo.isTriangle(2,0,2));
    }

    @Test
    public void test_is_NOT_triangle_4() {
        assertFalse(Demo.isTriangle(12,2,0));
    }

    @Test
    public void test_is_NOT_triangle_5() {
        assertFalse(Demo.isTriangle(-12,2,1));
    }

    @Test
    public void test_is_NOT_triangle_6() {
        assertFalse(Demo.isTriangle(12,-0,1));
    }

    @Test
    public void test_is_NOT_triangle_7() {
        assertFalse(Demo.isTriangle(12,2,-1));
    }

    @Test
    public void test_is_NOT_triangle_8() {
        assertFalse(Demo.isTriangle(12,2,+1));
    }

    @Test
    public void test_is_NOT_triangle_9() {
        assertFalse(Demo.isTriangle(12,+2,1));
    }

    @Test
    public void test_is_NOT_triangle_10() {
        assertFalse(Demo.isTriangle(756,2,1));
    }

    @Test
    public void test_is_NOT_triangle_11() {
        assertFalse(Demo.isTriangle(1,10,100));
    }

    @Test
    public void test_is_NOT_triangle_12() {
        assertFalse(Demo.isTriangle(+12,2,-1));
    }

    @Test
    public void test_is_NOT_triangle_13() {
        assertFalse(Demo.isTriangle(312,992,881));
    }
    /*
    @Test
    public void test_MAIN_program() {
        ByteArrayInputStream in = new ByteArrayInputStream("5\n12\n13\n".getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String consoleOutput = "Enter side 1: "
                + System.getProperty("line.separator")
                + "Enter side 2: "
                + System.getProperty("line.separator")
                + "Enter side 3: "
                + System.getProperty("line.separator")
                + "This is not a triangle."
                + System.getProperty("line.separator");

        assertEquals(consoleOutput, out.toString());
    }
    */

}
