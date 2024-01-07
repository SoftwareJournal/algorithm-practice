package LinkedList;

/**
 * Given a linked list, return the node where the 
 * cycle begins. If there is no cycle, return null.
 * 
 * There is a cycle in a linked list if there is 
 * some node in the list that can be reached again
 * by continuously following the next pointer. 
 * Internally, pos is used to denote the index of 
 * the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * 
 * Notice that you should not modify the linked list.
 */
import java.util.HashSet;

class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        return findNode(head);
     }
     
     private ListNode findNode (ListNode head){
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur!=null){ 
            if(set.contains(cur)){
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        
        return null;
     }
}
