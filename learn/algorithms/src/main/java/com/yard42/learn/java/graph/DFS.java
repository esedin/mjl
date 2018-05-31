package com.yard42.learn.java.graph;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class DFS
{
   private static Set<TreeNode> visited = new LinkedHashSet<>();
   private static Stack<TreeNode> stack = new Stack<>();

   public static boolean hasNode(TreeNode root, TreeNode goalNode)
   {
      visited.add(root);
      stack.add(root);

      while (!stack.empty())
      {
         TreeNode currentNode = stack.pop();

         if (currentNode.equals(goalNode))
         {
            System.out.println(visited);
            return true;
         }
         else
         {
            stack.addAll(currentNode.getChildren());
         }

         visited.add(currentNode);
      }

      return false;
   }
}
