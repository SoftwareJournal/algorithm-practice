package Recursion;
/**
 * PROMPT:
 * FIBONACCI NUMBBER
 * 
 * You are climbing a staircase. It takes n steps to reach
 * the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many
 * distinct ways can you climb to the top?
 * 
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * Constraints:
 * 1 <= n <= 45
 */
// Time complexity O(2^n); Space Complexity O(n)
class ClimbingStairs {
    public int climbStairs(int n) {
        int possibilities = climb(n);
        return possibilities;
    }
    
    private int climb(int n){
        if(n<=3){
            return n;
        }
        
        return climb(n-1)+climb(n-2);
    }
}
//Time complexity O(n); Space Complexity O(n) using Memoization technique to reduce duplicate calculations
class BetterOptimizeSolution{
    public int climbStairs(int n) {
        int memo[] = new int[n+1];
        return climb(0,n,memo);
    }
    
    private int climb(int i, int n, int memo[]){
        if(n<=3){
            return n;
        }
        if(memo[i]>0){
            return memo[i];
        }

        memo[i]= climb(i+1,n-1, memo)+climb(i+2,n-2,memo);
        return memo[i];
    }
}