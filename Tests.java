/**
 * @author POO team 2023/24
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

/**
 * The Tests class specifies a set of tests implemented using the JUnit tool.
 * These tests use Mooshak test files as input and generate the expected result of
 * running these tests as output. The class is implemented for testing the program.
 * To use this class you need to include the JUnit 4 library in your
 * runtime environment.
 */
public class Tests {
    /**
     * Use the following lines to specify the tests you are going to carry out.
     * For example, the expected result for the test 01-in.txt is 01-out.txt.
     * You don't have to do anything else in the rest of the class.
     * Just set up this sequence of tests!
     */

    @Test public void test01() { test("input1_training.txt","output1_training.txt"); }
    @Test public void test02() { test("input2_training.txt","output2_training.txt"); }
    @Test public void test03() { test("input3_training.txt","output3_training.txt"); }
    @Test public void test04() { test("input4_training.txt","output4_training.txt"); }
    @Test public void test05() { test("input5_training.txt","output5_training.txt"); }
    @Test public void test06() { test("input6_training.txt","output6_training.txt"); }
    @Test public void test07() { test("input7_training.txt","output7_training.txt"); }
    @Test public void test08() { test("input8_training.txt","output8_training.txt"); }
    @Test public void test09() { test("input9_training.txt","output9_training.txt"); }
    /**  @Test public void test10() { test("10-in.txt","10-out.txt"); }
     @Test public void test11() { test("11-in.txt","11-out.txt"); }
     @Test public void test12() { test("12-in.txt","12-out.txt"); }
     @Test public void test13() { test("13-in.txt","13-out.txt"); }
     @Test public void test14() { test("14-in.txt","14-out.txt"); }
     @Test public void test15() { test("15-in.txt","15-out.txt"); }
     @Test public void test16() { test("16-in.txt","16-out.txt"); }
     @Test public void test17() { test("17-in.txt","17-out.txt"); }
     @Test public void test18() { test("18-in.txt","18-out.txt"); }
     @Test public void test19() { test("19-in.txt","19-out.txt"); }
     @Test public void test20() { test("20-in.txt","20-out.txt"); }*/



    private static final File BASE = new File("Tests");

    private PrintStream consoleStream;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        consoleStream = System.out;
        System.setOut(new PrintStream(outContent));
    }

    public void test(String input, String output) {
        test(new File(BASE, input), new File(BASE, output));
    }

    public void test(File input, File output) {
        consoleStream.println("Testing!");
        consoleStream.println("Input: " + input.getAbsolutePath());
        consoleStream.println("Output: " + output.getAbsolutePath());

        String fullInput = "", fullOutput = "";
        try {
            fullInput = new String(Files.readAllBytes(input.toPath()));
            fullOutput = new String(Files.readAllBytes(output.toPath()));
            consoleStream.println("INPUT ============");
            consoleStream.println(new String(fullInput));
            consoleStream.println("OUTPUT ESPERADO =============");
            consoleStream.println(new String(fullOutput));
            consoleStream.println("OUTPUT =============");
        } catch(Exception e) {
            e.printStackTrace();
            fail("Erro a ler o ficheiro");
        }

        try {
            Locale.setDefault(Locale.US);
            System.setIn(new FileInputStream(input));
            Class<?> mainClass = Class.forName("Main");
            mainClass.getMethod("main", String[].class).invoke(null, new Object[] { new String[0] });
        } catch (Exception e) {
            e.printStackTrace();
            fail("Erro no programa");
        } finally {
            byte[] outPrintBytes = outContent.toByteArray();
            consoleStream.println(new String(outPrintBytes));

            assertEquals(removeCarriages(fullOutput), removeCarriages(new String(outContent.toByteArray())));
        }
    }

    private static String removeCarriages(String s) {
        return s.replaceAll("\r\n", "\n");
    }

}