package Recursion;
/**
 * PROMPT:
 * SWAP NODES IN PAIRS
 * 
 * Given a linked list, swap every two adjacent
 * nodes and return its head.
 * 
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * 
 * Example 2:
 * Input: head = []
 * Output: []
 * 
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 * 
 * Constraints:
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 * 
 * Follow up:
 * Can you solve the problem without modifying the
 * values in the list's nodes? (i.e., Only nodes themselves
 * may be changed.)
 * 
 */


  
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        swap(head);
        return head;
    }
    
    public void swap(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        int tempVal = head.val;
        head.val = head.next.val;
        head.next.val = tempVal;
        
        swap(head.next.next);
    }
}

class FollowUp {
    public ListNode swapPairs(ListNode head) {
        ListNode node = swap(head);
        return node;
    }
    
    public ListNode swap(ListNode head){
        if(head == null){
            return null;   
        }
        //base case
        if(head.next == null){
            return head;
        }
        
        ListNode node = head.next;
        head.next = swap(head.next.next);
        node.next = head;
        return node;
    }
}