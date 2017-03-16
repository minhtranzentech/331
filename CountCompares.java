import static java.lang.Math.log;
import java.util.Random;
import static java.lang.Integer.parseInt;
import java.lang.IllegalArgumentException;

/**
 * The CountCompares main program computes the average number of comparisions required
 * by various implementations of the search methods for a SimpleMap.
 *
 * @author  Mike Jacobson
 * @version 1.0
 */
public class CountCompares {
    public static final int MAX_ARRAY_SIZE=100000;

    /**
     * Generates an array containing n random integers.
     *
     * @return array containing n distinct random integers
     * @param  n desired size of A
     * @throws IllegalArgumentException if n &lt; 0 or n &gt; {@value #MAX_ARRAY_SIZE}
     */

    public static Integer [] randomArray(int n)
    {
        // Enforce preconditions
	if (n <= 0)
	    throw new IllegalArgumentException("Negative array size: " + n);

	if (n > MAX_ARRAY_SIZE)
	    throw new IllegalArgumentException("Array size = " + n + " bigger than MAX_ARRAY_SIZE = " + MAX_ARRAY_SIZE);

	// create A
	Integer [] A = new Integer[n];


	// fill A with random integers
	Random R = new Random();
	for (int i=0; i<n; ++i)
	    {
		A[i] = R.nextInt();
                // make sure all elements are distinct
                int j=0;
                while (j < i) {
		    if (A[j].equals(A[i])) {
			A[i] = R.nextInt();
			j = 0;
		    }
		    else
			++j;
                }
	    }

	return A;
    }



    /**
     *  Prints a message describing proper usage with respect to required
     *  command line parameters and exits.
     */
    private static void usage()
    {  
	System.out.println("Usage: java CountCompares numKeys numMaps sorted");
	System.out.println("  numKeys - number of keys to insert in each SimpleMap");
	System.out.println("  numMaps - number of SimpleMaps using each data structure to create, with numKeys keys in each");
	System.out.println("  sorted - 1 if keys should be inserted in increasing order");
	System.exit(1);
    }


