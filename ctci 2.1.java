// Remove duplicates from a LinkedList

public class LinkedListLib {
	
	// O (n) time complexity, O(n) space complexity
	public static void removeDuplicates (LinkedListNode head) {
		Set<Integer> s = new HashSet<Integer> ();
		
		LinkedListNode prev = head;
		LinkedListNode curr = head.next;
		s.add (head.data);
	
		while (curr != null) {
			// delete
if (s.contains(curr.data)) {
				prev.next = curr.next;
			}
			else {
				s.add(curr.data);
			}
			
			prev = prev.next;
			curr = curr.next;
		}
	}

}
