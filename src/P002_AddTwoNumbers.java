//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//
//Subscribe to see which companies asked this question


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
public class P002_AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode node = null,temp = null;
	        int a = 0, b = 0, cin = 0;
	        while(!(l1 == null && l2 == null && cin == 0)) {
	        	if(l1 == null) {
	        		a = 0;
	        	} else {
	        		a = l1.val;
	        		l1 = l1.next;
	        	}
	        	if(l2 == null) {
	        		b = 0;
	        	} else {
	        		b = l2.val;
	        		l2 = l2.next;
	        	}
	        	if(node == null) {
	        		node = new ListNode((a+b+cin)%10);
	        		temp = node;
	        	} else {
	        		temp.next = new ListNode((a+b+cin)%10);
	        		temp = temp.next;	  
	        	}
	        	cin = (a+b+cin)/10;
	        }
	        return node;
    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode node = addTwoNumbers(l1,l2);
		while(node != null) {
			System.out.println(node.val + "->");
			node = node.next;
		}
	}
	 
}

