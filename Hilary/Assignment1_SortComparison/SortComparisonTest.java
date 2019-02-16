import static org.junit.Assert.assertEquals;

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
    public void testEmpty()
    {
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}

