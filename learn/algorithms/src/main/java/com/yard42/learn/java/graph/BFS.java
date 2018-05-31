package com.yard42.learn.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS
{
   public static boolean hasNode(TreeNode root, TreeNode goalNode)
   {
      Queue<TreeNode> queue = new LinkedList<>();
      List<TreeNode> visited = new ArrayList<>();

      if (root.equals(goalNode))
      {
         return true;
      }

      queue.add(root);

      while (!queue.isEmpty())
      {
         TreeNode current = queue.remove();
         if (current.equals(goalNode))
         {
            System.out.println(visited);
            return true;
         }
         else {
            if (current.getChildren().isEmpty())
            {
               return false;
            }
            else
            {
               queue.addAll(current.getChildren());
            }
         }
         visited.add(current);
      }

      return false;
   }
}
