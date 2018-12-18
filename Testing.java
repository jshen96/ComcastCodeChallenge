import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Testing {

	private static int failed = 0, passed = 0;

	public static void main(String[] args) {
		testProg("-f test.txt -x", "39", "Testfile hex");
		testProgSystemIn("", "6","6", "System.in default");
		testProgSystemIn("-x", "a","10", "Single hex");
		testProgSystemIn("-x", "1","1", "Single num");
		testProgSystemIn("-x", "aabc12","46", "Hex ");
		testProgSystemIn("-x", "qq","0", "Hex no parsable characters");
		testProgSystemIn("", "abc123","6", "No hex");
		testProgSystemIn("", ""+ (Integer.MAX_VALUE+1),"47", "Long number");
		testProg("-f test2.txt", "6269", "Longer number");
		testErr("-f","filename not specified", "Invalid file");
		System.out.println(passed + "/" + (passed+failed) + " tests passed");
	}
	/**
	 *  manually insert into stdIn before calling testProg
	 * @param line command line
	 * @param input stdin input desired
	 * @param expOut expected output
	 * @param name name of test
	 * @return
	 */
	public static boolean testProgSystemIn(String line, String input,String expOut,String name){
		String str = input;
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
        System.setIn(bais);
		return testProg(line, expOut, name);
	}
	/**
	 * Used to test output messages and prints outcome
	 * @param line parameters
     * @param expRes expected error
     * @param testName name of test
	 * @return boolean value indicating whether test is passed or failed
	 */
    public static boolean testProg(String line, String expRes, String testName){
    	MyProg testProg = new MyProg();
    	// Create a stream to hold the output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        MyProg.main(line.split(" "));
        // Put things back
        System.out.flush();
        System.setOut(old);
        boolean res = output.toString().trim().equals(expRes.trim());
        if (res){
        	System.out.println(testName + " test \tpassed");
        	passed++;
        }else{
        	System.out.println(testName + " test failed");
        	failed ++;
        }
        return res;
        
    }
    /**
     * Used to test err messages and prints outcome
     * @param line parameters
     * @param expRes expected error
     * @param testName name of test
     * @return boolean value indicating whether test is passed or failed
     */
    public static boolean testErr(String line, String expRes,String testName){
    	MyProg testProg = new MyProg();
    	// Create a stream to hold the output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        // IMPORTANT: Save the old System.err!
        PrintStream old = System.err;
        // Tell Java to use your special stream
        System.setErr(ps);
        MyProg.main(line.split(" "));
        // Put things back
        System.err.flush();
        System.setErr(old);
        boolean res = output.toString().trim().equals(expRes.trim());
        if (res){
        	System.out.println(testName + " test passed");
        	passed++;
        }else{
        	System.out.println(testName + " test failed");
        	failed ++;
        }
        return res;
        
    }

}


