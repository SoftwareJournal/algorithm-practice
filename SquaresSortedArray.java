
/**
 * PROMPT:
 * SQUARES OF A SORTED ARRAY
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in 
 * non-decreasing order.
 * 
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * 
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * 
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * 
 * Follow up: Squaring each element and sorting the new
 * array is very trivial, could you find an O(n) solution
 * using a different approach? 
 */
import java.util.Arrays;

class Solution3 {
    public int[] sortedSquares(int[] nums) {
        int [] squares = new int[nums.length];
        int index = 0;
        for(int num: nums){
            squares[index] = num*num;
            index++;
        }        
        
        Arrays.sort(squares);
        return squares;
    }
}

class OptimizeSolution3{
    public int[] sortedSquares(int[] nums) {
        int k =  nums.length - 1;
        int lo = 0;
        int hi = k;
        int [] squares = new int[nums.length];
        
        //dual-pivot to sort array in ascending order
        for(int j = k;j>=0;j--){
            int los = nums[lo]*nums[lo];
            int his = nums[hi]*nums[hi];
            if(los<his){
                squares[j]=his;
                hi--;
            }else{
                squares[j]=los;
                lo++;
            }
        }        
      
        return squares;
    }

}
