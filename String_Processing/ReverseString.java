package String_Processing;
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

 //O(n) time and O(1) space; n is the length of the string
class Solution {
    public void reverseString(char[] s) {
        int back = s.length-1;
        int front = 0;
        while(true){
            if(front == back - front || front > back-front){
                break;
            }
            char temp = s[back - front];
            s[back - front] = s[front];
            s[front] = temp;
            front++;
        }
    }
}
