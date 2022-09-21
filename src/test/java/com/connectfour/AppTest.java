package com.connectfour;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for connect-four App.
 */
public class AppTest 
    extends TestCase
{
	
    /**
     * Create the test case to test connect-four
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	TestSuite suite= new TestSuite(); 
	    suite.addTest(new AppTest("testHorizontalWin"));
	    suite.addTest(new AppTest("testVerticalWin")); 
	    suite.addTest(new AppTest("testSlashDiagonalWin"));
	    suite.addTest(new AppTest("testBacksLashDiagonalWin"));
	    suite.addTest(new AppTest("testIsGameDraw"));
	    suite.addTest(new AppTest("testIsColumnFull"));
	    suite.addTest(new AppTest("testInputAsZero"));
	    suite.addTest(new AppTest("testInputAsEight"));
	    return suite;
    }

    /**
     * Unit test to check the connect-four horizontal wins
     */
    public void testHorizontalWin() {
        String userInput = String.format("1%s1%s2%s2%s3%s3%s4%s1",
        		System.lineSeparator(), System.lineSeparator(),
        		System.lineSeparator(), System.lineSeparator(),
        		System.lineSeparator(), System.lineSeparator()
        		,System.lineSeparator());

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "\nPlayer R wins!!!";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected, actual);
    }
    
    /**
     * Unit test to check the connect-four vertical wins
     */
    public void testVerticalWin() {
        String userInput = String.format("1%s2%s1%s2%s1%s2%s1%s2",
        		System.lineSeparator(), System.lineSeparator(),
        		System.lineSeparator(), System.lineSeparator(),
        		System.lineSeparator(), System.lineSeparator()
        		,System.lineSeparator());

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "\nPlayer R wins!!!";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected, actual);
    }
    
    /**
     * Unit test to check the connect-four slash diagonal wins
     */
    public void testSlashDiagonalWin() {
        String userInput = String.format("1%s2%s3%s4%s5%s6%s7%s"
						        		+ "1%s2%s3%s4%s5%s6%s7%s"
						        		+ "1%s2%s3%s4%s5%s6%s7%s"
						        		+ "1",
        		System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(), System.lineSeparator());

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "\nPlayer G wins!!!";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected, actual);
    }
    
    /**
     * Unit test to check the connect-four back slash diagonal wins
     */
    public void testBacksLashDiagonalWin() {
        String userInput = String.format("1%s2%s1%s2%s1%s2%s1%s"
						        		+ "2%s3%s4%s3%s4%s3%s4"
						        		+ "%s3%s4",
        		System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator());

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "\nPlayer R wins!!!";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected, actual);
    }

    /**
     * Unit test to check the connect-four play has no winner
     */
    public void testIsGameDraw() {
        String userInput = String.format("1%s2%s1%s2%s1%s2%s2%s" + 
        		"1%s2%s1%s2%s1%s3%s4%s" + 
        		"3%s4%s3%s4%s4%s3%s4%s" + 
        		"3%s4%s3%s5%s6%s5%s6%s" + 
        		"5%s6%s6%s5%s6%s5%s6%s" + 
        		"5%s7%s7%s7%s7%s7%s7",
        		System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator(),System.lineSeparator(), System.lineSeparator());

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Game over. No winner. Try again!";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected, actual);
    }

    /**
     * Unit test to check the connect-four column is filled by player(s) already
     */
    public void testIsColumnFull() {
        String userInput = String.format("1%s1%s1%s1%s1%s1%s1%s"
						        		+ "2%s3%s4%s3%s4%s3%s4"
						        		+ "%s3%s4",
        		System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator(),System.lineSeparator(), System.lineSeparator()
        		,System.lineSeparator(), System.lineSeparator(),System.lineSeparator());

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Column 0 is full";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        List<String> linesList = Arrays.asList(lines);
        if(linesList.contains(expected)) {
        	assertTrue(true);
        } else {
        	assertTrue(false);
        }
    }
    
    /**
     * Unit test to check the connect-four, pass incorrect input < 1
     */
    public void testInputAsZero() {
        String userInput = String.format("0%s1%s2%s1%s2%s1%s2%s1%s2",
        		System.lineSeparator(), System.lineSeparator(),
        		System.lineSeparator(), System.lineSeparator(),
        		System.lineSeparator(), System.lineSeparator(),
        		System.lineSeparator(),System.lineSeparator());

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Column must be between 1 and 7";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        List<String> linesList = Arrays.asList(lines);
        if(linesList.contains(expected)) {
        	assertTrue(true);
        } else {
        	assertTrue(false);
        }
    }
    
    /**
     * Unit test to check the connect-four, pass incorrect input > 7
     */
    public void testInputAsEight() {
        String userInput = String.format("8%s1%s2%s1%s2%s1%s2%s1%s2",
        		System.lineSeparator(), System.lineSeparator(),
        		System.lineSeparator(), System.lineSeparator(),
        		System.lineSeparator(), System.lineSeparator(),
        		System.lineSeparator(),System.lineSeparator());

        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Column must be between 1 and 7";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        App.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        List<String> linesList = Arrays.asList(lines);
        if(linesList.contains(expected)) {
        	assertTrue(true);
        } else {
        	assertTrue(false);
        }
    }
}
