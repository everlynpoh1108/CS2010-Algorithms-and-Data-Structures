import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;
    private int size ;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
      size = 0 ;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: ϴ(1)
     *
     * Justification:
     *  Line 89 is executed ϴ(1) times, and execution takes t = ϴ(1)
     */
    public boolean isEmpty()
    {
      return head==null ;
    }
    
    public int size ()
    {
    	return size ;
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: ϴ(N)
     *
     * Justification:
     *  Line 135-144 is executed ϴ(N) times, and execution takes t1 = ϴ(N)
     *  The rest of the lines are executed ϴ(1) times , and execution takes t2 = ϴ(1)
     *  Therefore total running time T(N) = ϴ(N) + ϴ(1)
     *                                    = ϴ(N)
     */
    public void insertBefore( int pos, T data ) 
    {
    	DLLNode newNode ;
    	int index = 0 ;

    	if (pos <= 0) //Insert data  at head(pos 0)
    	{ 
    		if (head == null)
    		{
    			newNode = new DLLNode (data,null,null) ;
    			head = newNode ;
    			tail = newNode ;
    		}
    		else 
    		{
    			newNode = new DLLNode (data,null,head) ;
    			head.prev = newNode ;
    			head = newNode ;
    		}
    	}
    	else if (pos < size && pos>0) //Insert in the middle 
    	{
    		DLLNode tmp = head ;
    		for (tmp = head ; tmp != null ; tmp = tmp.next)
    		{
    			if (index == pos)
    			{
    				newNode = new DLLNode (data,tmp.prev,tmp) ;
    				tmp.prev.next = newNode ;
    				tmp.prev = newNode ;
    			}
    			index++ ;
    		}
    	}
    	else if (pos >= size) //Insert at end of list
    	{
    		if (tail == null)
    		{
    			newNode = new DLLNode (data,null,null) ;
    			tail = newNode ;
    			head = newNode ;
    		}
    		else 
    		{
    			newNode = new DLLNode (data,tail,null) ;
    			tail.next = newNode ;
    			tail = newNode ;
    		}
    	 
    	}  
    	
	    size++ ;  
	 }
	    
    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: ϴ(N)
     *
	 * Justification:
	 *  Line 191-195 is executed ϴ(N) times, and execution takes t1 = ϴ(N)
     *  The rest of the lines are executed ϴ(1) times , and execution takes t2 = ϴ(1)
     *  Therefore total running time T(N) = ϴ(N) + ϴ(1)
     *                                    = ϴ(N)
	 *
	 */
	 public T get(int pos) 
	 {
		DLLNode current = head ;
		if (!isEmpty())
		{
			if (pos<size && pos>=0)
			{
				int j=0 ;
				while (j<pos) 
				{
					current = current.next ;
					j++ ;
				}
				return current.data ;
			}
			else
				return null ;
		}
		
		return null;
	  }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: ϴ(1)
     *
     * Justification:
     *  Lines 219-261 are executed ϴ(1) times, each execution takes t = ϴ(1)
     */
	 public boolean deleteAt(int pos) 
	    {
		  int counter = 0 ;
	      if (!isEmpty())
	      {
	    	  if ((pos>0 && size==1) || (pos>size-1))
	    	  {
	    		  return false ;
	    	  }
	    	  else if (pos == 0 && size == 1)
	    	  {
	    		  head = null ;
	    		  tail = null ;
	    		  size-- ;
	    		  return true ;
	    	  }
	    	  else if (pos>=0 && pos<size)
	    	  {
	    		  if (pos == 0 && head!=null) //delete at the head
	    		  {
	    			  head = head.next ;
	    		  }
	    		  else if (pos == size-1 && tail!=null) //delete at the tail
	    		  {
	    			  tail = tail.prev ;
	    			  tail.next = null ;
	    		  }
	    		  else //delete in the middle
	    		  {
	    			  DLLNode tmp ;
	    			  for (tmp = head ; tmp != null ; tmp = tmp.next)
	    			  {
	    				  if (counter == pos)
	    				  {
	    					 tmp.prev.next = tmp.next ;
	    					 tmp.next.prev = tmp.prev ;
	    				  }
	    				  counter++ ;
	    			  }
	    		  }
	    		  size-- ;
	    		  return true ;
	    	  }
	      }
	      return false ;
	    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: ϴ(N)
     *
     * Justification:
     *  Line 282-288 are executed ϴ(N) times, and execution takes t1 = ϴ(N)
     *  The rest of the lines are executed ϴ(1) times , and execution takes t2 = ϴ(1)
     *  Therefore total running time T(N) = ϴ(N) + ϴ(1)
     *                                    = ϴ(N)
     */
    public void reverse()
    {
      DLLNode tmp = null ;
      DLLNode current = head ;
      
      while (current != null)
      {
    	  tmp = current.prev ;
    	  current.prev = current.next ;
    	  current.next = tmp ;
    	  current = current.prev ;
      }
      
      if (tmp != null)
      {
    	  tail = head ;
    	  head = tmp.prev ;
      }
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: ϴ(N^2)                             
     *
     * Justification:
     *  There are two for loops in this method, therefore the number of times it was executed is ϴ(N^2). t1 = ϴ(N^2) .
     *  The rest of the lines were executed ϴ(1)times only. t2 = ϴ(1)
     *  The total running time = t1 + t2
     *                         = ϴ(N^2) + ϴ(1)
     *                         = ϴ(N^2)
     */
     public void makeUnique()
    {
    	DLLNode pointer1 ;
    	DLLNode pointer2 ;
    	DLLNode tmp ;
    	
    	for (pointer1 = head ; pointer1!=null ; pointer1= pointer1.next)
    	{
    		for (pointer2 = pointer1.next ; pointer2!=null ; pointer2 = pointer2.next )
    		{
    			if (pointer1.data == pointer2.data)
    			{
    				tmp = pointer2 ;
    				if (tmp == tail) //deleting at the tail
    				{
    					tail = tail.prev ;
    					tail.next = null ;
    				}
    				else
    				{
    					pointer2.prev.next = pointer2.next ;
    					if (pointer2.next != null)
    					{
    						pointer2.next.prev = pointer2.prev ;
    						tmp = null ;
    					}
    				}
    			}
    		}
    	}
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: ϴ(1)
     *
     * Justification:
     *  Lines 362-373 were executed ϴ(1)times only. Total running time = ϴ(1)
     */
    public void push(T item) 
    {
      DLLNode node = new DLLNode (item,null,head) ;
      if (isEmpty())
      {
    	  head = node ;
    	  tail = node ;
      }
      else 
      {
    	  head.prev = node ;
    	  head = node ;
      }
      size++ ;
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: ϴ(1)
     *
     * Justification:
     *  Lines 387-406 were executed ϴ(1)times only. Total running time = ϴ(1)
     */
    public T pop() 
    {
      T val ;
      if (isEmpty())
      {
    	  val = null ;
      }
      else
      {
    	  val = head.data ;
    	  if (head != null && head.next != null)
    	  {
    		  head = head.next ;
    		  head.prev = null ;
    	  }
    	  else if (size == 1)
    	  {
    		  head = null ;
    	  }
    	  size-- ;
      }
      return val;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: ϴ(1)
     *
     * Justification:
     *  Lines 425-436 were executed ϴ(1)times only. Total running time = ϴ(1)
     */
    public void enqueue(T item) 
    {
      DLLNode node = new DLLNode (item, tail,null) ;
      if (isEmpty())
      {
    	  head = node ;
    	  tail = node ;
      }
      else
      {
    	  tail.next = node ;
    	  tail = node ;
      }
      size++ ;
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: ϴ(1)
     *
     * Justification:
     *  Lines 450-469 were executed ϴ(1)times only. Total running time = ϴ(1)
     */
    public T dequeue() 
    {
      T val  ;
      if (isEmpty())
      {
    	  val = null ;
      }
      else
      {
    	val = head.data ;
    	if (size == 1)
    	{
    		head = null ;
    		tail = null ;
    	}
    	else
    	{
    		head = head.next ;
    	}
    	size-- ;
      }
      return val ;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}



