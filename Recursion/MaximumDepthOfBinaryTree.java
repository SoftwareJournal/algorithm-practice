package Recursion;
/**
 * PROMPT:
 * MAXIMUM DEPTH OF BINARY TREE
 * 
 * Given the root of a binary tree, return
 * its maximum depth.
 * 
 * A binary tree's maximum depth is the number
 * of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * 
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * 
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 * 
 * Example 3:
 * Input: root = []
 * Output: 0
 * 
 * Example 4:
 * Input: root = [0]
 * Output: 1
 * 
 * Contstraints:
 * The number of nodes in the tree is in the range [0, 10^4].
 * -100 <= Node.val <= 100
 * 
 */

/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
*/

class MaximumDepthOfBinaryTree {
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        int n = 0;
        depthCal(root,n);
        return maxDepth;
    }
    
    //Time complexity: O(n); Space complexity: O(2^n) ???
    private void depthCal(TreeNode root,int n){
        if(root == null){
            return;
        }
        
        if(root!=null){
            n++;
            if(n>maxDepth){
                maxDepth = n;
            }    
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        depthCal(left,n);
        depthCal(right,n);
    }
}