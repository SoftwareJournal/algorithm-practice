package Queue;
/**
 * Need to solve for this test case:
 * ["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","deQueue","deQueue","isEmpty","isEmpty","Rear","Rear","deQueue"]
[[8],[3],[9],[5],[0],[],[],[],[],[],[],[]]

Output: [null,true,true,true,true,true,true,false,false,0,0,false]
Expected: [null,true,true,true,true,true,true,false,false,0,0,true]
 */
class MyCircularQueue {
    int[] queue;
    int p_start;
    int p_end;
    int len;
    /*initilize the circular queue*/
    public MyCircularQueue(int k) {
        queue = new int[k];
        p_start = -1;
        p_end = -1;
        len = k;
    }
    //add at the end of the queue
    public boolean enQueue(int value) {
        
        if(isEmpty()){
            p_start = 0;
            p_end = 0;
            queue[p_end] = value;
            return true;
        }
        //before the end of the array max index
        else if(!isFull() && p_end+1 <= len-1){
            p_end++;
            queue[p_end] = value;
            return true;
        }
        //pass the end of the array max index
        else if(!isFull() && p_end+1 > len-1){
            p_end = 0;
            queue[p_end] = value;
            return true;    
        }
        
        return false;
    }
    
    //take out the first element
    public boolean deQueue() {
        if(isEmpty()){
            p_end = -1;
            p_start = -1;
            return false;
        }
        if(p_start == 0 && p_end == 0){
            p_end = -1;
            p_start = -1;        
            return true;
        }
        //before the end of the array max index
        else if(!isEmpty() && p_start+1 < p_end){
            p_start++;
            return true;
        }
        // pass the end of the array max index
        else if(!isEmpty() && p_start+1 > len-1){
            p_start = 0;
            return true;
        }
        
        return false;
    }
    
    //get the front of the queue;
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return queue[p_start];
    }
    //get the rear of the queue;
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return queue[p_end];
    }
    
    //is the queue empty
    public boolean isEmpty() {
        if(p_start == -1 || p_end == -1){
            return true;
        }
        return false;
    }
    //is the queue full
    public boolean isFull() {
        // if p_end after p_start
        int end_pos = p_end+1;
        if(end_pos - p_start > len-1 && p_start <= end_pos){
            return true;
        }
        // if p_end before p_start
        else if((len - 1 - p_start) + end_pos > len && end_pos <= p_start){
            return true;
        }
        
        return false;
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
