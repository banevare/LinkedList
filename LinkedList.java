
class LinkedList {
	public ListNode removeNthFromEnd(final ListNode head, int n) {
		int length = 0;
		ListNode p = head;											// wherever head points -> p points there too
		while(p != null){											// obtaining the length of the linked list 
			length++;
			p = p.next;
		}
		int parent = length - n;
		p = head;
		for(int i = 1; i < parent; i++) p = p.next;					// going to the previous node of the node we deleting

		p.next = p.next.next;

		return head;
	}
	public class ListNode {											// Definition for singly-linked list.
		final int val;
		ListNode next = null;
		ListNode(int val) { this.val = val; }
	}
	public ListNode makeList(){										// Making our singly-linked list
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		return a;
	}
	public void print (final ListNode head){						// printing method of our singly-linked list
		ListNode p = head;
		while(p != null){
			System.out.print(" " + p.val);
			p = p.next;
		}
		System.out.println();
	}
	public static void main(String[] args){							// main test for singly-linked list
		Solution s = new Solution();
		ListNode head = s.makeList();
		System.out.println( "-----------ORIGINAL LIST BELOW------------");
		s.print(head);
		s.removeNthFromEnd(head,3);
		System.out.println( "-----------REMOVED LIST BELOW------------");
		s.print(head);

	}
}