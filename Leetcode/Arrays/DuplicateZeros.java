package Arrays;

/**
 * PROMPT: 
 * DUPLICATE ZEROS 
 * Given a fixed length array arr of integers, duplicate each
 * occurrence of zero, shifting the remaining elements to the right.
 * 
 * Note that elements beyond the length of the original array are not written.
 * 
 * Do the above modifications to the input array in place, do not return
 * anything from your function.
 * 
 * Example 1: 
 * Input: [1,0,2,3,0,4,5,0] 
 * Output: null Explanation: After calling our function, the input array
 * is modified to: [1,0,0,2,3,0,0,4]
 * 
 * Example 2: 
 * Input: [1,2,3] 
 * Output: null Explanation: After calling your function, the input array
 * is modified to: [1,2,3]
 * 
 * Constraints: 
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * 
 * Hint #1: This is a great introductory problem for understanding and working
 * with the concept of in-place operations. The problem statement clearly states
 * that we are to modify the array in-place. That does not mean we cannot use
 * another array. We just don't have to return anything.
 * 
 * Hint #2: A better way to solve this would be without using additional space.
 * The only reason the problem statement allows you to make modifications in
 * place is that it hints at avoiding any additional memory.
 * 
 * Hint #3: The main problem with not using additional memory is that we might
 * override elements due to the zero duplication requirement of the problem
 * statement. How do we get around that?
 * 
 * Hint #4: If we had enough space available, we would be able to accommodate
 * all the elements properly. The new length would be the original length of the
 * array plus the number of zeros. Can we use this information somehow to solve
 * the problem?
 */

import java.util.HashMap;

class Solution4 {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0 && i != len - 1) {
                for (int j = len - 1; j > i; j--) {
                    if (j < len - 1)
                        arr[j + 1] = arr[j];
                }
                arr[i + 1] = 0;
            }
        }
    }
}

class ChallengeAccepted{
    public void duplicateZeros(int[] arr) {
        int index = 0;
        HashMap<Integer,Integer> newArr = new HashMap<>();
        for(int item: arr){
            if(item==0){
                newArr.put(index, item);
                newArr.put(index+1, item);
                index = index+2;
            }else{
                newArr.put(index, item);
                index++;    
            }
        }
    
        for(int i = 0; i<arr.length;i++){
            arr[i] = newArr.get(i);
        }
    }
}