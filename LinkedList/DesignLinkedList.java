package LinkedList;

import java.util.ArrayList;
import java.util.List;

//First attempt, just need to revisit this implemenation
class MyLinkedList1 {
    int length;
    Node head;
    /** Initialize your data structure here. */
    public MyLinkedList1() {
        head = new Node(0);
        head.next = null;
        length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index > length){
            return -1;
        }
        
        Node cur = head;
        int run = 0;
        
        while(run<index){
            cur = cur.next;
            run++;
        }
        
        return cur.next.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node cur = head;
        while(cur.next!=null){
            cur=cur.next;
        }
        Node node = new Node(val);
        cur.next = node;
        length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length || index < 0 ){
            return;
        }
        
        if(index == 0){
            addAtHead(val);
            return;
        }
        
        if(index == length){
            addAtTail(val);
            return;
        }
        
        Node cur = head;
        int run = 0;
        while(run < index){
            cur = cur.next;
            run++;
        }
        
        Node node = new Node(val);
        Node prev = cur;
        Node next = cur.next;
        
        prev.next = node;
        node.next = next;
        length++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index > length){
            return;
        }
        
        Node cur = head;
        int run = 0;
        while(run < index){
            cur = cur.next;
            run++;
        }
        cur.next = cur.next.next;
        length--;
    }
}

//Singly LinkedList Node
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

 //Second attempt using dynamic list/array; accepted
 class MyLinkedList {
    List<Integer> node;
    /** Initialize your data structure here. */
    public MyLinkedList() {
       node = new ArrayList<>();
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= node.size()){
            return -1;
        }
        
        return node.get(index);        
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        node.add(0,val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        node.add(val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > node.size()){
            return;
        }
        node.add(index,val);
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < node.size()) {
            node.remove(index);
        }
    }
}