package Queue;
/**
 * 54 / 54 test cases passed.
 */
class MyCircularQueue {
    
    private int[] queue;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        head = -1; //initialize to -1 to see if queue is empty
        tail = -1; //initialize to -1 to see if queue is empty
        size = k; //the size of the queue
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull() == true){
            return false;
        }
        
        if(isEmpty() == true){
            head = 0;
            tail = 0;
            queue[tail] = value;
            return true;
        }

        //check if head less than or equal to tail at the start of queue
        //and tail is less than or equal to the end of the queue 
        if(head<=tail && tail+1 <= size-1){
            tail = tail+1;
            queue[tail] = value;
            return true;
        }
        //check if the tail is greater than head but at the end of the queue
        else if(head <= tail && tail+1 > size-1){
            //check if the head is still at the beginning
            if(head == 0){
                return false;
            }
            //if not place tail at the beginning of the queue and add value
            else{
                tail = 0;
                queue[tail] = value;
                return true;        
            }
        }
        //check if the tail is less than tail 
        //but check if it is full when another value is added to the queue
        else if(tail < head && isFull() == false){
            tail = tail+1;
            queue[tail] = value;
            return true;
        }
        //otherwise value wasn't added successfully to the queue
        else{
            return false;
        }
        
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty() == true){
            return false;
        }
        
        if(tail == head){
            head = -1;
            tail = -1;
            return true;
        }
        //check when head incremented is less than or equal to tail
        if(head+1 <= tail){
            head = head+1;
            return true;
        }
        //check if head is head greater than tail and if head increment is 
        //greater than queue max index
        else if(tail<head && head+1 > size-1){
            head = 0;
            return true;    
        }
        //else increment head otherwise
        else{
            head = head+1;
            return true;    
        }
        
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty() == true){
            return -1;
        }
        
        return queue[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty() == true){
            return -1;
        }
        
        return queue[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        //check when tail increment isn't greater than queue max index
        //if true, check if head isn't at the beginning of the queue
        //if false, check if tail increment is equal to head index position 
        return (tail+1 > size-1) ? head == 0 : tail+1 == head;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */