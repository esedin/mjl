package com.yard42.learn.java.graph;

import java.util.ArrayList;
import java.util.List;

public class TreeNode
{
   private long value;
   private List<TreeNode> nodes;

   public TreeNode(long value)
   {
      this.value = value;
      this.nodes = new ArrayList<>();
   }

   public void addNode(TreeNode newTreeNode)
   {
      this.nodes.add(newTreeNode);
   }

   public List<TreeNode> getChildren()
   {
      return nodes;
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      TreeNode treeNode = (TreeNode) o;

      return value == treeNode.value;
   }

   @Override
   public int hashCode()
   {
      return (int) (value ^ (value >>> 32));
   }

   @Override
   public String toString()
   {
      return "TreeNode{" +
         "value=" + value +
         '}';
   }
}
