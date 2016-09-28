// Partition a linked list around one value such that all values less than it come before all values that are larger than it

public class LinkedListLib {

	public static void partition (int k, LinkedListNode head) {
		LinkedListNode curr = head;
LinkedListNode lessThan = null;
LinkedListNode moreThan = null;
LinkedListNode w;
		while (curr != null) {
			if (curr.data >= k) {
				if (moreThan == null) moreThan = curr;
				else {	
					// insert at beginning
					curr.next = moreThan;
					moreThan = curr;			
		
}
			}
			
			else {
				f (lessThan == null) lessThan = curr;
				else {	
					// insert at beginning
					curr.next = lessThan;
					lessThan = curr;			
}
			}
curr = curr.next;
		}
		LinkedListNode temp = lessThan;
		while (temp.next != null) temp = temp.next;
		temp.next = moreThan;
		
	}
}