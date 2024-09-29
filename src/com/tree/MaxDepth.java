package com.tree;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/


public class MaxDepth {

    public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		
        System.out.println(maxDepth(root));
	}

    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left == null && root.right == null) return 1;

        int left = 0;
        int right = 0;
        if(root.left !=null)
            left =  maxDepth(root.left);
        if(root.right != null)
            right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }
    
}
