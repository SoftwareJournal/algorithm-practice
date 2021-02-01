/**
 * PROMPT: CHECK IF N AND ITS DOUBLE EXIST Given an array arr of integers, check
 * if there exists two integers N and M such that N is the double of M ( i.e. N
 * = 2 * M).
 * 
 * More formally check if there exists two indices i and j such that :
 * 
 * i != j 0 <= i, j < arr.length arr[i] == 2 * arr[j]
 * 
 * Example 1: Input: arr = [10,2,5,3] Output: true Explanation: N = 10 is the
 * double of M = 5,that is, 10 = 2 * 5.
 * 
 * Example 2: Input: arr = [7,1,14,11] Output: true Explanation: N = 14 is the
 * double of M = 7,that is, 14 = 2 * 7.
 * 
 * Example 3: Input: arr = [3,1,7,11] Output: false Explanation: In this case
 * does not exist N and M, such that N = 2 * M.
 * 
 * Constraints: 2 <= arr.length <= 500 -10^3 <= arr[i] <= 10^3
 * 
 * Hint #1: Loop from i = 0 to arr.length, maintaining in a hashTable the array
 * elements from [0, i - 1].
 * 
 * Hint #2: On each step of the loop check if we have seen the element 2 *
 * arr[i] so far or arr[i] / 2 was seen if arr[i] % 2 == 0.
 */

import java.util.HashSet;

class CheckIfNandDoubleExist {
    public boolean checkIfExist(int[] arr) {
        int k = arr.length;
        if (k < 2) {
            return false;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (arr[i] == 2 * arr[j] && i != j) {
                    return true;
                }
            }
        }
        return false;
    }
}

class OptimizeSolution8 {
    public boolean checkIfExist(int[] arr) {
        int k = arr.length;
        if (k < 2) {
            return false;
        }
        HashSet<Integer> arrDE = new HashSet<Integer>();

        for (int item : arr) {
            if (arrDE.contains(item * 2) || item % 2 == 0 && arrDE.contains(item / 2)) {
                return true;
            }
            arrDE.add(item);
        }
        return false;
    }
}