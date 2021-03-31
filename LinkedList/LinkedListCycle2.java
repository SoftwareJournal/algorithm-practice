package LinkedList;

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
