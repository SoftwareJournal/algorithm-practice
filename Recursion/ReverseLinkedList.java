/**
 * PROMPT:
 * REVERSE LINKED LIST
 * 
 * Given the head of a singly linked list, reverse
 * list, and return the reversed list.
 * 
 * Do not allocate extra space for another array, 
 * you must do this by modifying the input array 
 * in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of
 * printable ascii characters.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * 
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 * 
 * Example 3:
 * Input: head = []
 * Output: []
 * 
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * 
 * Follow up: A linked list can be reversed either iteratively
 * or recursively. Could you implement both?
 */

 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode reverseList(ListNode head) {
        head = reverse2(head);
        return head;
    }
    
    //iteratively
    private void reverse1(ListNode head){
        int index=0;
        HashMap<Integer,Integer> holdvals = new HashMap<Integer,Integer>();
        ListNode current = head;
        
        while(current != null){
            holdvals.put(index++,current.val);
            current = current.next;
        }
        index = index-1;
        while(head != null){
            head.val = holdvals.get(index--);
            head = head.next;
        }
    }
    
    //recursively
    private ListNode reverse2(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        
        ListNode node = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}