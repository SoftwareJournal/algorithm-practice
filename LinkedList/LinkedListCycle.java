package LinkedList;

/**
 * PROMPT:
 * LINKED LIST CYCLE
 * 
 * Given head, the head of a linked list,
 * determine if the linked list has a cycle
 * in it.
 * 
 * There is a cycle in a linked list if there
 * is some node in the list that can be reached
 * again by continuously following the next 
 * pointer. Internally, pos is used to denote 
 * the index of the node that tail's next pointer 
 * is connected to. Note that pos is not passed as
 * a parameter.
 * 
 * Return true if there is a cycle in the linked 
 * list. Otherwise, return false.
 */

// Time complexity O(n); Space Complexity O(n)
import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
 
class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        return cycle(head);
    }
    
    private boolean cycle(ListNode head){
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(!set.contains(cur) && cur!=null){
            set.add(cur);
            cur = cur.next;
        }
        
        if(cur == null){
            return false;
        }
        
        return true;
    }
}
