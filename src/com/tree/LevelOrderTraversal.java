package com.tree;

import java.util.*;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		
		System.out.println(levelOrder(root));
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        
        List<Integer> level=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode front=q.peek();
            q.remove();
            
            if(front==null){
                result.add(new ArrayList<>(level));
                level.clear();
                if(!q.isEmpty())
                    q.add(null);
            }else{
                level.add(front.val);
                if(front.left!=null)
                    q.add(front.left);
                if(front.right!=null)
                    q.add(front.right);
            }
            
        }
        return result;
    }
}
