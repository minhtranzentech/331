import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.util.EmptyStackException;
import java.io.IOException;
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;

/**
 * The CountWords main program counts the frequencies of words (all converted to
 * lower case) in a specified text file, and prints counts for a few particular
 * words. 
 *
 * @author  Mike Jacobson
 * @version 1.0
 */
public class CountWords {

    /**
     *  Prints the number of occurrences of the given string in the Map.
     */
    private static void printOccurrences(SimpleMap<String,Integer> M, String target) {
	Integer numOccurrences;
	try {
	    numOccurrences = M.search(target);
	}
	catch(KeyNotFoundException e) {
	    numOccurrences = 0;
	}
	System.out.println("  " + target + " = " + numOccurrences);
    }

    
    /**
     *  Prints a message describing proper usage with respect to required
     *  command line parameters and exits.
     */
    private static void usage() {
	System.out.println("Usage: java CountWords infile (type)");
	System.out.println("  infile - name of input file containing text");
	System.out.println("  type (optional) - SimpleMap implementation to use:");
	System.out.println("    0 - LinkedListMap (default)");
	System.out.println("    1 - BSTMap");
	System.out.println("    2 - RBTMap");
	System.out.println("    3 - ChainingHashMap");
	System.out.println("    4 - MyRBTMap");
	System.exit(1);
    }


    /**
     *  A command line interface to the expression evaluator
     *  @param args command line parameters:
     *  <ul>
     *   <li> infile - name of input file containing text
     *   <li> type (optional) indicating which SimpleMap implementation to use:
     *   <ul>
     *     <li> 0 - LinkedListMap (default)
     *     <li> 1 - BSTMap
     *     <li> 2 - RBTMap
     *     <li> 3 - ChainingHashMap
     *     <li> 4 - MyRBTMap
     *   </ul>
     *  </ul>
     */
    public static void main(String[] args) {
	// gather command line arguments
	if (args.length != 1 && args.length != 2)  usage();
	
        int type = 0;
        if (args.length == 2)
	    type = parseInt(args[1]);

        // read each word from the text file and add it to a 
        // SimpleSortedMap
	SimpleMap<String,Integer> M;

        if (type == 0) {
	    M = new LinkedListMap<String,Integer>();
	    System.out.println("Using LinkedListMap to count words in " + args[0]);
	}
/*
        else if (type == 1) {
	    M = new BSTMap<String,Integer>();
	    System.out.println("Using BSTMap to count words in " + args[0]);
	}
*/
/*
	else if (type == 2) {
	    M = new RBTMap<String,Integer>();
	    System.out.println("Using RBTMap to count words in " + args[0]);
	}
*/
/*
	else if (type == 3) {
	    M = new ChainingHashMap<String,Integer>(100000);
	    System.out.println("Using ChainingHashMap to count words in " + args[0]);
	}
*/
/*
	else if (type == 4) {
	    M = new MyRBTMap<String,Integer>();
	    System.out.println("Using MyRBTMap to count words in " + args[0]);
	}
*/
	else {
	    M = new LinkedListMap<String,Integer>();
	    System.out.println("Using LinkedListMap to count words in " + args[0]);
	}
	
	// Use a try-catch block to handle any exceptions thrown by
	// reading from the input file
	try {
	    // Create a Scanner object to read from the file argv[1]
	    //  (in current folder), which will be used to read in lines
	    //  of the input file
	    File inputFile = new File(args[0]);
	    Scanner in = new Scanner(inputFile);

	    while (in.hasNextLine()) {
		String inline = in.nextLine();
		StringTokenizer line = new StringTokenizer(inline,".,?;:\\ !&(){}[]`-\"");

		while (line.hasMoreTokens()) {
		    String word = (line.nextToken()).toLowerCase();

		    try {
			Integer freq = M.search(word);
			M.modify(word,freq+1);
		    }
		    catch(KeyNotFoundException e) {
			M.insert(word,1);
		    }
		}
	    }
	}

	// Print a message to standard output if there was a problem
	// opening or processing the input file.
	catch(FileNotFoundException e) {
	    System.out.println(e);
	    System.exit(0);
	}

        // print the number of occurrences of some words
        System.out.println("\nNumber of occurrences of:");
	printOccurrences(M,"the");
	printOccurrences(M,"and");
	printOccurrences(M,"vampire");
	printOccurrences(M,"nosferatu");
	printOccurrences(M,"pearl");
	printOccurrences(M,"hazel");
	printOccurrences(M,"doozy");
	printOccurrences(M,"envious");
    }
}
