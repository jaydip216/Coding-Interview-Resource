package com.dsa.tree;

import java.util.*;

public class Traversals {
	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		root.left=new TreeNode(9);
		root.right=new TreeNode(20);
		root.right.left=new TreeNode(15);
		root.right.right=new TreeNode(7);
		
		System.out.println(levelOrder(root)); //BFS
        System.out.println(levelOrder2(root));
        System.out.println(DFS(root));
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
                if(front.right!=null)
                    q.add(front.right);
                if(front.left!=null)
                    q.add(front.left);
            }
            
        }
        return result;
    }

    public static List<Integer> levelOrder2(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return result;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            result.add(node.val);
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
        return result;
    }

    public static List<Integer> DFS(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.left!=null){
                stack.add(node.left);
            } 
            if(node.right!=null){
                stack.add(node.right);
            }
        }
        return result;

    }
}
