class LinkedList {
		public ListNode removeNthFromEnd( ListNode head, int n) {
		if (head == null) return head;
		int length = 0;
		ListNode p = head;									// wherever head points -> p points there too
		while(p != null){									// obtaining the length of the linked list 
			length++;
			p = p.next;
		}
		int parent = length - n;						
		p = head;
		for(int i = 1; i < parent; i++) p = p.next;						// going to the previous node of the node we deleting
		if(parent == 0) return head.next;
		if(length < n ) return head;
		if(p != null && p.next != null) p.next = p.next.next;
		return head;
	}

	public class ListNode {										// Definition for singly-linked list.
		final int val;
		ListNode next = null;
		ListNode(int val) { this.val = val; }
	}

	// ----------- TESTING ------------
	public ListNode makeList0(){									// ListNode = [] n = 1
		return null;
	}
	public ListNode makeList6(){									// ListNode = [1 2 3 4 5 6] 
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
	public String print(final ListNode head){							// printing method of our singly-linked list
		String s = null;
		ListNode p = head;
		while(p != null){
			if( s == null) s = "" + p.val; else s += " " + p.val;
			p = p.next;
		}
		return s == null ? "" : s;
	}
	public static void test0(int n, String ta){							// empty ListNode test
		LinkedList s = new LinkedList();
		ListNode head = s.makeList0();
		String tb = "";
		String rb = s.print(head);
		assert(tb.equals(rb));

		ListNode r = s.removeNthFromEnd(head,n);
		String ra = s.print(r);
		assert(ta.equals(ra));
	}
	public static void test6(int n, String ta){							// 6 element ListNode test
		LinkedList s = new LinkedList();;
		ListNode head = s.makeList6();
		String tb = "1 2 3 4 5 6";
		String rb = s.print(head);
		assert(tb.equals(rb));

		ListNode r = s.removeNthFromEnd(head,n);
		String ra = s.print(r);
		assert(ta.equals(ra));
	}
	public static void main(String[] args){								// main test for singly-linked list
		test0(0,"");
		test0(1,"");

		test6(0, "1 2 3 4 5 6");
		test6(1, "1 2 3 4 5");
		test6(2, "1 2 3 4 6");
		test6(3, "1 2 3 5 6");
		test6(4, "1 2 4 5 6");
		test6(5, "1 3 4 5 6");
		test6(6, "2 3 4 5 6");
		test6(7, "1 2 3 4 5 6");

	}
}
