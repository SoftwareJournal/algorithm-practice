package String_Processing;

import java.util.Arrays;
import java.util.HashMap;

/**
 * PROMPT:
 * SHUFFLE STRING
 * 
 * You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 * 
 * Return the shuffled string.
 * 
 * Example 1:
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * Output: "leetcode"
 * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 * 
 * Example 2:
 * Input: s = "abc", indices = [0,1,2]
 * Output: "abc"
 * Explanation: After shuffling, each character remains in its position.
 * 
 * Constraints:
 * s.length == indices.length == n
 * 1 <= n <= 100
 * s consists of only lowercase English letters.
 * 0 <= indices[i] < n
 * All values of indices are unique.
 * 
 */

class ShuffleString {
    public String restoreString(String s, int[] indices) {
        int len = indices.length;
        //String method to turn String object to char[]
        char[] charArray = s.toCharArray();
        //Key is the original index, Value is the original String object
        HashMap<Integer, String> stringIndexMap = new HashMap<Integer, String>();
        for(int i = 0;i < len; i++){
            //Converting char to String object
            stringIndexMap.put(indices[i],String.valueOf(charArray[i]));
        }
        
        //Build a String object with StringBuilder object
        StringBuilder stringCreation = new StringBuilder();
        
        //Sort the indices with Java built-in function Arrays.sort(int[]); Time complexity is O(n*Log(n))   
        Arrays.sort(indices);
        for(int item : indices){
            stringCreation.append(stringIndexMap.get(item));
        }

        //StringBuilder method to turn StringBuilder object to String
        return stringCreation.toString();
    }
}