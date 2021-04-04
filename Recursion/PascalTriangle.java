package Recursion;
/**
 * PROMPT:
 * Pascal's Triangle II
 * 
 * Given an integer rowIndex, return the rowIndexth 
 * (0-indexed) row of the Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of
 * the two numbers directly above it as shown:
 * 
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * 
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 * 
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 * 
 * Constraints:
 * 0 <= rowIndex <= 33
 * 
 * Follow up: Could you optimize your algorithm to use
 * only O(rowIndex) extra space?
 */

import java.util.ArrayList;
import java.util.List;

// First attempt failed, Time Exceeded at rowindex input of 30
// Need memoization technique to reduce duplicate calculations
class PascalTriangle {
    List<Integer> arr = new ArrayList<Integer>();
    public List<Integer> getRow(int rowIndex) {
        //first param rowIndex, second param length of array
        int len = rowIndex+1;
        return returnArray(rowIndex,len);
    }
    
    private int returnRowColValue(int i, int j){
        if(j==0 || j==i) {
            return 1;
        }else{
            return returnRowColValue(i-1,j-1) + returnRowColValue(i-1,j);    
        }
    }
    
    private List<Integer> returnArray(int row, int len){
        for(int j = 0;j<len;j++){
            arr.add(returnRowColValue(row,j));     
        }
        return arr;
    }
}

// Second attempted accepted using memoization technique to reduce
// duplicate calculations
class OptimizeSolution20 {
    List<Integer> arr;
    int[][]memo;
    public List<Integer> getRow(int rowIndex) {
        //first param rowIndex, second param length of array
        int len = rowIndex+1;
        return returnArray(rowIndex,len);
    }
    
    private int returnRow(int i, int j, int[][]memo){
        if(j==0 || j==i) {
            return 1;
        }
        
        if(memo[i][j]>0){
            return memo[i][j];
        }
        
        memo[i][j] = returnRow(i-1,j-1,memo) + returnRow(i-1,j,memo);
        return memo[i][j];
    }
    
    private List<Integer> returnArray(int row, int len){
        arr = new ArrayList<Integer>();
        memo = new int[row+1][len];
        for(int j = 0;j<len;j++){
            arr.add(returnRow(row,j,memo));     
        }
        return arr;
    }
}
