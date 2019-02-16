import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *                                      Average Running Times
 *                          | Insert | Quick | Merge Recursive | Merge Iterative | Selection |
 * 10 random                |        |       |                 |                 |           |
 * 100 random               |
 * 1000 random              |
 * 1000 few unique          | 
 * 1000 nearly ordered      |
 * 1000 reverse order       |
 * 1000 sorted              |
 *
 * 1. Which of the sorting algorithms does the order of input have an impact on? Why? 
 * 
 * 
 * 2. Which algorithm has the biggest difference between the best and worst performance, based
		on the type of input, for the input of size 1000? Why?
 *
 *
 * 3. Which algorithm has the best/worst scalability, i.e., the difference in performance time
        based on the input size? Please consider only input files with random order for this answer. 
 *
 *
 * 4. Did you observe any difference between iterative and recursive implementations of merge
		sort?
 *
 *
 * 5. Which algorithm is the fastest for each of the 7 input files? 
 * 
 * 
 * 
 *  @author Everlyn Poh
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testInsertionSort()
    {
    	
    	double a[] = {14.67,10.33,12.11,4.89,5.62,7.99} ;
    	String results = "4.89 5.62 7.99 10.33 12.11 14.67 " ;
    	
    	a = SortComparison.insertionSort(a) ;
    	assertEquals( "Checks insertion sort", results, SortComparison.toString(a) );

    }


    @Test
    public void testQuickSort()
    {
    	double a[] = {14.67,10.33,12.11,4.89,5.62,7.99} ;
    	String results = "4.89 5.62 7.99 10.33 12.11 14.67 " ;
    	
    	a = SortComparison.quickSort(a) ;
    	assertEquals( "Checks quick sort", results, SortComparison.toString(a) );
    }
    
    @Test
    public void testMergeSortRecursive()
    {
    	double a[] = {14.67,10.33,12.11,4.89,5.62,7.99} ;
    	String results = "4.89 5.62 7.99 10.33 12.11 14.67 " ;
    	
    	a = SortComparison.mergeSortRecursive(a) ;
    	assertEquals( "Checks quick sort", results, SortComparison.toString(a) );
    }
    
    @Test
    public void testMergeSortIterative()
    {
    	double a[] = {14.67,10.33,12.11,4.89,5.62,7.99} ;
    	String results = "4.89 5.62 7.99 10.33 12.11 14.67 " ;
    	
    	a = SortComparison.mergeSortIterative(a) ;
    	assertEquals( "Checks quick sort", results, SortComparison.toString(a) );
    }
    
    @Test
    public void testSelectionSort()
    {
    	double a[] = {14.67,10.33,12.11,4.89,5.62,7.99} ;
    	String results = "4.89 5.62 7.99 10.33 12.11 14.67 " ;
    	
    	a = SortComparison.selectionSort(a) ;
    	assertEquals( "Checks quick sort", results, SortComparison.toString(a) );
    }
    
    
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
    	 File file = new File("numbers10.txt"); 
    	  
    	 BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
    	  
    	 String st; 
    	 try {
			while ((st = br.readLine()) != null) 
			   System.out.println(st);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