    /**
     *  Computes the average number of comparisons required by various
     *  implementations of search in a SimpleMap.
     *
     *  @param args command line parameters of type <code>int</code>:
     *  <ul>
     *   <li> numKeys (number of keys to insert in each SimpleMap)
     *   <li> numMaps (number of SimpleMaps to create using each data structure, with numKeys keys in each")
     *   <li> sorted (1 if keys should be inserted in increasing order)
     *  </ul>
     */
    public static void main(String[] args)
    {
	if (args.length != 3)  usage();

	// gather command line arguments
	int numKeys = parseInt(args[0]);
	int numMaps = parseInt(args[1]);
	int sorted = parseInt(args[2]);

	System.out.println("Inserting " + numKeys + " keys into each SimpleMap");
	System.out.println("Creating " + numMaps + " SimpleMap instances for each data structure");
	if (sorted == 1)
	    System.out.println("Keys are inserted in increasing order\n");
	else
	    System.out.println("Keys are inserted in random order)\n");


	// create num_arrays random arrays and compute the 
        // subsequence sum using three different methods for each

	int numSearch_L = 0;
	int numCompares_L = 0;
	int numSearch_BST = 0;
	int numCompares_BST = 0;
	int numSearch_RBT = 0;
	int numCompares_RBT = 0;
	int numSearch_MyRBT = 0;
	int numCompares_MyRBT = 0;
	int numSearch_HT1000 = 0;
	int numCompares_HT1000 = 0;
	int numSearch_HT100000 = 0;
	int numCompares_HT100000 = 0;

	for (int i=0; i<numMaps; ++i)
	    {
		// create an array of random integers between
                // -max_int and max_int
		Integer [] A = null;
		Integer [] B = null;
		try 
		    {
			A = randomArray(numKeys);
			B = randomArray(100);
		    }
		catch (IllegalArgumentException e)
		    {
			System.out.println(e);
			usage();
		    }


		// create and test dictionary using BSTMap
		LinkedListMap<Integer,Integer> L = new LinkedListMap<Integer,Integer>();
		//BSTMap<Integer,Integer> BST = new BSTMap<Integer,Integer>();
		//RBTMap<Integer,Integer> RBT = new RBTMap<Integer,Integer>();
		//MyRBTMap<Integer,Integer> MyRBT = new MyRBTMap<Integer,Integer>();
		//ChainingHashMap<Integer,Integer> HT1000 = new ChainingHashMap<Integer,Integer>(1000);
		//ChainingHashMap<Integer,Integer> HT100000 = new ChainingHashMap<Integer,Integer>(100000);

		// sort the array of keys to insert if the sorted flag is set
		if (sorted == 1)
		    java.util.Arrays.sort(A);
		
		for (int j=0; j<numKeys; ++j) {
		    try {
		      L.insert(A[j],A[j]);
		    }
		    catch (KeyFoundException e) {
		      // do nothing!
		    } 

/*
		    try {
		      BST.insert(A[j],A[j]);
		    }
		    catch (KeyFoundException e) {
		      // do nothing!
		    } 
*/

/*
		    try {
		      RBT.insert(A[j],A[j]);
		    }
		    catch (KeyFoundException e) {
		      // do nothing!
		    } 
*/

/*
		    try {
		      MyRBT.insert(A[j],A[j]);
		    }
		    catch (KeyFoundException e) {
		      // do nothing!
		    } 
*/

/*
		    try {
		      HT1000.insert(A[j],A[j]);
		    }
		    catch (KeyFoundException e) {
		      // do nothing!
		    } 
*/

/*
		    try {
		      HT100000.insert(A[j],A[j]);
		    }
		    catch (KeyFoundException e) {
		      // do nothing!
		    } 
*/
		}


		for (int j=0; j<100; ++j) {
		    try {
		      L.search(B[j]);
		    }
		    catch (KeyNotFoundException e) {
		      // do nothing!
		    } 

/*
		    try {
		      BST.search(B[j]);
		    }
		    catch (KeyNotFoundException e) {
		      // do nothing!
		    } 
*/

/*
		    try {
		      RBT.search(B[j]);
		    }
		    catch (KeyNotFoundException e) {
		      // do nothing!
		    } 
*/

/*
		    try {
		      MyRBT.search(B[j]);
		    }
		    catch (KeyNotFoundException e) {
		      // do nothing!
		    } 
*/

/*
		    try {
		      HT1000.search(B[j]);
		    }
		    catch (KeyNotFoundException e) {
		      // do nothing!
		    } 
*/

/*
		    try {
		      HT100000.search(B[j]);
		    }
		    catch (KeyNotFoundException e) {
		      // do nothing!
		    } 
*/
		}

		numSearch_L += L.getNumSearch();
		numCompares_L += L.getNumCompare();

/*
		numSearch_BST += BST.getNumSearch();
		numCompares_BST += BST.getNumCompare();
*/

/*
		numSearch_RBT += RBT.getNumSearch();
		numCompares_RBT += RBT.getNumCompare();
*/

/*
		numSearch_MyRBT += MyRBT.getNumSearch();
		numCompares_MyRBT += MyRBT.getNumCompare();
*/

/*
		numSearch_HT1000 += HT1000.getNumSearch();
		numCompares_HT1000 += HT1000.getNumCompare();
*/

/*
		numSearch_HT100000 += HT100000.getNumSearch();
		numCompares_HT100000 += HT100000.getNumCompare();
*/
	    }

	System.out.println("Avg comparisons (LinkedListMap)         = " + (double) numCompares_L / (double) numSearch_L);
//	System.out.println("Avg comparisons (BSTMap)                = " + (double) numCompares_BST / (double) numSearch_BST);
//	System.out.println("Upper bound on comparisons (RBTMap)     = " + (double) numCompares_RBT / (double) numSearch_RBT);
//	System.out.println("Avg comparisons (MyRBTMap)              = " + (double) numCompares_MyRBT / (double) numSearch_MyRBT);
//	System.out.println("Avg comparisons (ChainingHashMap1000)   = " + (double) numCompares_HT1000 / (double) numSearch_HT100000);
//	System.out.println("Avg comparisons (ChainingHashMap100000) = " + (double) numCompares_HT100000 / (double) numSearch_HT100000);
    }
}
