import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  Everlyn Poh Yee Wen 17308703
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        System.out.println(testDLL.toString());
        testDLL.insertBefore(0,4);
        System.out.println(testDLL.toString());

        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testDeleteAt()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(1);
    	testDLL.push(2);
    	testDLL.push(3);
    	testDLL.push(4);
    	assertEquals("Checking deleteAt(1) after adding 4 elements", true, testDLL.deleteAt(1)) ;
    	assertEquals("Checking deleteAt(1) to a list containing 3 elements","4,2,1",testDLL.toString()) ;
    	assertEquals("Checking deleteAt(2) ", true, testDLL.deleteAt(2)) ;
    	assertEquals("Checking deleteAt(2) to a list containing 2 elements","4,2",testDLL.toString()) ;
    	assertEquals("Checking deleteAt(0) ", true, testDLL.deleteAt(0)) ;
    	assertEquals("Checking deleteAt(0) to a list containing 1 element","2",testDLL.toString()) ;
    }
    
    @Test
    public void testGet()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(1);
    	testDLL.push(2);
    	testDLL.push(3);
    	testDLL.push(4);
    	assertEquals("Checking get after adding 4 elements at position 0","4",testDLL.get(0).toString()) ;
    }
    
    @Test
    public void testReverse()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertBefore(0,1);
    	testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.reverse(); ;
        assertEquals( "Checking reverse to a list containing 3 elements at position 2", "3,2,1", testDLL.toString() );
    }
    
    @Test
    public void testMakeUnique()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(1);
    	testDLL.push(1);
    	testDLL.push(1);
    	testDLL.push(1);
    	testDLL.push(2);
    	testDLL.push(2);
    	testDLL.push(2);
    	System.out.println(testDLL.toString()) ;
        testDLL.makeUnique(); 
        System.out.println(testDLL.toString()) ;
        assertEquals( "Checking makeUnique to a list containing 3 elements at position 2", "2,1", testDLL.toString() );
    }
    
    @Test
    public void testPush()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(1);
    	testDLL.push(2);
    	testDLL.push(3);
    	testDLL.push(4);
    	assertEquals("Checking push to a list containing 4 elements","4,3,2,1",testDLL.toString()) ;
    }
    
    @Test
    public  void testPop()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(1);
    	testDLL.push(2);
    	testDLL.push(3);
    	testDLL.push(4);
    	assertEquals("Checking push to a list containing 4 elements","4,3,2,1",testDLL.toString()) ;
    	
    	assertEquals("Checking popped value","4",testDLL.pop().toString()) ;
    	assertEquals("Checking popped value","3",testDLL.pop().toString()) ;
    	assertEquals("Checking pop to a list containing 2 elements","2,1",testDLL.toString()) ;
    }
    
    
    @Test
    public void testEnqueue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(1);
    	testDLL.enqueue(2);
    	testDLL.enqueue(3);
    	testDLL.enqueue(4);
    	assertEquals("Checking enqueue to a list containing 4 elements","1,2,3,4",testDLL.toString()) ;
    }
    
    @Test
    public void testDequeue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(1);
    	testDLL.enqueue(2);
    	testDLL.enqueue(3);
    	testDLL.enqueue(4);
    	assertEquals("Checking enqueue to a list containing 4 elements","1,2,3,4",testDLL.toString()) ;
    	
    	assertEquals("Checking popped value","1",testDLL.dequeue().toString()) ;
    	assertEquals("Checking popped value","2",testDLL.dequeue().toString()) ;
    	assertEquals("Checking pop to a list containing 2 elements","3,4",testDLL.toString()) ;
    }
}

