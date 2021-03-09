package Recursion;
/**
 * PROMPT:
 * SEARCH IN A BINARY SEARCH TREE
 * 
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the
 * subtree rooted with that node. If such a node does not exist, return null.
 * 
 * 
 * Example 1:
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * 
 * Example 2:
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 * 
 * Contstraints:
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 10^7
 * root is a binary search tree.
 * 1 <= val <= 10^7
 * 
 */


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

//Messy first attempt, but it works!!
public class SearchBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = search2(root,val);
        return node;
    }
    
    //recursively
    private TreeNode search(TreeNode root, int val){
        if(root!=null && root.val == val)
            return root;
        
        if(root.left!=null && root.left.val==val)
            return root.left;
        
        if(root.right!=null && root.right.val==val)
            return root.right;
        
        if(root == null)
            return null;
        
        TreeNode node = null;
        
        if(root.left!=null){
            node = search(root.left,val);    
        }
        if(root.right!=null && node == null){
            node = search(root.right,val);
        }
        
        return node;
    }

    //recursively and cleaner
    private TreeNode search2(TreeNode root, int val){
        if(root!=null && root.val == val)
            return root;
        
        if(root==null){
            return null;
        }
        
        TreeNode node = null;
        
        if(root.left!=null && root.val>val){
            node = search(root.left,val);    
        }else{
            node = search(root.right,val);
        }
        
        return node;
    }
}
