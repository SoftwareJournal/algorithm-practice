package HashTable;
/**
 * PROMPT:
 * NUMBER OF GOOD PAIRS
 * 
 * Given an array of integers nums.
 * A pair (i,j) is called good if nums[i] == nums[j]
 * and i < j.
 * 
 * Return the number of good pairs.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4),
 * (3,4), (2,5) 0-indexed.
 * 
 * Example 2:
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * 
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 0
 * 
 * Constraints:
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
import java.util.HashMap;

class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;

        // key:duplicate value, value: number of duplicates (containsValue(Object o), containsKey(Key k), values())
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }  
        }

        // Sum of good pairs
        for(int n:map.values()){
            goodPairs+=(n*(n-1))/2;
        }

        return goodPairs;
    }
}
