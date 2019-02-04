
public class ListEquals {
	static class LNode {
		public int data ;
		public LNode next ;
		public LNode (int d , LNode nxt) {
			data = d ;
			next = nxt ;
		}
	}
	
	/*
	 * (b) Worst case asymptotic running time : Theta(N^2) . 
	 * There are two while loops in this method, therefore the number of times it was executed is Theta(N^2). t1 = Theta(N^2) .
     *  The rest of the lines were executed Theta(1)times only. t2 = Theta(1)
     *  The total running time = t1 + t2
     *                         = Theta(N^2) + Theta(1)
     *                         = Theta(N^2)
	 *                                          
	 * (c) O(N^2) . This shows the upper bounds of the running time. 
	 * 
	 */
	public static boolean listEquals (LNode head1, LNode head2) {
		LNode tmpHead1 = head1 ;
		LNode tmpHead2 = head2 ;
		
		while (tmpHead1 != null)
		{
			while(tmpHead2 != null)
			{
				if (tmpHead1.data == tmpHead2.data)
				{
					tmpHead1 = tmpHead1.next ;
					tmpHead2 = tmpHead2.next ;
				}
				else
					return false ;
			}
			
			if (tmpHead1 != null && tmpHead2 == null)
				return false ;
		}
		
		if (tmpHead1 == null && tmpHead2 != null)
		{
			return false ;
		}
		
		return true;
		
	}
	
	public static void main (String[]args) {
		LNode list1 = new LNode (0, new LNode(1, new LNode(2, null))) ;
		LNode list2 = new LNode (0, new LNode(1, new LNode(2, null))) ;
		LNode list3 = new LNode (0, new LNode(88, new LNode(2, null))) ;
		LNode list4 = new LNode (0, new LNode(1,null)) ;
		
		System.out.println ("should be true: " + listEquals (list1, list2)) ;
		System.out.println ("should be false: " + listEquals (list1, list3)) ;
		System.out.println ("should be false: " + listEquals (list1, list4)) ;
		System.out.println ("should be false: " + listEquals (list1, null)) ;
		
	}
}
