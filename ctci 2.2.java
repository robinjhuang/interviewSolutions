Find kth to last element

public class LinkedListLib {
	public static int findKthToLast (int k, LinkedListNode head) {
		LinkedListNode behind = head;
		LinkedListNode front = head;

		for (int i = 0; i < k; ++i) {
			if (front == null) return -1;
			else front = front.next;
		}
		
		while (front != null) {
			front = front.next;
			behind = behind.next;
		}

		return behind.data;
	}

}