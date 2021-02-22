package Recursion;
/**
 * PROMPT:
 * REVERSE STRING
 * 
 * Write a function that reverses a string. The 
 * input string is given as an array of characters
 * char[].
 * 
 * Do not allocate extra space for another array, 
 * you must do this by modifying the input array 
 * in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of
 * printable ascii characters.
 * 
 * Example 1:
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * 
 * Example 2:
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * Hint #1:
 * The entire logic for reversing a string is
 * based on using the opposite directional 
 * two-pointer approach!
 */
public class ReverseString {
    public void reverseString(char[] s) {
        s = helper(0,s);
    }

    public char[] helper(int index, char[] input){
        int l = input.length-1;
        // base case
        if(index == l - index || index > l - index){
           return input; 
        }
        
        char back = input[l - index];
        char front = input[index];
        input[l - index] = front;
        input[index] = back;
        
        return helper(index+1,input);
    }
}
