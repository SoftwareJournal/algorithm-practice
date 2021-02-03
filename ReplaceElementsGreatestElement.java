/**
 * PROMPT:
 * REPLACE ELEMENTS WITH GREATEST ELEMENT ON RIGHT SIDE
 * Given an array arr, replace every element in that array
 * with the greatest element among the elements to its right,
 * and replace the last element with -1.
 * 
 * After doing so, return the array.
 * 
 * Example 1:
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation: 
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 * 
 * Example 2:
 * Input: arr = [400]
 * Output: [-1]
 * Explanation: There are no elements to the right of index 0.
 * 
 * Constraints:
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 * 
 * Hint #1:
 * Loop through the array starting from the end.
 * 
 * Hint #2:
 * Keep the maximum value seen so far.
 */
class ReplaceElementsGreatestElement {
    public int[] replaceElements(int[] arr) {
        int k = arr.length;
        int curHR = 0;
        for (int i = k - 1; i >= 0; i--) {
            int tempHR = curHR;
            if (i == k - 1) {
                curHR = arr[i];
                arr[i] = -1;
            } else if (arr[i] > curHR) {
                tempHR = arr[i];
                arr[i] = curHR;
                curHR = tempHR;
            } else if (arr[i] < curHR) {
                arr[i] = curHR;
            }
        }
        return arr;
    }
}

class OptimizeSolution9 {
    public int[] replaceElements(int[] arr) {
        int k = arr.length;
        int curHR = -1;
        for (int i = k - 1; i >= 0; i--) {
            if (arr[i] > curHR) {
                int temp = arr[i];
                arr[i] = curHR;
                curHR = temp;
            } else if (arr[i] < curHR) {
                arr[i] = curHR;
            }
        }
        return arr;
    }
}
