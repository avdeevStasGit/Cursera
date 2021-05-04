package skeleton;
import cucumber.api.java.en.When;

public class Stepdefs {

    @When("^test_posint (\\d+)$")
    public void test_posint(int number) throws Throwable {
        System.out.println("test_posint true for: " + number);
    }

    @When("^test_int (-?\\d+)$")
    public void test_int(int arg1) throws Throwable {
        System.out.println("test_int true for: " + arg1);
    }

    @When("^test_float (-?\\d+\\.\\d+)$")
    public void test_float(float arg1) throws Throwable {
        System.out.println("test_int true for: " + arg1);
    }

    @When("^test_ip_address (\\d+\\.\\d+\\.\\d+\\.\\d+)$")
    public void test_ip_address(String arg1) throws Throwable {
        System.out.println("test_ip_address true for: " + arg1);
    }

    @When("^test_splitter (\\w+)$")
    public void test_splitter(String match) throws Throwable {
        System.out.println("test_splitter true for: " + match);
    }

    @When("^test_splitter2 (\\w+)$")
    public void test_splitter2(String match) throws Throwable {
        System.out.println("test_splitter2 true for: " + match);
    }
}
