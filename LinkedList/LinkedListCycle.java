package LinkedList;

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
