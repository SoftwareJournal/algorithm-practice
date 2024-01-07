package Arrays;

/**
 * PROMPT:
 * VALID MOUNTAIN ARRAY
 * Given an array of integers arr, return true if and
 * only if it is a valid mountain array.
 * 
 * Recall that arr is a mountain array if and only if:
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 
 * Example 1:
 * Input: arr = [2,1]
 * Output: false
 * 
 * Example 2:
 * Input: arr = [3,5,5]
 * Output: false
 * 
 * Example 3:
 * Input: arr = [0,3,2,1]
 * Output: true
 * 
 * Constraints:
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^4
 * 
 * Hint #1:
 * It's very easy to keep track of a monotonically increasing
 * or decreasing ordering of elements. You just need to be able
 * to determine the start of the valley in the mountain and from
 * that point onwards, it should be a valley i.e. no mini-hills 
 * after that. Use this information in regards to the values in 
 * the array and you will be able to come up with a straightforward 
 * solution. 
 */
class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int k = arr.length;
        boolean top = false;
        if (k < 3) {
            return false;
        }

        for (int i = 1; i < k; i++) {
            if (arr[i - 1] == arr[i]) {
                return false;
            }
            if (top == false) {
                if (arr[i - 1] > arr[i]) {
                    top = true;
                    if (i == 1) {
                        return false;
                    }
                }
            } else if (top == true) {
                if (arr[i - 1] < arr[i]) {
                    return false;
                }
            }
        }

        if (top == false) {
            return false;
        }
        return true;
    }
}
