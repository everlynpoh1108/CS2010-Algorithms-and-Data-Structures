import static org.junit.Assert.assertEquals;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *                                      Average Running Times in milliseconds
 *                          | Insert | Quick | Merge Recursive | Merge Iterative | Selection |
 * 10 random                |   25   | 27.66 |      25.33      |                 |   25.33   |
 * 100 random               |  32.33 |  32   |       30        |                 |    31     |
 * 1000 random              |   61   |  59   |      58.33      |                 |    67     |
 * 1000 few unique          |  54.67 | 51.67 |       48        |                 |   57.67   |
 * 1000 nearly ordered      |  59.67 | 56.67 |      55.67      |                 |   67.67   |
 * 1000 reverse order       |  71.67 | 67.67 |      59.33      |                 |   64.67   |
 * 1000 sorted              |   56   | 65.33 |       58        |                 |   67.67   |
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
    	int index = 0 ;
    	int size = 100 ;
    	double a[] = new double[size] ;
    	File file = new File("numbers100.txt");
    	//System.out.println(System.getProperty("user.dir"));
    	Scanner sc ;
    	try {
			sc = new Scanner(file) ;
			while((sc.hasNextDouble()))
			{
				a[index] = sc.nextDouble() ;
				index++ ;
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	a = SortComparison.selectionSort(a) ;
    	//System.out.println(SortComparison.toString(a));
		
    	
    	 
    	
			
			
		
		
			
    }

}

